package com.raoarsalan.core.interceptor

import android.content.Context
import com.raoarsalan.core.utils.SharedPref
import com.raoarsalan.data.datasource.remote.api.ITokenApi
import kotlinx.coroutines.runBlocking
import okhttp3.Dispatcher
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException


class HeaderInterceptor(val context: Context) : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {

        val pref = SharedPref(context)

        val dispatcher = Dispatcher()
        dispatcher.maxRequests = 1

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor())
            .dispatcher(dispatcher = dispatcher).build()

        val retrofit = Retrofit.Builder().baseUrl(
            "https://accounts.spotify.com/"
        ).client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create()).build()

        synchronized(this) {

            val originalRequest = chain.request()
            val authenticationRequest = originalRequest.newBuilder()
                .header(AUTHORIZATION, pref.getTokenType() ?: "Bearer" + " " + pref.getToken())
                .build()

            val initialResponse = chain.proceed(authenticationRequest)

            when (initialResponse.code) {
                401, 400 -> {


                    val newTokenResponse = runBlocking {

                        retrofit
                            .create(ITokenApi::class.java)
                            .getToken()
                            .execute()
                    }


                    return when {


                        newTokenResponse.code() == 200 -> {
                            newTokenResponse.body()?.let {
                                pref.setToken(it.accessToken)
                                pref.setTokenType(it.tokenType)
                            }

                            val newAuthenticationRequest = newTokenResponse.body()?.let {
                                originalRequest.newBuilder().addHeader(
                                    AUTHORIZATION,
                                    "${it.tokenType} ${it.accessToken}"
                                ).build()
                            }
                            initialResponse.close()
                            chain.proceed(newAuthenticationRequest!!)
                        }
                        else -> {
                            initialResponse
                        }
                    }
                }
                else -> return initialResponse
            }
        }

    }

    companion object {
        const val AUTHORIZATION = "Authorization"
    }

}

package com.raoarsalan.core.di

import com.raoarsalan.core.BuildConfig
import com.raoarsalan.core.interceptor.HeaderInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module
import java.util.concurrent.TimeUnit

object OkHttpModule {
    fun load() {
        loadKoinModules(okHttpModule)
    }

    private val okHttpModule = module {
        single {
            val okHttpBuilder = OkHttpClient()
                .newBuilder()
                .addInterceptor(get<HeaderInterceptor>())
                .addInterceptor(get<HttpLoggingInterceptor>())
                .connectTimeout(60, TimeUnit.SECONDS)
                .callTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
            okHttpBuilder.build()
        }

        single {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            if (BuildConfig.DEBUG)
                httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            else
                httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.NONE

            httpLoggingInterceptor
        }

        single {
            HeaderInterceptor(androidContext())
        }
    }
}
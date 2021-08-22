package com.raoarsalan.core.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitModule {
    fun load() {
        loadKoinModules(retrofitModule)
    }

    private val retrofitModule = module {
        single {
            Retrofit.Builder()
                .client(get())
                .addConverterFactory(getGsonConverterFactory())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("https://api.spotify.com/")
                .build() as Retrofit
        }
    }

    private fun getGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create(getGson())
    }

    private fun getGson(): Gson {
        val gsonBuilder = GsonBuilder()
        gsonBuilder.setDateFormat("d MMM yyyy HH:mm")
        return gsonBuilder.create()
    }
}
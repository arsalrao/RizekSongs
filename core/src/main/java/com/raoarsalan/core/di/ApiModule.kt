package com.raoarsalan.core.di

import com.raoarsalan.data.datasource.remote.api.ISpotifyApi
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module
import retrofit2.Retrofit

object ApiModule {
    fun load() {
        loadKoinModules(apiModules)
    }

    private val apiModules = module {

        single {
            get<Retrofit>().create(ISpotifyApi::class.java)
        }

    }
}
package com.raoarsalan.domain.di

import com.raoarsalan.domain.usecases.ISpotifyUseCase
import com.raoarsalan.domain.usecases.SpotifyUseCaseImpl
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

object UseCaseModule {
    fun load() {
        loadKoinModules(spotifyUseCaseModule)
    }

    private val spotifyUseCaseModule = module {
        factory<ISpotifyUseCase> { SpotifyUseCaseImpl(spotifyRepo = get()) }
    }
}
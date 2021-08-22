package com.raoarsalan.data.di

import com.raoarsalan.data.repository.SpotifyRepoImpl
import com.raoarsalan.domain.repo.ISpotifyRepo
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

object RepoModule {
    fun load() {
        loadKoinModules(repoModule)
    }

    private val repoModule = module {
        factory<ISpotifyRepo> { SpotifyRepoImpl(spotifyApi = get()) }
    }
}
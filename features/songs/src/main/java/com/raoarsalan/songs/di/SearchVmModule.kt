package com.raoarsalan.songs.di

import com.raoarsalan.songs.viewmodel.SearchTrackViewModel
import com.raoarsalan.songs.viewmodel.TrackDetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

object SearchVmModule {
    fun load() {
        loadKoinModules(module {
            viewModel {
                SearchTrackViewModel(get())
            }
            viewModel { TrackDetailsViewModel() }
        })
    }
}
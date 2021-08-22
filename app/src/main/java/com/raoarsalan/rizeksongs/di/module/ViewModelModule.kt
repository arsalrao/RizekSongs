package com.raoarsalan.rizeksongs.di.module

import com.raoarsalan.rizeksongs.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

object ViewModelModule {
    fun load() {
        loadKoinModules(module {
            viewModel {
                MainViewModel()
            }
        })
    }
}
package com.raoarsalan.rizeksongs.di.component

import com.raoarsalan.data.di.RepoModule
import com.raoarsalan.domain.di.UseCaseModule

object ApplicationComponent {
    fun loadModules() {
        RepoModule.load()
        UseCaseModule.load()
    }
}
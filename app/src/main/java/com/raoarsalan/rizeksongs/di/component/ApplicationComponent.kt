package com.raoarsalan.rizeksongs.di.component

import com.raoarsalan.core.di.ApiModule
import com.raoarsalan.core.di.OkHttpModule
import com.raoarsalan.core.di.RetrofitModule
import com.raoarsalan.data.di.RepoModule
import com.raoarsalan.domain.di.UseCaseModule
import com.raoarsalan.rizeksongs.di.module.ViewModelModule
import com.raoarsalan.songs.di.SearchVmModule

object ApplicationComponent {
    fun loadModules() {
        RetrofitModule.load()
        OkHttpModule.load()
        ApiModule.load()
        RepoModule.load()
        UseCaseModule.load()
        ViewModelModule.load()
        SearchVmModule.load()

    }
}
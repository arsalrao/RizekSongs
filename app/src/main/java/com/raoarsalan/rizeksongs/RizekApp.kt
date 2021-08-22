package com.raoarsalan.rizeksongs

import android.app.Application
import com.raoarsalan.rizeksongs.di.component.ApplicationComponent
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class RizekApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@RizekApp)

            // use Koin logger
            printLogger()
            // declare modules
            ApplicationComponent.loadModules()

        }


    }
}
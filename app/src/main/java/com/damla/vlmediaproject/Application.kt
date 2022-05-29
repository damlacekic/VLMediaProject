package com.damla.vlmediaproject

import android.app.Application
import com.damla.vlmediaproject.koin.KoinModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class Application : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@Application)
            modules(KoinModule.appModule)
        }
    }

}
package com.krayapp.inifintylist

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class InfinityApp:Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@InfinityApp)
            modules(Koin.getModules())
        }
    }
}
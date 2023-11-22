package com.sarumah.posbersama.util

import android.app.Application
import com.chibatching.kotpref.Kotpref
import com.hengki.aplicationtest.core.di.appModule
import com.hengki.aplicationtest.core.di.repositoryModule
import com.hengki.aplicationtest.core.di.viewModelModule
import com.inyongtisto.myhelper.extension.logs
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()

        // shared Pref
        Kotpref.init(this)

        // koin dependency injection
        startKoin {
            androidContext(this@MyApp)
            modules(listOf(appModule, viewModelModule, repositoryModule))
        }
    }
}
package com.hengki.aplicationtest.util

import android.app.Activity
import com.hengki.aplicationtest.core.di.appModule
import com.hengki.aplicationtest.core.di.repositoryModule
import com.hengki.aplicationtest.core.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin


fun Activity.recallKoin() {
    stopKoin()
    startKoin {
        androidContext(this@recallKoin)
        modules(listOf(appModule, viewModelModule, repositoryModule))
    }
}

fun String?.defaultError(): String = if (this.isNullOrEmpty()) Constants.DEFAULT_ERROR else this


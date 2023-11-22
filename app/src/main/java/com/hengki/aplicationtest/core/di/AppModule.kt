package com.hengki.aplicationtest.core.di


import androidx.room.Room
import com.hengki.aplicationtest.core.source.local.AppDatabase
import com.hengki.aplicationtest.core.source.local.LocalDataSource
import com.hengki.aplicationtest.core.source.remote.RemoteDataSource
import com.hengki.aplicationtest.core.source.remote.network.ApiConfig
import com.hengki.aplicationtest.util.Constants
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {

    single {
        Room.databaseBuilder(
                androidContext(),
                AppDatabase::class.java,
                Constants.DB_NAME
        ).allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
    }

    single { ApiConfig.provideApiService }

    single { LocalDataSource(get()) }

    single { RemoteDataSource(get()) }

}
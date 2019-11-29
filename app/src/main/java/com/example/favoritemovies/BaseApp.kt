package com.example.favoritemovies

import androidx.multidex.MultiDexApplication
import com.example.favoritemovies.di.*
import org.koin.android.ext.android.startKoin

class BaseApp: MultiDexApplication() {


    override fun onCreate() {
        super.onCreate()
//        if(BuildConfig.FLAVOR == "")
        startKoin(this, listOf(appModule, dbModule, presenterModule, repositoryModule, apiModule))
    }
}
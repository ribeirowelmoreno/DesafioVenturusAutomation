package com.example.favoritemovies.di

import android.content.Context
import com.example.favoritemovies.data.memory.MemoryCache
import com.example.favoritemovies.data.memory.MemoryCacheImpl
import com.example.favoritemovies.util.SchedulerProvider.ISchedulerProvider
import com.example.favoritemovies.util.SchedulerProvider.SchedulerProvider
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.module

val appModule = module {
    val prefsFileName = "university_planner_prefs"

    single { SchedulerProvider() as ISchedulerProvider }
    single { androidApplication().getSharedPreferences(prefsFileName, Context.MODE_PRIVATE) }
    single { MemoryCacheImpl() as MemoryCache }
}
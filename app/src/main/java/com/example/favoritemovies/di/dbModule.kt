package com.example.favoritemovies.di

import androidx.room.Room
import com.example.favoritemovies.data.database.AppRoom
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.Module
import org.koin.dsl.module.module

val dbModule: Module = module {
    val dbname = "favorite-movies-db"

    single {  Room.databaseBuilder(androidApplication(), AppRoom::class.java, dbname).build() }

    // Add all rooms in project

    single { get<AppRoom>().loginRoom() }
}
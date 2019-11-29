package com.example.favoritemovies.di

import android.util.Log
import com.example.favoritemovies.BuildConfig
import com.example.favoritemovies.data.api.MoviesAPI
import com.example.favoritemovies.data.api.MoviesAPIMock
import org.koin.dsl.module.Module
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


fun createRetrofit(): Retrofit {
    return Retrofit.Builder()
        .baseUrl("https://api.trakt.tv/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
}

val apiModule: Module = module {

    single { createRetrofit() }

    Log.i("FAVORITO", "${BuildConfig.BUILD_TYPE}, ${BuildConfig.FLAVOR}, ${BuildConfig.VERSION_NAME}, teeste")
    if (BuildConfig.FLAVOR == "api") {
        single { get<Retrofit>().create(MoviesAPI::class.java) }
    } else {
        single { MoviesAPIMock() as MoviesAPI}
    }
}
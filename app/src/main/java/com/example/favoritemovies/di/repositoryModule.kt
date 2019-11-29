package com.example.favoritemovies.di

import com.example.favoritemovies.data.repository.*
import org.koin.dsl.module.Module
import org.koin.dsl.module.module

val repositoryModule: Module = module {
    //Add all repositories in project
    single { LoginRepositoryImpl(get()) as LoginRepository }
    single { MoviesRepositoryImpl(get()) as MoviesRepository }
    single { FavoriteRepositoryImpl(get()) as FavoriteRepository }
}
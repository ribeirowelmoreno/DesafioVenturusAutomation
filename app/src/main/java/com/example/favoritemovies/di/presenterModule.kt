package com.example.favoritemovies.di

import com.example.favoritemovies.screens.main.favoriteList.FavoriteListPresenter
import com.example.favoritemovies.screens.main.movieList.MovieListPresenter
import com.example.favoritemovies.screens.sign.signin.SignInPresenter
import com.example.favoritemovies.screens.sign.signup.SignUpPresenter
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.Module
import org.koin.dsl.module.module

val presenterModule: Module = module {

    //Sign
    viewModel { SignInPresenter(get(), get()) }
    viewModel { SignUpPresenter(get(), get()) }
    viewModel { MovieListPresenter(get(), get(), get()) }
    viewModel { FavoriteListPresenter(get(), get())}


}
package com.example.favoritemovies.screens.main.movieList

import com.example.favoritemovies.base.view.BaseView
import com.example.favoritemovies.data.model.Movies

interface MovieListView: BaseView {

    fun refreshList(list: List<Movies>)
}
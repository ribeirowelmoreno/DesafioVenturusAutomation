package com.example.favoritemovies.screens.main.favoriteList

import com.example.favoritemovies.base.view.BaseView
import com.example.favoritemovies.data.model.Favorites

interface FavoriteListView: BaseView {

    fun refreshList(list: List<Favorites>)
}
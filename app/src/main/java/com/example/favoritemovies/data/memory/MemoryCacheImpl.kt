package com.example.favoritemovies.data.memory

import com.example.favoritemovies.data.model.Favorites

class MemoryCacheImpl: MemoryCache {

    private val favorites: ArrayList<Favorites> = arrayListOf()

    override fun addFavorite(favorite: Favorites) {
        if (favorites.find { f -> f == favorite } == null) {
            favorites.add(favorite)
        }
    }

    override fun getFavorites(): List<Favorites> {
        return favorites
    }

    override fun removeFavorite(favorite: Favorites) {
        favorites.remove(favorite)
    }

    override fun searchFavorite(title: String): Favorites? {
        return favorites.find { f -> f.title == title }
    }
}
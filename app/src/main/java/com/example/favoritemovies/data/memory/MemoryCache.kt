package com.example.favoritemovies.data.memory

import com.example.favoritemovies.data.model.Favorites

interface MemoryCache {

    fun addFavorite(favorite: Favorites)
    fun getFavorites(): List<Favorites>
    fun removeFavorite(favorite: Favorites)
    fun searchFavorite(title: String): Favorites?

}
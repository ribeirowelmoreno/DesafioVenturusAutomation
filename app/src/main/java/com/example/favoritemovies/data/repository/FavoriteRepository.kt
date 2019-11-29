package com.example.favoritemovies.data.repository

import com.example.favoritemovies.data.model.Favorites
import io.reactivex.Observable

interface FavoriteRepository {

    fun insertFavorite(movie: Favorites)
    fun getFavorites(): Observable<List<Favorites>>
    fun removeFavorite(movie: Favorites)
    fun searchFavorite(title: String): Observable<Favorites?>
}
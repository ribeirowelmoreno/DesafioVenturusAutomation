package com.example.favoritemovies.data.repository

import com.example.favoritemovies.data.memory.MemoryCache
import com.example.favoritemovies.data.model.Favorites
import io.reactivex.Observable

class FavoriteRepositoryImpl(private val db: MemoryCache) : FavoriteRepository {

    override fun insertFavorite(movie: Favorites) {
        return db.addFavorite(movie)
    }

    override fun getFavorites(): Observable<List<Favorites>> {
        return Observable.just(db.getFavorites())
    }

    override fun removeFavorite(movie: Favorites) {
        return db.removeFavorite(movie)
    }

    override fun searchFavorite(title: String): Observable<Favorites?> {
        val result = db.searchFavorite(title)
        if (result != null) {
            return Observable.just(result)
        } else {
            return Observable.error(Throwable())
        }
    }
}
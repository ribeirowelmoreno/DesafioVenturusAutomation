package com.example.favoritemovies.data.repository

import com.example.favoritemovies.data.api.MoviesAPI
import com.example.favoritemovies.data.model.Movies
import io.reactivex.Observable

class MoviesRepositoryImpl(private val api: MoviesAPI): MoviesRepository {

    override fun getMoviesList(page: Int): Observable<List<Movies>> {
        return api.getMoviesList(page)
    }
}
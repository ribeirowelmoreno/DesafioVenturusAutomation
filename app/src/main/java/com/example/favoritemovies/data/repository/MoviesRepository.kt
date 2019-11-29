package com.example.favoritemovies.data.repository

import com.example.favoritemovies.data.model.Movies
import io.reactivex.Observable

interface MoviesRepository {

    fun getMoviesList(page: Int): Observable<List<Movies>>
}
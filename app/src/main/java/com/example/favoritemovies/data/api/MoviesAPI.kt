package com.example.favoritemovies.data.api

import com.example.favoritemovies.data.model.Movies
import com.example.favoritemovies.util.API_KEY
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface MoviesAPI {

    @Headers(
        "trakt-api-version: 2",
        "trakt-api-key: $API_KEY",
        "Content-Type: application/json"
    )
    @GET("movies/popular?limit=10&extended=full")
    fun getMoviesList(@Query("page") page: Int): Observable<List<Movies>>
}

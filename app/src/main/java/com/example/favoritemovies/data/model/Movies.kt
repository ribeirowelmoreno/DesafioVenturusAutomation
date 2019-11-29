package com.example.favoritemovies.data.model

class Movies {
    var title: String = ""
    var year: Long = 0
    var overview: String = ""
    var trailer: String = ""
    var rating: Double = 0.0
    var genres: List<String> = listOf()

    fun set(title: String, year: Long, overview: String, trailer: String, rating: Double, genres: List<String>): Movies {
        this.title = title
        this.year = year
        this.overview = overview
        this.trailer = trailer
        this.rating = rating
        this.genres = genres
        return this
    }

}

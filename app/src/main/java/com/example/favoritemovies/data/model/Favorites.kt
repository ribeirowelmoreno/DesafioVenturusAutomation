package com.example.favoritemovies.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorites")
data class Favorites(
    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    var title: String = "",
    var year: Long = 0,
    var rating: Double = 0.0
)
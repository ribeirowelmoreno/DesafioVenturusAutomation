package com.example.favoritemovies.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    var name: String = "",
    var email: String = "",
    var password: String = "",
    var phone: String = "",
    var document: String = ""
)
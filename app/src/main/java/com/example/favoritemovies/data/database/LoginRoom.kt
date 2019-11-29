package com.example.favoritemovies.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.favoritemovies.data.model.User
import io.reactivex.Single

@Dao
interface LoginRoom {

    @Query("SELECT * FROM user WHERE email = :email AND password = :password")
    fun doLogin(email: String, password: String): Single<User>

    @Insert
    fun createUser(user: User): Long
}
package com.example.favoritemovies.data.repository

import com.example.favoritemovies.data.model.User
import io.reactivex.Observable

interface LoginRepository {

    fun doLogin(email: String, password: String): Observable<User>
    fun createUser(user: User): Long
}
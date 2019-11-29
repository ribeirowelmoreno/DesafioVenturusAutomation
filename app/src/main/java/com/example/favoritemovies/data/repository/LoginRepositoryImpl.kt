package com.example.favoritemovies.data.repository

import com.example.favoritemovies.data.database.LoginRoom
import com.example.favoritemovies.data.model.User
import io.reactivex.Observable

class LoginRepositoryImpl(private val db: LoginRoom): LoginRepository {

    override fun doLogin(email: String, password: String): Observable<User> {
        return db.doLogin(email, password).toObservable()
    }

    override fun createUser(user: User): Long {
        return db.createUser(user)
    }
}
package com.example.favoritemovies.screens.sign.signup

import android.util.Log
import com.example.favoritemovies.base.presenter.BasePresenter
import com.example.favoritemovies.data.model.User
import com.example.favoritemovies.data.repository.LoginRepository
import com.example.favoritemovies.util.SchedulerProvider.ISchedulerProvider
import io.reactivex.Observable

class SignUpPresenter(
    private val scheduler: ISchedulerProvider,
    private val repository: LoginRepository): BasePresenter<SignUpView>() {

    fun createUser(user: User) {
        val disposable = Observable.just(repository)
            .subscribeOn(scheduler.io())
            .subscribe {

                val response = it.createUser(user)
                Log.i("LOGIN", "$response")
                if (response > 0) {
                    getView().onComplete()
                } else {
                    getView().onError()
                }
            }
        disposableBag?.add(disposable)
    }


}
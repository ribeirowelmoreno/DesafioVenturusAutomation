package com.example.favoritemovies.screens.sign.signin

import android.util.Log
import com.example.favoritemovies.base.presenter.BasePresenter
import com.example.favoritemovies.data.repository.LoginRepository
import com.example.favoritemovies.util.SchedulerProvider.ISchedulerProvider

class SignInPresenter(
    private val schedulerProvider: ISchedulerProvider,
    private val repository: LoginRepository
) : BasePresenter<SignInView>() {

    fun doLogin(username: String, password: String) {
        getView().toggleLoad(true)
        Log.i("LOGIN", "$username, $password")
        val disposable = repository.doLogin(username, password)
            .observeOn(schedulerProvider.ui())
            .subscribeOn(schedulerProvider.io())
            .subscribe ({
                getView().toggleLoad(false)
                getView().onLogin()
            },{
                Log.i("LOGIN", "$it")
                getView().toggleLoad(false)
                getView().onError()
            })
        disposableBag?.add(disposable)
    }

}
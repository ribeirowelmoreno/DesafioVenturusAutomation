package com.example.favoritemovies.screens.sign.signin

import com.example.favoritemovies.base.view.BaseView

interface SignInView: BaseView {
    fun onLogin()
    fun onError()
    fun toggleLoad(show: Boolean)
    fun toggleLoginEnabled(enable: Boolean)
}
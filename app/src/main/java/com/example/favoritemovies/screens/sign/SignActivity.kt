package com.example.favoritemovies.screens.sign

import com.example.favoritemovies.R
import com.example.favoritemovies.base.view.BaseActivity
import com.example.favoritemovies.screens.sign.signin.SignInFragment
import com.example.favoritemovies.screens.sign.signup.SignUpFragment
import kotlinx.android.synthetic.main.sign_view.*
import org.koin.android.viewmodel.ext.android.viewModel

class SignActivity: BaseActivity(), SignView {

    override fun attachView() {}

    override fun detachView() {}

    override fun getLayoutId(): Int = R.layout.sign_view

    override fun onViewReady() {
    }

    override fun onInit() {
        openSignIn()
    }

    override fun openSignIn() {
        replaceFragment(SignInFragment.newInstance(), sign_container)
    }

    override fun openSignUp() {
        replaceFragment(SignUpFragment.newInstance(), sign_container)
    }
}
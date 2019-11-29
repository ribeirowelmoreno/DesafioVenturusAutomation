package com.example.favoritemovies.screens.sign.signin

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.favoritemovies.R
import com.example.favoritemovies.base.view.BaseFragment
import com.example.favoritemovies.screens.main.MainActivity
import com.example.favoritemovies.screens.sign.SignActivity
import com.jakewharton.rxbinding2.view.clicks
import com.jakewharton.rxbinding2.widget.textChanges
import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import kotlinx.android.synthetic.main.sign_in_view.*
import org.koin.android.viewmodel.ext.android.viewModel

class SignInFragment : BaseFragment(), SignInView {

    companion object {
        fun newInstance(): SignInFragment {
            val args = Bundle()
            val fragment = SignInFragment()
            fragment.arguments = args
            return fragment
        }
    }

    private val mPresenter: SignInPresenter by viewModel()

    override fun attachView() {
        mPresenter.onAttach(this)
    }

    override fun detachView() {
        mPresenter.onDetach()
    }

    override fun getLayoutId(): Int = R.layout.sign_in_view

    override fun onViewReady() {
        val emailObserver = sign_in_email.textChanges().skipInitialValue()
        val passObserver = sign_in_password.textChanges().skipInitialValue()
        val isEnabled: Observable<Boolean> =
            Observable.combineLatest(emailObserver, passObserver, BiFunction { email, pass ->
                return@BiFunction email.isNotBlank() && email.isNotEmpty() && pass.isNotEmpty() && pass.isNotBlank()
            })
        disposableBag.addAll(
            sign_in_register_btn.clicks().subscribe { (activity as SignActivity).openSignUp() },
            sign_in_login_btn.clicks().subscribe {
                mPresenter.doLogin(
                    sign_in_email.text.toString().toLowerCase(),
                    sign_in_password.text.toString()
                )
            }, isEnabled.subscribe { toggleLoginEnabled(it) }
        )
    }

    override fun onLogin() {
        startActivity(Intent(this.context, MainActivity::class.java))
    }

    override fun onError() {
        sign_in_error_message.visibility = View.VISIBLE
    }

    override fun toggleLoad(show: Boolean) {
        sign_in_progress_layout.visibility = if (show) View.VISIBLE else View.GONE
    }

    override fun toggleLoginEnabled(enable: Boolean) {
        sign_in_login_btn.isEnabled = true
        if (enable) {
            sign_in_login_btn.setBackgroundColor(resources.getColor(R.color.white))
        } else {
            sign_in_login_btn.setBackgroundColor(resources.getColor(R.color.disabled))
        }
    }
}
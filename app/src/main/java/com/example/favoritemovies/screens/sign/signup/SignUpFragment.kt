package com.example.favoritemovies.screens.sign.signup

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.favoritemovies.R
import com.example.favoritemovies.base.view.BaseFragment
import com.example.favoritemovies.data.model.User
import com.example.favoritemovies.util.FormValidator
import com.jakewharton.rxbinding2.view.clicks
import kotlinx.android.synthetic.main.sign_up_view.*
import org.koin.android.viewmodel.ext.android.viewModel

class SignUpFragment : BaseFragment(), SignUpView {

    companion object {
        fun newInstance(): SignUpFragment {
            val args = Bundle()
            val fragment = SignUpFragment()
            fragment.arguments = args
            return fragment
        }
    }

    private val mPresenter: SignUpPresenter by viewModel()

    override fun attachView() {
        mPresenter.onAttach(this)
    }

    override fun detachView() {
        mPresenter.onDetach()
    }

    override fun getLayoutId(): Int = R.layout.sign_up_view

    override fun onViewReady() {
        disposableBag.add(
            sign_up_cancel_btn.clicks().subscribe {
                activity?.supportFragmentManager?.popBackStack()
            }
        )
        disposableBag.add(
            sign_up_register_btn.clicks().subscribe {
                onRegister()
            }
        )
    }

    private fun onRegister() {
        val validName = register_name.text.toString().isNotEmpty()
        val validDoc = FormValidator.validateCPF(register_document.text.toString())
        val validPhone = register_phone.rawText?.length == 11
        val validEmail = FormValidator.validateEmail(register_email.text.toString())
        val validEmailConfirm =
            register_email.text.toString().toLowerCase() == register_email_confirm.text.toString().toLowerCase()
        val validPass = FormValidator.validatePass(register_password.text.toString())
        val validPassConfirm = register_password.text.toString() == register_password_confirm.text.toString()
        register_invalid_doc.visibility = if (validDoc) View.GONE else View.VISIBLE
        register_invalid_phone.visibility = if (validPhone) View.GONE else View.VISIBLE
        register_invalid_email.visibility = if (validEmail) View.GONE else View.VISIBLE
        register_invalid_email_confirm.visibility = if (validEmailConfirm) View.GONE else View.VISIBLE
        register_invalid_pass.visibility = if (validPass) View.GONE else View.VISIBLE
        register_invalid_pass_confirm.visibility = if (validPassConfirm) View.GONE else View.VISIBLE
        if (validName && validDoc && validPhone && validEmail && validEmailConfirm && validPass && validPassConfirm) {
            val pUser = User(
                0,
                register_name.text.toString(),
                register_email.text.toString().toLowerCase(),
                register_password.text.toString(),
                register_phone.text.toString(),
                register_document.text.toString()
            )
            mPresenter.createUser(pUser)
        }
    }

    override fun onError() {
        Toast.makeText(this.context, R.string.create_user_error, Toast.LENGTH_LONG).show()
    }

    override fun onComplete() {
        activity?.supportFragmentManager?.popBackStack()
    }
}
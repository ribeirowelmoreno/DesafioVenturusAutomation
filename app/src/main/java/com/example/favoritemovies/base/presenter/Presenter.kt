package com.example.favoritemovies.base.presenter

import com.example.favoritemovies.base.view.BaseView

interface Presenter<V> where V : BaseView {
    fun getView(): V

    fun onAttach(view: V)
    fun onDetach()

}
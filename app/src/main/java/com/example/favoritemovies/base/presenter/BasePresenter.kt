package com.example.favoritemovies.base.presenter

import androidx.lifecycle.ViewModel
import com.example.favoritemovies.base.view.BaseView
import io.reactivex.disposables.CompositeDisposable

abstract class BasePresenter<V>: Presenter<V>, ViewModel() where V: BaseView {

    private var view: V? = null

    protected var disposableBag: CompositeDisposable? = null

    override fun getView(): V {
        return view!!
    }

    override fun onAttach(view: V) {
        this.view = view
        this.disposableBag = CompositeDisposable()
    }

    override fun onDetach() {
        this.disposableBag?.dispose()
        view = null
    }

}
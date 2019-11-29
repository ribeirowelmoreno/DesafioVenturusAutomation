package com.example.favoritemovies.base.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import io.reactivex.disposables.CompositeDisposable

abstract class BaseFragment : Fragment(), BaseView {

    protected val disposableBag = CompositeDisposable()
    private var mActivity: BaseActivity? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return if (getLayoutId() > 0) {
            inflater.inflate(getLayoutId(), container, false)
        } else {
            null
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        attachView()
        onViewReady()
        if (savedInstanceState == null) {
            onInit()
        }
    }


    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is BaseActivity) {
            mActivity = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        mActivity = null
    }



    override fun onDestroy() {
        disposableBag.dispose()
        detachView()
        super.onDestroy()
    }


    override fun onInit() {}

}
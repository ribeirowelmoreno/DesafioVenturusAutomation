package com.example.favoritemovies.screens.main.favoriteList

import android.os.Bundle
import com.example.favoritemovies.R
import com.example.favoritemovies.base.view.BaseFragment
import com.example.favoritemovies.data.model.Favorites
import kotlinx.android.synthetic.main.favorite_list_view.*
import org.koin.android.viewmodel.ext.android.viewModel

class FavoriteListFragment: BaseFragment(), FavoriteListView {

    companion object {
        fun newInstance(): FavoriteListFragment {
            val args = Bundle()
            val fragment = FavoriteListFragment()
            fragment.arguments = args
            return fragment
        }
    }

    private val mPresenter: FavoriteListPresenter by viewModel()
    private val mAdapter = FavoriteListAdapter()

    override fun attachView() {
        mPresenter.onAttach(this)
    }

    override fun detachView() {
        mPresenter.onDetach()
    }

    override fun getLayoutId(): Int = R.layout.favorite_list_view


    override fun onViewReady() {
        favorite_recycler_view.adapter = mAdapter
        disposableBag.add(mAdapter.onUnfavorite.subscribe { mPresenter.removeFavorite(it) })
        mPresenter.getFavoriteList()
    }

    override fun refreshList(list: List<Favorites>) {
        mAdapter.refreshTable(list)
    }
}
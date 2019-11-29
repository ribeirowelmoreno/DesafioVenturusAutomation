package com.example.favoritemovies.screens.main.movieList

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.recyclerview.widget.SimpleItemAnimator
import com.example.favoritemovies.R
import com.example.favoritemovies.base.view.BaseFragment
import com.example.favoritemovies.data.model.Movies
import kotlinx.android.synthetic.main.movies_list_view.*
import org.koin.android.viewmodel.ext.android.viewModel

class MovieListFragment : BaseFragment(), MovieListView {

    companion object {
        fun newInstance(): MovieListFragment {
            val args = Bundle()
            val fragment = MovieListFragment()
            fragment.arguments = args
            return fragment
        }
    }

    private val mPresenter: MovieListPresenter by viewModel()
    private val mAdapter: MovieListAdapter = MovieListAdapter()

    override fun attachView() {
        mPresenter.onAttach(this)
    }

    override fun detachView() {
        mPresenter.onDetach()
    }

    override fun getLayoutId(): Int = R.layout.movies_list_view

    override fun onViewReady() {
        (movie_list_recycler_view.itemAnimator as SimpleItemAnimator).supportsChangeAnimations = false
        movie_list_recycler_view.adapter = mAdapter
        disposableBag.addAll(
            mAdapter.onWatchTrailer.subscribe {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(it.trailer)))
            },
            mAdapter.onFavorite
                .subscribe {
//                    Log.i("FAVORITOS", "ON FAVORITE")
                mPresenter.searchFavorite(it)
            }
        )
        mPresenter.getMoviesList()
    }

    override fun refreshList(list: List<Movies>) {
        mAdapter.refreshTable(list)
    }
}
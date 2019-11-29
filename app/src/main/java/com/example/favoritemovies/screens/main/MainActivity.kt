package com.example.favoritemovies.screens.main

import com.example.favoritemovies.R
import com.example.favoritemovies.base.view.BaseActivity
import com.example.favoritemovies.base.view.BaseView
import com.example.favoritemovies.screens.main.favoriteList.FavoriteListFragment
import com.example.favoritemovies.screens.main.movieList.MovieListFragment
import kotlinx.android.synthetic.main.main_view.*


class MainActivity : BaseActivity(), BaseView {

    override fun attachView() {}

    override fun detachView() {}

    override fun getLayoutId(): Int = R.layout.main_view

    override fun onViewReady() {
        replaceFragment(MovieListFragment.newInstance(), view_container)
        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_list -> {
                    replaceFragment(MovieListFragment.newInstance(), view_container)
                }
                R.id.nav_favorites -> {
                    replaceFragment(FavoriteListFragment.newInstance(), view_container)
                }
                else -> {
                    replaceFragment(MovieListFragment.newInstance(), view_container)
                }
            }
            return@setOnNavigationItemSelectedListener true
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (supportFragmentManager.fragments.isEmpty()) {
            finish()
        }
    }


}
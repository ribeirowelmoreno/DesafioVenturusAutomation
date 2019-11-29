package com.example.favoritemovies.screens.main.favoriteList

import android.util.Log
import com.example.favoritemovies.base.presenter.BasePresenter
import com.example.favoritemovies.data.model.Favorites
import com.example.favoritemovies.data.repository.FavoriteRepository
import com.example.favoritemovies.util.SchedulerProvider.ISchedulerProvider
import io.reactivex.Observable

class FavoriteListPresenter(
    private val scheduler: ISchedulerProvider,
    private val repository: FavoriteRepository
): BasePresenter<FavoriteListView>() {

    fun getFavoriteList() {
        val disposable = repository.getFavorites()
            .observeOn(scheduler.ui())
            .subscribeOn(scheduler.io())
            .subscribe {
                Log.i("FAVORITO", "$it")
                getView().refreshList(it)
            }
        disposableBag?.add(disposable)
    }

    fun removeFavorite(favorite: Favorites) {
        val disposable = Observable.just(repository)
            .subscribeOn(scheduler.io())
            .subscribe {
                it.removeFavorite(favorite)
            }
        disposableBag?.add(disposable)
    }

}
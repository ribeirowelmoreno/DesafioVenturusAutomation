package com.example.favoritemovies.screens.main.movieList

import android.util.Log
import com.example.favoritemovies.base.presenter.BasePresenter
import com.example.favoritemovies.data.model.Favorites
import com.example.favoritemovies.data.model.Movies
import com.example.favoritemovies.data.repository.FavoriteRepository
import com.example.favoritemovies.data.repository.MoviesRepository
import com.example.favoritemovies.util.SchedulerProvider.ISchedulerProvider
import io.reactivex.Observable

class MovieListPresenter(
    private val scheduler: ISchedulerProvider,
    private val movieRepository: MoviesRepository,
    private val favoriteRepository: FavoriteRepository): BasePresenter<MovieListView>() {


    fun getMoviesList() {
        val disposable = movieRepository.getMoviesList(20)
            .observeOn(scheduler.ui())
            .subscribeOn(scheduler.io())
            .subscribe {
                getView().refreshList(it)
            }
        disposableBag?.add(disposable)
    }

    fun searchFavorite(movie: Movies) {
        val disposable = favoriteRepository.searchFavorite(movie.title)
            .observeOn(scheduler.ui())
            .subscribeOn(scheduler.io())
            .subscribe({
                if (it != null) {
                    Log.i("FAVORITOS", "$it")
                } else {
                    Log.i("FAVORITOS", "TESTE")
                }
            }, {
                Log.i("FAVORITOS", "$it")
                insertFavorite(movie)
            })
        disposableBag?.add(disposable)
    }

    private fun insertFavorite(movie: Movies) {
        val favorite = Favorites(0, movie.title, movie.year, movie.rating)
        val disposable = Observable.just(favoriteRepository)
            .subscribeOn(scheduler.io())
            .subscribe {
                it.insertFavorite(favorite)
            }
        disposableBag?.add(disposable)
    }
}
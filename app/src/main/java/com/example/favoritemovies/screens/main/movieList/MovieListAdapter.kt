package com.example.favoritemovies.screens.main.movieList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.favoritemovies.R
import com.example.favoritemovies.data.model.Movies
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.movies_list_item.view.*
import java.text.DecimalFormat

class MovieListAdapter: RecyclerView.Adapter<MovieListAdapter.MovieListViewHolder>() {

    private var adapterList: List<Movies> = listOf()
    private var expandedPosition: Int? = null

    var onWatchTrailer: PublishSubject<Movies> = PublishSubject.create()
    var onFavorite: PublishSubject<Movies> = PublishSubject.create()

    class MovieListViewHolder(item: View) : RecyclerView.ViewHolder(item)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewHolder {
        return MovieListViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.movies_list_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return adapterList.count()
    }

    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {
        val view = holder.itemView
        val item = adapterList[position]
        val isExpanded = position == expandedPosition
        val decimalFormat = DecimalFormat("##.#")
        view.setOnClickListener(null)
        view.movie_add_favorite.setOnClickListener(null)
        view.movie_name.text = item.title
        view.movie_year.text = item.year.toString()
        view.movie_rating.text = "${decimalFormat.format(item.rating)}/10"

        view.movie_expandable_layout.visibility = if(isExpanded) View.VISIBLE else View.GONE
        if (isExpanded) {
            view.movie_gender.text = android.text.TextUtils.join(", ", item.genres)
            view.movie_overview.text = item.overview
            view.movie_trailer.setOnClickListener { onWatchTrailer.onNext(item) }
        }

        view.setOnClickListener{expandItem(view, position, isExpanded)}
        view.movie_add_favorite.setOnClickListener {onFavorite.onNext(item)}
    }

    private fun expandItem(view: View, position: Int, isExpanded: Boolean) {
        val lastExpandedPosition = expandedPosition
        expandedPosition = if (isExpanded) null else position
        notifyItemChanged(position)
        if (expandedPosition != null && lastExpandedPosition != null) {
            notifyItemChanged(lastExpandedPosition)
        }
    }

    fun refreshTable(list: List<Movies>){
        adapterList = list
        notifyDataSetChanged()
    }
}
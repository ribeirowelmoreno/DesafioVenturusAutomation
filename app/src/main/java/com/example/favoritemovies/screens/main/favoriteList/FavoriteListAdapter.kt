package com.example.favoritemovies.screens.main.favoriteList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.favoritemovies.R
import com.example.favoritemovies.data.model.Favorites
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.favorite_list_item.view.*
import java.text.DecimalFormat

class FavoriteListAdapter: RecyclerView.Adapter<FavoriteListAdapter.FavoriteListListViewHolder>() {

    private var adapterList: List<Favorites> = listOf()

    var onUnfavorite: PublishSubject<Favorites> = PublishSubject.create()

    class FavoriteListListViewHolder(item: View) : RecyclerView.ViewHolder(item)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteListListViewHolder {
        return FavoriteListListViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.favorite_list_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return adapterList.count()
    }

    override fun onBindViewHolder(holder: FavoriteListListViewHolder, position: Int) {
        val view = holder.itemView
        val item = adapterList[position]
        val decimalFormat = DecimalFormat("##.#")
        view.setOnClickListener(null)
        view.movie_name.text = item.title
        view.movie_year.text = item.year.toString()
        view.movie_rating.text = "${decimalFormat.format(item.rating)}/10"

        view.movie_remove_favorite.setOnClickListener {onUnfavoriteListener(item)}
    }

    fun refreshTable(list: List<Favorites>){
        adapterList = list
        notifyDataSetChanged()
    }

    private fun onUnfavoriteListener(item: Favorites) {
        val mutableList: ArrayList<Favorites> = arrayListOf()
        mutableList.addAll(adapterList)
        mutableList.remove(item)
        adapterList = mutableList
        notifyDataSetChanged()
        onUnfavorite.onNext(item)
    }
}
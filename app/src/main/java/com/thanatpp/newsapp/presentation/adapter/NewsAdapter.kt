package com.thanatpp.newsapp.presentation.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.thanatpp.newsapp.domain.model.ArticlesModel

class NewsAdapter(
    private val items: List<ArticlesModel>,
    private val onClickItem: (View, ArticlesModel) -> Unit,
    private val deleteAble: Boolean = false,
    private val onClickDelete: (ArticlesModel) -> Unit = {},
) : RecyclerView.Adapter<NewsCardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsCardViewHolder {
        return NewsCardViewHolder.newInstance(parent, onClickItem, deleteAble, onClickDelete)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: NewsCardViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }
}
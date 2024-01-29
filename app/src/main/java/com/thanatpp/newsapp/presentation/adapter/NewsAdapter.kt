package com.thanatpp.newsapp.presentation.adapter

import android.content.DialogInterface
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.thanatpp.newsapp.data.network.response.Articles
import com.thanatpp.newsapp.domain.model.ArticlesModel

class NewsAdapter(
    private val items: List<ArticlesModel>,
    private val onClickItem: (ArticlesModel) -> Unit
) : RecyclerView.Adapter<NewsCardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsCardViewHolder {
        return NewsCardViewHolder.newInstance(parent, onClickItem)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: NewsCardViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
        holder.itemView.setOnClickListener {
            onClickItem(item)
        }
    }
}
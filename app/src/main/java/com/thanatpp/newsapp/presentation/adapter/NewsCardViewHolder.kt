package com.thanatpp.newsapp.presentation.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.thanatpp.newsapp.data.network.response.Articles
import com.thanatpp.newsapp.databinding.ViewNewsCardBinding
import com.thanatpp.newsapp.domain.model.ArticlesModel

class NewsCardViewHolder(
    private val binding: ViewNewsCardBinding,
    private val onItemClicked: (ArticlesModel) -> Unit
) :
    RecyclerView.ViewHolder(binding.root)  {

    fun bind(item: ArticlesModel) {
        Glide.with(binding.root)
            .load(item.imageUrl)
            .into(binding.imageViewNews);

        binding.textViewTitle.text = item.title
        binding.textViewDesc.text = item.description
        binding.newsCard.setOnClickListener {
            onItemClicked(item)
        }
    }


    companion object {
        fun newInstance(
            parent: ViewGroup,
            onItemClicked: (ArticlesModel) -> Unit
        ): NewsCardViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = ViewNewsCardBinding.inflate(inflater, parent, false)
            return NewsCardViewHolder(binding, onItemClicked)
        }
    }
}

package com.thanatpp.newsapp.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.thanatpp.newsapp.databinding.ViewNewsCardBinding
import com.thanatpp.newsapp.domain.model.ArticlesModel

class NewsCardViewHolder(
    private val binding: ViewNewsCardBinding,
    private val onItemClicked: (View, ArticlesModel) -> Unit
) :
    RecyclerView.ViewHolder(binding.root)  {

    fun bind(item: ArticlesModel) {
        Glide.with(binding.root)
            .load(item.imageUrl)
            .into(binding.imageViewNews);

        binding.textViewTitle.text = item.title
        binding.textViewDesc.text = item.description
        binding.textViewDateTime.text = item.dateTime
        binding.newsCard.setOnClickListener {
            onItemClicked(binding.newsCard, item)
        }
    }


    companion object {
        fun newInstance(
            parent: ViewGroup,
            onItemClicked: (View, ArticlesModel) -> Unit
        ): NewsCardViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = ViewNewsCardBinding.inflate(inflater, parent, false)
            return NewsCardViewHolder(binding, onItemClicked)
        }
    }
}


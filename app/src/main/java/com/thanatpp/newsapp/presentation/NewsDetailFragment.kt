package com.thanatpp.newsapp.presentation

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.navigation.fragment.navArgs
import com.thanatpp.newsapp.R
import com.thanatpp.newsapp.data.Example
import com.thanatpp.newsapp.data.network.response.Articles
import com.thanatpp.newsapp.databinding.FragmentNewsDetailBinding
import com.thanatpp.newsapp.domain.model.ArticlesModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsDetailFragment : BaseFragment<FragmentNewsDetailBinding>(
    R.layout.fragment_news_detail,
    FragmentNewsDetailBinding::bind
) {
    companion object {
        fun newAction(
            articles: ArticlesModel
        ): NewsFragmentDirections.ActionNewsFragmentToNewsDetailFragment {
            return NewsFragmentDirections.actionNewsFragmentToNewsDetailFragment(articles)
        }
    }

    private val args: NewsDetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textTitle.text = args.articlesModel.title
        binding.textDetail.text = args.articlesModel.description
    }
}
package com.thanatpp.newsapp.presentation

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isGone
import androidx.fragment.app.viewModels
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigatorExtras
import com.thanatpp.newsapp.R
import com.thanatpp.newsapp.data.Example
import com.thanatpp.newsapp.data.network.response.Articles
import com.thanatpp.newsapp.databinding.FragmentNewsBinding
import com.thanatpp.newsapp.domain.model.ArticlesModel
import com.thanatpp.newsapp.presentation.adapter.NewsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsFragment :
    BaseFragment<FragmentNewsBinding>(R.layout.fragment_news, FragmentNewsBinding::bind) {

    private val newsViewModel: NewsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObserveLiveData()
    }

    private fun setupObserveLiveData() {
        with(newsViewModel) {
            newsArticle.observe(viewLifecycleOwner) {
                binding.recyclerViewNews.adapter = NewsAdapter(it.articleList, onClickItem)
            }
        }
    }

    private val onClickItem = fun(view: View, articles: ArticlesModel) {
        val extras = FragmentNavigatorExtras(view to "news_transition_name")
        val action = NewsDetailFragment.newAction(articles)
        binding.root.findNavController().navigate(action, extras)
    }
}
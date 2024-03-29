package com.thanatpp.newsapp.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigatorExtras
import com.thanatpp.newsapp.R
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
        setupView()
        setupObserveLiveData()
    }

    private fun setupView() {
        binding.topAppBar.setOnMenuItemClickListener {
            onClickMenu()
        }
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
        val action = NewsDetailFragment.newActionFromNews(articles)
        binding.root.findNavController().navigate(action, extras)
    }

    private val onClickMenu = fun(): Boolean {
        binding.root.findNavController()
            .navigate(NewsFragmentDirections.actionNewsFragmentToNewsBookmarkFragment())
        return true
    }
}
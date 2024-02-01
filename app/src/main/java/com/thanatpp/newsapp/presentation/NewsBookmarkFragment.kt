package com.thanatpp.newsapp.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigatorExtras
import com.thanatpp.newsapp.R
import com.thanatpp.newsapp.databinding.FragmentNewsBookmarkBinding
import com.thanatpp.newsapp.domain.model.ArticlesModel
import com.thanatpp.newsapp.presentation.adapter.NewsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsBookmarkFragment :
    BaseFragment<FragmentNewsBookmarkBinding>(
        R.layout.fragment_news_bookmark,
        FragmentNewsBookmarkBinding::bind
    ) {

    private val viewModel: NewsBookmarkViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.fetchNewsBookmark()
        setupView()
        setupObserveLiveData()
    }

    private fun setupView() {
        binding.topAppBar.setNavigationOnClickListener {
            binding.root.findNavController().popBackStack()
        }
    }

    private fun setupObserveLiveData() {
        with(viewModel) {
            newsArticle.observe(viewLifecycleOwner) {
                binding.recyclerViewNews.adapter =
                    NewsAdapter(
                        items = it.articleList,
                        onClickItem = onClickItem,
                        deleteAble = true,
                        onClickDelete = onClickDelete
                    )
            }
        }
    }

    private val onClickItem = fun(view: View, articles: ArticlesModel) {
        val extras = FragmentNavigatorExtras(view to "news_transition_name")
        val action = NewsDetailFragment.newActionFromBookmark(articles)
        binding.root.findNavController().navigate(action, extras)
    }

    private val onClickDelete = fun(articles: ArticlesModel) {
        viewModel.deleteNewsBookmark(articles)
    }
}
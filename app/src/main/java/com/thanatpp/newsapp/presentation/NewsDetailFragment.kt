package com.thanatpp.newsapp.presentation

import android.opengl.Visibility
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.thanatpp.newsapp.R
import com.thanatpp.newsapp.databinding.FragmentNewsDetailBinding
import com.thanatpp.newsapp.domain.model.ArticlesModel
import com.thanatpp.newsapp.presentation.adapter.NewsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsDetailFragment : BaseFragment<FragmentNewsDetailBinding>(
    R.layout.fragment_news_detail,
    FragmentNewsDetailBinding::bind
) {
    companion object {
        fun newActionFromNews(
            articles: ArticlesModel
        ): NewsFragmentDirections.ActionNewsFragmentToNewsDetailFragment {
            return NewsFragmentDirections.actionNewsFragmentToNewsDetailFragment(articles)
        }

        fun newActionFromBookmark(
            articles: ArticlesModel
        ): NewsBookmarkFragmentDirections.ActionNewsBookmarkFragmentToNewsDetailFragment {
            return NewsBookmarkFragmentDirections.actionNewsBookmarkFragmentToNewsDetailFragment(articles)
        }
    }

    private val viewModel: NewsDetailViewModel by viewModels()
    private val args: NewsDetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
        setupObserveLiveData()
        viewModel.checkIsExistBookmark(args.articlesModel.title)
    }

    private fun setupView() {
        Glide.with(binding.root)
            .load(args.articlesModel.imageUrl)
            .into(binding.imageViewNews);

        binding.floatingActionButton.isVisible = false
        binding.textTitle.text = args.articlesModel.title
        binding.textDetail.text = args.articlesModel.description
        binding.textContent.text = args.articlesModel.content
        binding.imageViewNews.contentDescription = args.articlesModel.title
        binding.textViewDateTime.text = args.articlesModel.dateTime
        binding.imageViewNews.contentDescription = args.articlesModel.title

        binding.topAppBar.setNavigationOnClickListener {
            binding.root.findNavController().popBackStack()
        }

        binding.floatingActionButton.setOnClickListener {
            viewModel.addToBookmark(args.articlesModel)
        }
    }

    private fun setupObserveLiveData() {
        with(viewModel) {
            isExistBookmark.observe(viewLifecycleOwner) {
                binding.floatingActionButton.isVisible = !it
            }
        }
    }
}
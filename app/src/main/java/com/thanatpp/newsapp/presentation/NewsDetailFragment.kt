package com.thanatpp.newsapp.presentation

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
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
        setupView()
    }

    private fun setupView() {
        Glide.with(binding.root)
            .load(args.articlesModel.imageUrl)
            .into(binding.imageViewNews);

        binding.textTitle.text = args.articlesModel.title
        binding.textDetail.text = args.articlesModel.description
        binding.textContent.text = args.articlesModel.content
        binding.imageViewNews.contentDescription = args.articlesModel.title
        binding.textViewDateTime.text = args.articlesModel.dateTime

        binding.topAppBar.setNavigationOnClickListener {
            binding.root.findNavController().popBackStack()
        }
    }
}
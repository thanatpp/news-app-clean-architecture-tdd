package com.thanatpp.newsapp.presentation

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import com.thanatpp.newsapp.R
import com.thanatpp.newsapp.data.Example
import com.thanatpp.newsapp.databinding.FragmentNewsDetailBinding

class NewsDetailFragment : BaseFragment<FragmentNewsDetailBinding>(
    R.layout.fragment_news_detail,
    FragmentNewsDetailBinding::bind
) {
    companion object {
        fun newAction(
            example: Example
        ): NewsFragmentDirections.ActionNewsFragmentToNewsDetailFragment {
            return NewsFragmentDirections.actionNewsFragmentToNewsDetailFragment(example)
        }
    }

    private val args: NewsDetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textTitle.text = args.example.title
        binding.textDetail.text = args.example.detail
    }
}
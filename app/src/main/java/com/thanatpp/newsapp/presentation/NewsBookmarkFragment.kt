package com.thanatpp.newsapp.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.thanatpp.newsapp.R
import com.thanatpp.newsapp.databinding.FragmentNewsBinding
import com.thanatpp.newsapp.databinding.FragmentNewsBookmarkBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsBookmarkFragment :
    BaseFragment<FragmentNewsBookmarkBinding>(R.layout.fragment_news_bookmark, FragmentNewsBookmarkBinding::bind) {

    private val viewModel: NewsBookmarkViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.fetchNewsBookmark()
    }
}
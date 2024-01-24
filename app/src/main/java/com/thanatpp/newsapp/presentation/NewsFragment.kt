package com.thanatpp.newsapp.presentation

import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import com.thanatpp.newsapp.R
import com.thanatpp.newsapp.data.Example
import com.thanatpp.newsapp.databinding.FragmentNewsBinding

class NewsFragment :
    BaseFragment<FragmentNewsBinding>(R.layout.fragment_news, FragmentNewsBinding::bind) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonNext.setOnClickListener {
            val example = Example(title = "Example Title", detail = "Example Detail")
            val action = NewsDetailFragment.newAction(example)
            binding.root.findNavController().navigate(action)
        }
    }
}
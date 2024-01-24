package com.thanatpp.newsapp.presentation

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB : ViewBinding>(
    @LayoutRes val layoutRes: Int,
    val bind: (View) -> VB,
) : Fragment(layoutRes) {
    private var _binding: VB? = null
    val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = bind(view)
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}

package com.example.gym.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.navGraphViewModels
import com.example.gym.R
import com.example.gym.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by navGraphViewModels(R.id.mobile_navigation) { defaultViewModelProviderFactory}
    private lateinit var binding: FragmentHomeBinding
    private lateinit var categoryAdapter : WorkoutCategoryAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
         binding.apply{
            viewModel = homeViewModel
            lifecycleOwner = viewLifecycleOwner
        }
        setupCategoryRecyclerView()
        return binding.root
    }

    private fun setupCategoryRecyclerView() {
        categoryAdapter = WorkoutCategoryAdapter()
        binding.categoryList.adapter = categoryAdapter
    }


}
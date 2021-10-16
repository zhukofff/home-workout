package com.example.gym.ui.workout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.gym.common.ViewPagerAdapter
import com.example.gym.common.category_tabs
import com.example.gym.databinding.FragmentWorkoutBinding
import com.google.android.material.tabs.TabLayoutMediator

class WorkoutFragment : Fragment() {

    private lateinit var binding: FragmentWorkoutBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWorkoutBinding.inflate(inflater, container, false)
        val adapter = ViewPagerAdapter(requireActivity().supportFragmentManager, lifecycle)
        binding.vpCategory.adapter = adapter
        TabLayoutMediator(binding.tabLayout, binding.vpCategory) { tab, position ->
             tab.text = category_tabs[position]
        }.attach()
        return binding.root
    }

}
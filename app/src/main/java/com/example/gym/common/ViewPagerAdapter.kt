package com.example.gym.common

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.gym.ui.workout.BackFragment
import com.example.gym.ui.workout.CardioFragment
import com.example.gym.ui.workout.ChestFragment
import com.example.gym.ui.workout.LegsFragment

private const val NUM_TABS = 4

val category_tabs = arrayListOf(
    "Back",
    "Chest",
    "Cardio",
    "Legs"
)

class ViewPagerAdapter(fm: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(fm, lifecycle) {

    override fun createFragment(position: Int): Fragment {
        when(position) {
            0 -> return BackFragment()
            1 -> return ChestFragment()
            2 -> return CardioFragment()
        }
        return LegsFragment()
    }

    override fun getItemCount(): Int {
        return NUM_TABS
    }
}
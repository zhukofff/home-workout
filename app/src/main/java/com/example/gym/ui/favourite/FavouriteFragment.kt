package com.example.gym.ui.favourite

import android.content.ClipData
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.gym.R
import com.example.gym.common.ArrayAdapterCustom
import com.example.gym.common.WorkoutAdapter
import com.example.gym.databinding.FragmentFavouriteBinding
import com.example.gym.model.Workout
import com.example.gym.repository.SortOrder
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavouriteFragment: Fragment() {

    private lateinit var binding: FragmentFavouriteBinding
    private val favouriteViewModel: FavouriteViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavouriteBinding.inflate(inflater, container, false)

        val adapter = WorkoutAdapter(true)
        binding.rvExercise.adapter = adapter

        binding.rvExercise.addItemDecoration(
            DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        val exercises = Observer<List<Workout>> {
            adapter.submitList(it)
        }
        /*
        it's all about spinner, but it is not for drop down menu with icon!

        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.sort_order,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice)
            binding.sortOrder.adapter = adapter
        }*/
/*
        binding.toolbarFavourite.overflowIcon()
*/
        /*val sorting = listOf("Имя (от А до Я)",
                "Категория (от А до Я)",
                "Время (вначале короткие)",
                "По сложности (вначале лёгкие)", "")
        val arrayAdapter = ArrayAdapterCustom(requireContext(),
            android.R.layout.simple_spinner_item,
            sorting)
        arrayAdapter.setDropDownViewResource(android.R.layout.select_dialog_item)*/
        /*binding.sortOrder.adapter = arrayAdapter
        arrayAdapter.hideItemIndex = 0
        binding.sortOrder.setSelection(0)

        val spinnerItemSelectedAdapter = object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                //send sort order name to view model
                binding.sortOrder.setSelection(sorting.size - 1)
                arrayAdapter.hideItemIndex = position

                val res = resources
                val order_list = res.getStringArray(R.array.sort_order)
                val order = when (position) {
                    0 -> SortOrder.BY_TITLE
                    1 -> SortOrder.BY_CATEGORY
                    2 -> SortOrder.BY_TIME
                    3 ->  SortOrder.BY_COMPLEXITY
                    else -> SortOrder.NULL
                }
                if (order.name != "NULL")
                    favouriteViewModel.updateSortOrder(order.name)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
        binding.sortOrder.setOnItemSelectedListener(spinnerItemSelectedAdapter)*/

        binding.toolbarFavourite.setOnMenuItemClickListener { item ->
            onSortingItemSelected(item)
            true
        }

        favouriteViewModel.sortOrder.observe(viewLifecycleOwner) {
            setCheckable(it)
        }
        favouriteViewModel.favouriteExercises.observe(viewLifecycleOwner, exercises)

        return binding.root
    }

    fun onSortingItemSelected(item: MenuItem) {
        favouriteViewModel.updateSortOrder(
            when (item.itemId) {
                R.id.name -> SortOrder.BY_TITLE
                R.id.category -> SortOrder.BY_CATEGORY
                R.id.time -> SortOrder.BY_TIME
                else -> SortOrder.BY_COMPLEXITY
            }.name
        )
    }

    fun setCheckable(sortOrder: SortOrder) {
        val menu = binding.toolbarFavourite.menu

        val item = when (sortOrder) {
            SortOrder.BY_TITLE -> menu.getItem(0)
            SortOrder.BY_CATEGORY -> menu.getItem(1)
            SortOrder.BY_TIME -> menu.getItem(2)
            else -> menu.getItem(3)
        }
        item.isChecked = !item.isChecked
    }
}

/*
1. Сортировка по сложности
2. Сортировка по алфавиту
3. Сортировка по категориям
4. Сортировка по времени
5. make favourite and make not favourite --> change icon and element in database


if starting favourite fragment then
    download sorting mode and imagine exercises

if user clicked on sorting mode then
    save it to preferences and make checkable


 */
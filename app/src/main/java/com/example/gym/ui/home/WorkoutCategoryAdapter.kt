package com.example.gym.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.gym.databinding.CategoryViewItemBinding
import com.example.gym.model.WorkoutCategory

class WorkoutCategoryAdapter : androidx.recyclerview.widget.ListAdapter<WorkoutCategory, WorkoutCategoryViewHolder>(
    WorkoutCategoryCallback()
) {
   // Что такое ListAdapter? Это обычный шаблон для использования RecyclerView для отображения списков, которые изменились
    // Что такое Diff_Callback?
    // RecyclerView вызывает класс под названием DiffUtil, который считает разницу между двумя списками: старым и новым.
    // Поэтому в этом классе переопределяются такие функции как areContentTheSame, areItemsTheSame. Они нужны для сравнения.
    // DiffUtil вызывает ItemCallBack, который вы расширяете для выяснения разницы между двумя списками

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkoutCategoryViewHolder {
        return WorkoutCategoryViewHolder.from(parent)
    }

    // Что за функция onCreateViewHolder? Эта функция возращает экземпляр ViewHolder, который по сути является хранилищем представлением:
    // внутри этого класса происходит связывание элементов и раздутие макета.
    // Что за ViewGroup? Это RecyclerView.
    // Что за viewType? В RecyclerView в качестве элемента списка или элемента сетки передаются различные представления
    // например, textView, imageView это два разных представления и RecyclerView важно знать какой элемент будет обновлен / добавлен / изменён

    // Что за метод from? Этот метод как раз-таки и будет возвращать экземпляр представления.

    override fun onBindViewHolder(holder: WorkoutCategoryViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}

class WorkoutCategoryViewHolder(private val binding : CategoryViewItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(workoutCategory: WorkoutCategory) {
        binding.category = workoutCategory
        binding.executePendingBindings()
    }

    companion object {
        fun from(parent: ViewGroup) : WorkoutCategoryViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = CategoryViewItemBinding.inflate(layoutInflater, parent, false)
            // создание элемента макета с помощью привязки данных
            return WorkoutCategoryViewHolder(binding)
        }
    }

}
class WorkoutCategoryCallback : DiffUtil.ItemCallback<WorkoutCategory>(){
    override fun areItemsTheSame(oldItem: WorkoutCategory, newItem: WorkoutCategory): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: WorkoutCategory, newItem: WorkoutCategory): Boolean {
        return oldItem == newItem
    }
}
// WorkoutCategoryCallback создан для того чтобы сравнивать элемент макета до и после изменений
// и передавать "разницу" в recyclerView
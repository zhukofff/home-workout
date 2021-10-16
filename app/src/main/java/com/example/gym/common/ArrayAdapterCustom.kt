package com.example.gym.common

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class ArrayAdapterCustom(context: Context, resId: Int, val array: List<String>):
    ArrayAdapter<String>(context, resId, array) {

    var hideItemIndex = 0

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view : View? = null
        if (position == hideItemIndex) {
            val itemToHide = TextView(context)
            itemToHide.visibility = View.GONE
            itemToHide.height = 0
            view = itemToHide
            view.visibility = View.GONE
            return view
        } else
        return super.getDropDownView(position, null, parent)
    }

    override fun getCount(): Int {
        return array.size - 1
    }

}
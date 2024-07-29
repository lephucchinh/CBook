package com.example.cbook.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cbook.databinding.ItemGridBinding
import com.example.cbook.databinding.ItemLinearBinding
import com.example.data.model.GridModel

class HomeAdapterParent(
    private val parentItemList: ArrayList<Any?>,
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        private const val CHILD_0 = 0
        private const val CHILD_1 = 1
    }

    inner class ItemGridViewHolder(private val binding: ItemGridBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(gridModel : GridModel) {

        }
    }

    inner class ItemLinearViewHolder(private val binding: ItemLinearBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            CHILD_0 -> {
                val view =
                    ItemGridBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                ItemGridViewHolder(view)
            }

            else -> {
                val view =
                    ItemLinearBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                ItemLinearViewHolder(view)
            }
        }
    }

    override fun getItemCount(): Int {
        return 2
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) {
            CHILD_0
        } else {
            CHILD_1
        }
    }
}
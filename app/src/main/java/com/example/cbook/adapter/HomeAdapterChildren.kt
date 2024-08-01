package com.example.cbook.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cbook.databinding.ItemGridBinding
import com.example.cbook.databinding.ItemLinearBinding
import com.example.cbook.databinding.ItemTypeBinding
import com.example.common.R
import com.example.data.model.StoreModel

class HomeAdapterChildren(private val listItem: MutableList<StoreModel> = mutableListOf(),private val type : Int) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        private const val CHILD_0 = 0
        private const val CHILD_1 = 1
    }

    inner class ItemGridViewHolder(private val binding: ItemGridBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(storeModel : StoreModel) {
            binding.imvStory.setImageResource(R.drawable.avatar_test)
            binding.txtTitleStory.text = storeModel.name
            binding.txtType.text = storeModel.type
        }
    }

    inner class ItemLinearViewHolder(private val binding: ItemLinearBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(storeModel : StoreModel) {
            binding.imvStory.setImageResource(R.drawable.avatar_test)
            binding.txtTitleStory.text = storeModel.name
            binding.txtChapter.text = storeModel.numberChapter.toString()
            binding.txtType.text = storeModel.type
            binding.txtAuthor.text = storeModel.author
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
        return listItem.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            CHILD_0 -> {
                val gridViewHolder = holder as ItemGridViewHolder
                gridViewHolder.bind(listItem[position])
            }
            else -> {
                val linearViewHolder = holder as ItemLinearViewHolder
                linearViewHolder.bind(listItem[position])
            }
        }
    }
    override fun getItemViewType(position: Int): Int {
        return if (type == 0) {
            CHILD_0
        } else {
            CHILD_1
        }
    }
}
package com.example.cbook.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cbook.adapter.HomeAdapterChildren.Companion
import com.example.cbook.databinding.HomeFragmentBinding
import com.example.cbook.databinding.ItemGridBinding
import com.example.cbook.databinding.ItemLinearBinding
import com.example.cbook.databinding.LayoutGridAdapterBinding
import com.example.cbook.databinding.LayoutLinearAdapterBinding
import com.example.common.R
import com.example.data.model.StoreModel
import com.example.data.model.TypeModel

class HomeAdapterParent(
    private var parentItemList: ArrayList<Any> = arrayListOf(),
    private var typeList: MutableList<TypeModel> = mutableListOf(),

    ) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        private const val CHILD_0 = 0
        private const val CHILD_1 = 1
    }

    fun setTypeList(typeList: MutableList<TypeModel>) {
        this.typeList = typeList
    }

    fun setItem(parentItemList: ArrayList<Any>) {
        this.parentItemList = parentItemList
    }


    inner class GridHolder(val binding: LayoutGridAdapterBinding) :
        RecyclerView.ViewHolder(binding.root)

    inner class LinearHolder(val binding: LayoutLinearAdapterBinding) :
        RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            CHILD_0 -> {
                val bindingGrid =
                    LayoutGridAdapterBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                GridHolder(bindingGrid)
            }

            else -> {
                val bindingLinear =
                    LayoutLinearAdapterBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                LinearHolder(bindingLinear)
            }
        }
    }


    override fun getItemCount(): Int {
        return parentItemList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = parentItemList[position]

        when (holder) {
            is GridHolder -> {
                val gridAdapter = HomeAdapterChildren(item as MutableList<StoreModel>, 0)
                holder.binding.rccGrid.layoutManager =
                    GridLayoutManager(holder.binding.root.context, 3)
                holder.binding.rccGrid.adapter = gridAdapter
            }

            is LinearHolder -> {
                val linearAdapter = HomeAdapterChildren(item as MutableList<StoreModel>, 1)
                val typeAdapter = TypeAdapter(typeList)
                holder.binding.rcvType.layoutManager = LinearLayoutManager(
                    holder.binding.root.context,
                    LinearLayoutManager.HORIZONTAL,
                    false
                )
                holder.binding.rcvType.adapter = typeAdapter

                holder.binding.rccLinear.layoutManager =
                    LinearLayoutManager(holder.binding.root.context)
                holder.binding.rccLinear.adapter = linearAdapter
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) {
            CHILD_0
        } else {
            CHILD_1
        }
    }

}
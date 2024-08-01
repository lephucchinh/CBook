package com.example.cbook.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cbook.databinding.ItemTypeBinding
import com.example.data.model.TypeModel

class TypeAdapter(private val typeList: MutableList<TypeModel> = mutableListOf()) :
    RecyclerView.Adapter<TypeAdapter.TypeHolder>() {

    inner class TypeHolder(private val binding: ItemTypeBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun bind(typeModel: TypeModel) {
                binding.txtType.text = typeModel.type
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TypeHolder{
        val binding = ItemTypeBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return TypeHolder(binding)
    }

    override fun getItemCount(): Int {
        return typeList.size
    }

    override fun onBindViewHolder(holder: TypeHolder, position: Int) {
        holder.bind(typeList[position])
    }
}
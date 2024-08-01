package com.example.cbook.ui.home

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cbook.R
import com.example.cbook.adapter.HomeAdapterParent
import com.example.cbook.base.BaseFragment
import com.example.cbook.databinding.HomeFragmentBinding
import com.example.data.model.StoreModel
import com.example.data.model.TypeModel

class HomeFragment : BaseFragment<HomeFragmentBinding>(R.layout.home_fragment) {
    private val adapter by lazy { HomeAdapterParent() }

    override fun setupListener() {
    }

    override fun setupObservers() {
    }

    override fun setupUI() {
        binding.rccHome.layoutManager = LinearLayoutManager(requireContext())
        binding.rccHome.adapter = adapter
    }

    override fun setupData() {
        val list = arrayListOf<Any>()
        val gridList = mutableListOf<StoreModel>()
        val linearList = mutableListOf<StoreModel>()
        val typeList = mutableListOf<TypeModel>()
        for(i in 1..6){
            gridList.add(
                StoreModel(
                    id = i.toLong(),
                    image = com.example.common.R.drawable.avatar_test,
                    name = "cổ chân nhân",
                    numberChapter = 100,
                    type = "Tiên hiệp",
                    author = "Tác giả"
                )
            )
            linearList.add(StoreModel(
                id = i.toLong(),
                image = com.example.common.R.drawable.avatar_test,
                name = "cổ chân nhân",
                numberChapter = 100,
                type = "Tiên hiệp",
                author = "Tác giả"
            ))
            typeList.add(
                TypeModel(
                    id = i.toLong(),
                    type = "Tiên hiệp",
                    numberStore = 3
                )
            )
        }
        adapter.setTypeList(typeList)

        list.add(gridList)
        list.add(linearList)

        adapter.setItem(list)
    }

    override fun onClick(p0: View?) {
    }
}
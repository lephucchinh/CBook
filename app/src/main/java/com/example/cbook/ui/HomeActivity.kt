package com.example.cbook.ui

import android.view.View
import com.example.cbook.R
import com.example.cbook.base.BaseActivity
import com.example.cbook.databinding.HomeActivityBinding

class HomeActivity : BaseActivity<HomeActivityBinding>(R.layout.home_activity) {

    override fun updateUI() {
        setupMenuBottomNav()
    }

    override fun initData() {
    }

    override fun onClick(p0: View?) {
    }

    private fun setupMenuBottomNav() {
        binding.bottomNavigation.setOnItemSelectedListener{ item ->
            when (item.itemId) {
                R.id.btnHome -> {
                    true
                }
                R.id.btnType -> {
                    true
                }
                R.id.btnStorage -> {
                    true
                }
                R.id.btnSetting -> {
                    true
                }
                else -> false
            }
        }
    }
}
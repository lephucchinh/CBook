package com.example.cbook.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.cbook.R
import com.example.cbook.base.BaseActivity
import com.example.cbook.databinding.HomeActivityBinding
import com.example.cbook.ui.home.HomeFragment

class HomeActivity : BaseActivity<HomeActivityBinding>(R.layout.home_activity) {


    override fun updateUI() {

        loadFragment(HomeFragment())
        binding.bottomNavigation.selectedItemId = R.id.btnHome

        setupMenuBottomNav()
    }

    override fun initData() {
    }

    override fun onClick(p0: View?) {
    }

    private fun setupMenuBottomNav() {
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.btnHome -> {
                    loadFragment(HomeFragment())
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

    private fun loadFragment(fragment: Fragment): Boolean {
        supportFragmentManager.beginTransaction()
            .replace(R.id.FlHome, fragment)
            .commit()
        return true
    }
}
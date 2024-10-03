package com.example.cbook.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.cbook.R
import com.example.cbook.base.BaseActivity
import com.example.cbook.databinding.HomeActivityBinding
import com.example.cbook.ui.home.HomeFragment

class HomeActivity : BaseActivity<HomeActivityBinding>(R.layout.home_activity) {
    private var currentFragment: Fragment? = null
    private lateinit var homeFragment: HomeFragment
    private lateinit var typeFragment: HomeFragment
    private lateinit var storageFragment: HomeFragment
    private lateinit var settingFragment: HomeFragment

    override fun updateUI() {
        homeFragment = HomeFragment()
        typeFragment = HomeFragment() // Thay thế bằng fragment tương ứng
        storageFragment = HomeFragment() // Thay thế bằng fragment tương ứng
        settingFragment = HomeFragment() // Thay thế bằng fragment tương ứng

        loadFragment(homeFragment)
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
                    loadFragment(homeFragment)
                    true
                }

                R.id.btnType -> {
                    loadFragment(typeFragment)
                    true
                }

                R.id.btnStorage -> {
                    loadFragment(storageFragment)
                    true
                }

                R.id.btnSetting -> {
                    loadFragment(settingFragment)
                    true
                }

                else -> false
            }
        }
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()

        if (currentFragment != null) {
            transaction.hide(currentFragment!!)
        }

        if (fragment.isAdded) {
            transaction.show(fragment)
        } else {
            transaction.add(R.id.FlHome, fragment)
        }

        currentFragment = fragment
        transaction.commit()
    }
}
package com.example.cbook.base

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.cbook.utils.TypeInsets
import com.example.cbook.utils.displayCutout
import com.example.cbook.utils.hideSystemBar
import com.example.cbook.utils.insetPaddingSystemBar
import com.example.cbook.utils.setStatusBarColor

abstract class BaseActivity< DB : ViewDataBinding>(
val layoutId: Int
) : AppCompatActivity(), View.OnClickListener {
    protected lateinit var binding: DB
    protected var isLightStatusBar: Boolean = true
    protected var isHideStatusBar: Boolean = false
    protected var isHidNavigationBar: Boolean = true
    open val statusBarColor: Int = android.R.color.transparent
    open val typeInsetPadding: TypeInsets = TypeInsets.SystemBar


    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = DataBindingUtil.setContentView(this, layoutId)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        updateUI()
        configSystemBar()
        initData()

    }

    abstract fun updateUI()
    abstract fun initData()

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        configSystemBar()
    }

    private fun configSystemBar() {
        setStatusBarColor(statusBarColor)
        displayCutout()
        hideSystemBar(
            hideStatusBar = isHideStatusBar,
            hideNavigationBar = isHidNavigationBar,
            isLightStatusBar = isLightStatusBar
        )
        binding.root.insetPaddingSystemBar(type = typeInsetPadding)
    }

}
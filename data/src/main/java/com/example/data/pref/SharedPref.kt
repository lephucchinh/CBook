package com.example.data.pref

import android.content.Context
import com.example.data.pref.SharedPrefConst.TEST

class SharedPref(context: Context) {
    private val sharedPreferences = context.getSharedPreferences(
        "${context.applicationContext.packageName}_pref",
        Context.MODE_PRIVATE
    )

    var test
        get() = sharedPreferences.getString(TEST, "") ?: ""
        set(value) = sharedPreferences.edit().putString(TEST,value).apply()

}
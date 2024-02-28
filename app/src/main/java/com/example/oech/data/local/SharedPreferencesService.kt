package com.example.oech.data.local

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class SharedPreferencesService @Inject constructor(
    @ApplicationContext private val context: Context
) {
    private val sp get() = context.getSharedPreferences("OECHSP", Context.MODE_PRIVATE)
    var lastPage
        get() = sp.getInt("lastPage", 0)
        set(value) {
            val editor = sp.edit()
            editor.putInt("lastPage", value)
            editor.apply()
        }
}
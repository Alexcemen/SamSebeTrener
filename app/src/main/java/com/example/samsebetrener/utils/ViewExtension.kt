package com.example.samsebetrener.utils

import androidx.activity.enableEdgeToEdge
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.samsebetrener.MainActivity
import com.example.samsebetrener.R

fun AppCompatActivity.initialActivity(@LayoutRes layoutResID: Int, @IdRes contentId: Int) {
    enableEdgeToEdge()
    setContentView(layoutResID)
    ViewCompat.setOnApplyWindowInsetsListener(findViewById(contentId)) { v, insets ->
        val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
        v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
        insets
    }

}
package com.example.samsebetrener.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.samsebetrener.R
import com.example.samsebetrener.utils.initialActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialActivity(R.layout.activity_menu, R.id.main)
    }
}
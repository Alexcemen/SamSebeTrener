package com.example.samsebetrener.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.samsebetrener.R
import com.example.samsebetrener.activities.muscles.DeltoidsActivity
import com.example.samsebetrener.utils.initialActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialActivity(R.layout.activity_menu, R.id.main)

        val deltoidsItem: View = findViewById(R.id.deltoids_icon)

        deltoidsItem.setOnClickListener {
            val intent = Intent(this, DeltoidsActivity::class.java)
            startActivity(intent)
        }
    }
}
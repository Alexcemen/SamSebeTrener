package com.example.samsebetrener.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.samsebetrener.database.DbHelper
import com.example.samsebetrener.R
import com.example.samsebetrener.models.User
import com.example.samsebetrener.presenters.RegPresenter
import com.example.samsebetrener.utils.initialActivity

class RegActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialActivity(R.layout.activity_reg, R.id.main)

        val userLogin: EditText = findViewById(R.id.user_login)
        val userEmail: EditText = findViewById(R.id.user_email)
        val userPass: EditText = findViewById(R.id.user_pass)
        val regButton: Button = findViewById(R.id.button_reg)
        val linkToAuth: TextView = findViewById(R.id.link_to_auth)

        linkToAuth.setOnClickListener {
            //Вот эту логику стоит выносить в отдельный класс?
            val intent = Intent(this, AuthActivity::class.java)
            startActivity(intent)
        }

        regButton.setOnClickListener {
            //норм вот так создавать объекты другого класса тут? или нужен какойнить интерфейс
            val regPresenter = RegPresenter(context = this)
            regPresenter.regProcess(userLogin = userLogin, userEmail = userEmail, userPass = userPass)
        }
    }
}
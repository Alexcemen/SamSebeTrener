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
import com.example.samsebetrener.presenters.AuthPresenter
import com.example.samsebetrener.utils.initialActivity

class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialActivity(R.layout.activity_auth, R.id.main)

        val linkToReg: TextView = findViewById(R.id.link_to_reg)
        val userLogin: EditText = findViewById(R.id.user_login_auth)
        val userPass: EditText = findViewById(R.id.user_pass_auth)
        val authButton: Button = findViewById(R.id.button_auth)

        linkToReg.setOnClickListener {
            //Вот эту логику стоит выносить в отдельный класс?
            val intent = Intent(this, RegActivity::class.java)
            startActivity(intent)
        }

        authButton.setOnClickListener {
            //норм вот так создавать объекты другого класса тут? или нужен какойнить интерфейс
            val authPresenter = AuthPresenter(context = this)
            authPresenter.authProcess(userLogin = userLogin, userPass = userPass)
        }
    }
}
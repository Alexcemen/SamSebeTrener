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
import com.example.samsebetrener.view.AuthActivityView

class AuthActivity : AppCompatActivity(), AuthActivityView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialActivity(R.layout.activity_auth, R.id.main)

        val linkToReg: TextView = findViewById(R.id.link_to_reg)
        val userLogin: EditText = findViewById(R.id.user_login_auth)
        val userPass: EditText = findViewById(R.id.user_pass_auth)
        val authButton: Button = findViewById(R.id.button_auth)
        val authPresenter = AuthPresenter(context = this, authActivityView = this) //вынес создание объекта при создании активити




        linkToReg.setOnClickListener {
            val intent = Intent(this, RegActivity::class.java)
            startActivity(intent)
        }

        authButton.setOnClickListener {
            authPresenter.authProcess(userLogin = userLogin, userPass = userPass)
        }
    }

    override fun showToastInfo(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }
}
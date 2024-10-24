package com.example.samsebetrener.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.samsebetrener.database.DbHelper
import com.example.samsebetrener.R
import com.example.samsebetrener.activities.usecase.GetUserInfoUseCase
import com.example.samsebetrener.activities.usecase.RegUseCase
import com.example.samsebetrener.presenters.RegPresenter
import com.example.samsebetrener.utils.initialActivity
import com.example.samsebetrener.view.RegActivityView

class RegActivity : AppCompatActivity(), RegActivityView {

    private lateinit var regPresenter: RegPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialActivity(R.layout.activity_reg, R.id.main)

        val userLogin: EditText = findViewById(R.id.user_login)
        val userEmail: EditText = findViewById(R.id.user_email)
        val userPass: EditText = findViewById(R.id.user_pass)
        val regButton: Button = findViewById(R.id.button_reg)
        val linkToAuth: TextView = findViewById(R.id.link_to_auth)
        val getUserInfoUseCase = GetUserInfoUseCase(this, null)
        val regUseCase = RegUseCase(getUserInfoUseCase)
        val regPresenter = RegPresenter(this, regUseCase)

        linkToAuth.setOnClickListener {
            val intent = Intent(this, AuthActivity::class.java)
            startActivity(intent)
        }
        regButton.setOnClickListener {
            regPresenter.regProcess(userLogin = userLogin, userEmail = userEmail, userPass = userPass)
        }
    }

    override fun showToastInfo(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }

    override fun getContext(): Context = this
}
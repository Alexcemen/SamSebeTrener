package com.example.samsebetrener.presenters

import android.content.Context
import android.content.Intent
import android.widget.EditText
import android.widget.Toast
import com.example.samsebetrener.activities.MenuActivity
import com.example.samsebetrener.activities.usecase.AuthUseCase
import com.example.samsebetrener.database.DbHelper
import com.example.samsebetrener.view.AuthActivityView

class AuthPresenter(private val authActivityView: AuthActivityView, private val authUseCase: AuthUseCase) {

    fun authProcess(userLogin: EditText, userPass: EditText) {
        val login = userLogin.text.toString().trim()
        val pass = userPass.text.toString().trim()

        if (login.isEmpty()|| pass.isEmpty())
            authActivityView.showToastInfo("Не все поля заполнены")
        else {
            val isAuthenticated = authUseCase(login = login, pass = pass)
            if (isAuthenticated) {
                userLogin.text.clear()
                userPass.text.clear()
                val intent = Intent(authActivityView.getContext(), MenuActivity::class.java)
                authActivityView.getContext().startActivity(intent)
            } else {
                authActivityView.showToastInfo("Такого логина или пароля нет")
            }
        }
    }
}
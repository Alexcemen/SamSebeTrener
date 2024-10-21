package com.example.samsebetrener.presenters

import android.content.Context
import android.content.Intent
import android.widget.EditText
import android.widget.Toast
import com.example.samsebetrener.activities.MenuActivity
import com.example.samsebetrener.database.DbHelper
import com.example.samsebetrener.view.AuthActivityView

class AuthPresenter(private val context: Context, val authActivityView: AuthActivityView) {

    fun authProcess(userLogin: EditText, userPass: EditText) {
        val login = userLogin.text.toString().trim()
        val pass = userPass.text.toString().trim()

        if (login.isEmpty()|| pass.isEmpty())
            authActivityView.showToastInfo("Не все поля заполнены")
        else {
            val db = DbHelper(context, null)
            if (db.getUser(login = login, pass = pass)) {
                userLogin.text.clear()
                userPass.text.clear()
                val intent = Intent(context, MenuActivity::class.java)
                context.startActivity(intent)
            } else {
                authActivityView.showToastInfo("Такого логина или пароля нет")
            }
            db.close()
        }
    }
}
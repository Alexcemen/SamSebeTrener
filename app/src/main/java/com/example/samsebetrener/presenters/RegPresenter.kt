package com.example.samsebetrener.presenters

import android.content.Context
import android.widget.EditText
import com.example.samsebetrener.activities.RegActivity
import com.example.samsebetrener.database.DbHelper
import com.example.samsebetrener.models.User

class RegPresenter(private val context: Context, val regActivity: RegActivity) {

    fun regProcess(userLogin: EditText, userEmail: EditText, userPass: EditText) {
        val login = userLogin.text.toString().trim()
        val email = userEmail.text.toString().trim()
        val pass = userPass.text.toString().trim()

        if(login == "" || email == "" || pass == "")
            regActivity.showToastInfo("Не все поля заполнены")
        else {
            val user = User(login = login, email = email, pass = pass)

            val db = DbHelper(context = context, factory = null)
            db.addUser(user)
            regActivity.showToastInfo("Пользователь $login добавлен")
            userLogin.text.clear()
            userEmail.text.clear()
            userPass.text.clear()
        }
    }
}
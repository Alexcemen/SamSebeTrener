package com.example.samsebetrener.presenters

import android.content.Context
import android.widget.EditText
import android.widget.Toast
import com.example.samsebetrener.database.DbHelper
import com.example.samsebetrener.models.User

class RegPresenter(private val context: Context) {

    fun regProcess(userLogin: EditText, userEmail: EditText, userPass: EditText) {
        val login = userLogin.text.toString().trim()
        val email = userEmail.text.toString().trim()
        val pass = userPass.text.toString().trim()

        if(login == "" || email == "" || pass == "")
            Toast.makeText(context, "Не все поля заполнены", Toast.LENGTH_LONG).show()
        else {
            val user = User(login = login, email = email, pass = pass)

            val db = DbHelper(context = context, factory = null)
            db.addUser(user)
            Toast.makeText(context, "Пользователь $login добавлен", Toast.LENGTH_LONG).show()
            userLogin.text.clear()
            userEmail.text.clear()
            userPass.text.clear()
        }
    }
}
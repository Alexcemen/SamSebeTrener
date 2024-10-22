package com.example.samsebetrener.activities.usecase

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.example.samsebetrener.database.DbHelper
import com.example.samsebetrener.models.User

class GetUserInfoUseCase(context: Context, factory: SQLiteDatabase.CursorFactory?) {
    val dbHelper = DbHelper(context = context, factory = factory)

    fun getUser(login: String, pass: String): Boolean {
        return dbHelper.getUser(login = login, pass = pass)
    }

    fun addUser(user: User) {
        dbHelper.addUser(user)
    }
}
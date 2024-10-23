package com.example.samsebetrener.activities.usecase

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.example.samsebetrener.database.DbHelper
import com.example.samsebetrener.models.User

// TODO Вот это уже у тебя не UseCase а Repository
// Поэтому название нужно давать такое UserInfoRepository
class GetUserInfoUseCase(context: Context, factory: SQLiteDatabase.CursorFactory?) {
    // TODO DbHelper не должен создаваться тут. Он уже должен приходить готовым в конструктор UserInfoRepository
    val dbHelper = DbHelper(context = context, factory = factory)

    fun getUser(login: String, pass: String): Boolean {
        return dbHelper.getUser(login = login, pass = pass)
    }

    fun addUser(user: User) {
        dbHelper.addUser(user)
    }
}
package com.example.samsebetrener.repositories

import com.example.samsebetrener.database.DbHelper
import com.example.samsebetrener.models.User

class UserInfoRepository (val dbHelper: DbHelper) {

    fun getUser(login: String, pass: String): Boolean {
        return dbHelper.getUser(login = login, pass = pass)
    }

    fun addUser(user: User) {
        dbHelper.addUser(user)
    }
}
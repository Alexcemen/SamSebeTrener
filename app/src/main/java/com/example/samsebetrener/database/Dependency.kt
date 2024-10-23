package com.example.samsebetrener.database

import android.content.Context
import com.example.samsebetrener.activities.AuthActivity
import com.example.samsebetrener.repositories.UserInfoRepository
import com.example.samsebetrener.usecase.AuthUseCase

class Dependency {
    private var _context: Context? = null
    private val context get() = _context ?: throw RuntimeException("Context not been initialized")

    companion object {
        val instance by lazy {
            Dependency()
        }
    }

    fun setContext(context: Context) {
        _context = context
    }

    val dbHelper: DbHelper by lazy {
        DbHelper(context = context, factory = null)
    }

    val userInfoRepository: UserInfoRepository by lazy {
        UserInfoRepository(dbHelper = dbHelper)
    }

    val authUseCase: AuthUseCase by lazy {
        AuthUseCase(userInfoRepository)
    }
}
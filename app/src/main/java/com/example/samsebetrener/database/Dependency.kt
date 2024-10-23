package com.example.samsebetrener.database

import com.example.samsebetrener.activities.AuthActivity
import com.example.samsebetrener.repositories.UserInfoRepository
import com.example.samsebetrener.usecase.AuthUseCase

object Dependency {
    val dbHelper: DbHelper by lazy {
        DbHelper(context = , factory = null)
    }

    val userInfoRepository: UserInfoRepository by lazy {
        UserInfoRepository(dbHelper = dbHelper)
    }

    val authUseCase: AuthUseCase by lazy {
        AuthUseCase(userInfoRepository)
    }
}
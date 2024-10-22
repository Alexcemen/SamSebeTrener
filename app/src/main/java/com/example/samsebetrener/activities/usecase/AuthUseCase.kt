package com.example.samsebetrener.activities.usecase

import com.example.samsebetrener.database.DbHelper

class AuthUseCase(private val getUserInfoUseCase: GetUserInfoUseCase) {
    operator fun invoke(login: String, pass: String): Boolean {
        return getUserInfoUseCase.getUser(login = login, pass = pass)
    }
}
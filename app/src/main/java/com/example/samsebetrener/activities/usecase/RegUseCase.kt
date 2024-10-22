package com.example.samsebetrener.activities.usecase

import com.example.samsebetrener.database.DbHelper
import com.example.samsebetrener.models.User

class RegUseCase(private val getUserInfoUseCase: GetUserInfoUseCase) {
    operator fun invoke(user: User) {
        return getUserInfoUseCase.addUser(user)
    }
}
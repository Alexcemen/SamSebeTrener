package com.example.samsebetrener.usecase

import com.example.samsebetrener.models.User
import com.example.samsebetrener.repositories.UserInfoRepository

class RegUseCase(private val userInfoRepository: UserInfoRepository) {
    operator fun invoke(user: User) {
        return userInfoRepository.addUser(user)
    }
}
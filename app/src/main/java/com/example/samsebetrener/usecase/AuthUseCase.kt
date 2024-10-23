package com.example.samsebetrener.usecase

import com.example.samsebetrener.repositories.UserInfoRepository

class AuthUseCase(private val userInfoRepository: UserInfoRepository) {
    operator fun invoke(login: String, pass: String): Boolean {
        return userInfoRepository.getUser(login = login, pass = pass)
    }
}
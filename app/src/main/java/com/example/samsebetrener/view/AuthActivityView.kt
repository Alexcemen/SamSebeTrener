package com.example.samsebetrener.view

import android.content.Context

interface AuthActivityView {
    fun showToastInfo(text: String)
    fun getContext(): Context
}
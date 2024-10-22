package com.example.samsebetrener.view

import android.content.Context

interface RegActivityView {
    fun showToastInfo(text: String)
    fun getContext(): Context
}
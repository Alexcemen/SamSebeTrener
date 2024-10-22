package com.example.samsebetrener.presenters.musclesPresenters

import android.content.Context

class ResourceHelper(private val context: Context) {
    fun getString(resourceId: Int): String {
        return context.getString(resourceId)
    }
}
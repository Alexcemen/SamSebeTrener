package com.example.samsebetrener

import android.app.Application
import com.example.samsebetrener.database.Dependency

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        Dependency.instance.setContext(applicationContext)
    }
}
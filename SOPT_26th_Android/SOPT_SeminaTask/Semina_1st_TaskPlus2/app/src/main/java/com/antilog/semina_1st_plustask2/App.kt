package com.antilog.semina_1st_plustask2

import android.app.Application

class App : Application() {
    companion object {
        lateinit var preferences: SaveSharedPreferences
    }

    override fun onCreate() {
        preferences = SaveSharedPreferences(applicationContext)
        super.onCreate()
    }
}
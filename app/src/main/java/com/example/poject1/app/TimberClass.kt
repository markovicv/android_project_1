package com.example.poject1.app

import android.app.Application
import timber.log.Timber

class TimberClass : Application() {
    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
    }
}
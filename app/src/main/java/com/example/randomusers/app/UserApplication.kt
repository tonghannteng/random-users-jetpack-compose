package com.example.randomusers.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * @author: tonghann.teng
 * @since: 8/1/23
 */
@HiltAndroidApp
class UserApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}

package com.example.networkmodule.base

import android.app.Application
import com.facebook.stetho.Stetho

class BaseApp: Application() {
    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this);
    }
}
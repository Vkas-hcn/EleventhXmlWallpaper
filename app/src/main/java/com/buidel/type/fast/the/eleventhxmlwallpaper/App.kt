package com.buidel.type.fast.the.eleventhxmlwallpaper

import android.app.Application
import java.util.UUID

class App:Application() {
    companion object {
        lateinit var appContext: Application
    }

    override fun onCreate() {
        appContext = this
        super.onCreate()

    }
}
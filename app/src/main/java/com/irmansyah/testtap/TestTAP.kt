package com.irmansyah.testtap

import android.app.Application
import com.irmansyah.testtap.di.AppModule
import org.koin.android.ext.android.startKoin

class TestTAP : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(AppModule.getModule()))
    }
}
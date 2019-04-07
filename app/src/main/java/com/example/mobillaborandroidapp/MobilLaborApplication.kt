package com.example.mobillaborandroidapp

import android.app.Application
import com.example.mobillaborandroidapp.ui.UIModule

class MobilLaborApplication : Application() {
    lateinit var injector: MobilLaborApplicationComponent

    override fun onCreate() {
        super.onCreate()
        injector = DaggerMobilLaborApplicationComponent.builder().uIModule(UIModule(this)).build()
    }
}
package com.example.mobillaborandroidapp

import android.app.Activity

val Activity.injector: MobilLaborApplicationComponent
    get() {
        return (this.applicationContext as MobilLaborApplication).injector
    }
package com.example.mobillaborandroidapp

import android.app.Activity
import androidx.fragment.app.Fragment

val Activity.injector: MobilLaborApplicationComponent
    get() {
        return (this.applicationContext as MobilLaborApplication).injector
    }
val Fragment.injector: MobilLaborApplicationComponent
    get() {
        return (this.context!!.applicationContext as MobilLaborApplication).injector
    }
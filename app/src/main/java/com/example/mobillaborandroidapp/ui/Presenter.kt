package com.example.mobillaborandroidapp.ui

abstract class Presenter<S> {
    protected var screen: S? = null

    open fun attachScreen(screen: S) {
    }

    open fun detachScreen() {
    }
}
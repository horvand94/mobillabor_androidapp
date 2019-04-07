package com.example.mobillaborandroidapp.ui.addMovie

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import javax.inject.Inject

class AddMovieActivity : AppCompatActivity(), AddMovieScreen {

    @Inject
    lateinit var addMoviePresenter: AddMoviePresenter

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun addMovieToList() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
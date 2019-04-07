package com.example.mobillaborandroidapp.ui.movie

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import javax.inject.Inject

class MovieActivity : AppCompatActivity(), MovieScreen  {

    @Inject
    lateinit var moviePresenter: MoviePresenter

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun showDetails(movieId: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
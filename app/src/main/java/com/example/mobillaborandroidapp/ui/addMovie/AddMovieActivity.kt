package com.example.mobillaborandroidapp.ui.addMovie

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mobillaborandroidapp.R
import com.example.mobillaborandroidapp.injector
import com.google.firebase.analytics.FirebaseAnalytics
import kotlinx.android.synthetic.main.activity_movie_add.*
import javax.inject.Inject
import kotlin.math.roundToInt

class AddMovieActivity : AppCompatActivity(), AddMovieScreen {

    private lateinit var firebaseAnalytics: FirebaseAnalytics

    @Inject
    lateinit var addMoviePresenter: AddMoviePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_add)

        firebaseAnalytics = FirebaseAnalytics.getInstance(this)

        btnAddMovie.setOnClickListener {

            val rating = ratingBar.rating
            val query = addMovieQuery.text.toString()

            val params = Bundle()
            params.putString("query", query)
            params.putString("rating", rating.toString())
            firebaseAnalytics.logEvent("added_movie", params)

            firebaseAnalytics.setCurrentScreen(this, "AddMovieScreen", null /* class override */)

            addMoviePresenter.addMovieToList(query, rating)
            finish()
        }
    }

    override fun onStart() {
        super.onStart()
        injector.inject(this)
        addMoviePresenter.attachScreen(this)
    }

    override fun onStop() {
        addMoviePresenter.detachScreen()
        super.onStop()
    }

}
package com.example.mobillaborandroidapp.ui.addMovie

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mobillaborandroidapp.R
import com.example.mobillaborandroidapp.injector
import kotlinx.android.synthetic.main.activity_movie_add.*
import javax.inject.Inject
import kotlin.math.roundToInt

class AddMovieActivity : AppCompatActivity(), AddMovieScreen {

    @Inject
    lateinit var addMoviePresenter: AddMoviePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_add)



        btnAddMovie.setOnClickListener {
            val rating = ratingBar.rating
            addMovieToList(addMovieQuery.text.toString(), rating)
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

    override fun addMovieToList(query: String, rating: Float) {

        addMoviePresenter.addMovieToList(query, rating)

    }

}
package com.example.mobillaborandroidapp.ui.addMovie

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mobillaborandroidapp.R
import javax.inject.Inject

class AddMovieActivity : AppCompatActivity(), AddMovieScreen {

    @Inject
    lateinit var addMoviePresenter: AddMoviePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_add)
    }

    override fun addMovieToList() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
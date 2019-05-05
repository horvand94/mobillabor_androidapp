package com.example.mobillaborandroidapp.ui.movie

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mobillaborandroidapp.R
import kotlinx.android.synthetic.main.activity_movie_details.*
import javax.inject.Inject

class MovieActivity : AppCompatActivity(), MovieScreen  {

    @Inject
    lateinit var moviePresenter: MoviePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)
        val ss:String = intent.getStringExtra("MovieItemPosition")
        val ss2:String = intent.getStringExtra("MovieItemTitle")
        tvMovieDetails.text = ss + " - " + ss2
    }

    override fun showDetails(movieId: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
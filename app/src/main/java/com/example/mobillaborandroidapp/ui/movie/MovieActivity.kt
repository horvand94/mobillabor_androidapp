package com.example.mobillaborandroidapp.ui.movie

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.RatingBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.mobillaborandroidapp.R
import com.example.mobillaborandroidapp.injector
import com.example.mobillaborandroidapp.model.Movie
import kotlinx.android.synthetic.main.activity_movie_details.*
import kotlinx.android.synthetic.main.fragment_movies.*
import javax.inject.Inject

class MovieActivity : AppCompatActivity(), MovieScreen, RatingBar.OnRatingBarChangeListener  {

    @Inject
    lateinit var moviePresenter: MoviePresenter

    override fun onStart() {
        super.onStart()
    }

    override fun onStop() {
        moviePresenter.detachScreen()
        super.onStop()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        ratingBarMovieDetails.onRatingBarChangeListener = this

        injector.inject(this)
        moviePresenter.attachScreen(this)

        val position:String = intent.getStringExtra("MovieItemPosition")
        val pos = position.toInt()
        moviePresenter.showDetails(pos)
    }

    override fun showDetails(movie: Movie) {
        tvMovieDetailsTitle.text = movie.title + " (" + movie.releaseDate?.substring(0,4) + ")"
        val url = "http://image.tmdb.org/t/p/w154" + movie.posterUrl
        Glide.with(this).load(url).into(ivMovieDetailsImage)
        tvMovieDetailsOverview.text = movie.overview
        ratingBarMovieDetails.rating = movie.rating!!
    }

    override fun onRatingChanged(p0: RatingBar?, p1: Float, p2: Boolean) {
        val position:String = intent.getStringExtra("MovieItemPosition")
        val pos = position.toInt()
        moviePresenter.updateMovieRating(pos, p1)
    }

    override fun showNetworkError(errorMsg: String) {
        swipeRefreshLayoutMovies.isRefreshing = false
        Toast.makeText(this, errorMsg, Toast.LENGTH_LONG).show()
    }
}
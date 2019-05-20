package com.example.mobillaborandroidapp.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mobillaborandroidapp.R
import com.example.mobillaborandroidapp.ui.addMovie.AddMovieActivity
import com.example.mobillaborandroidapp.ui.movie.MovieActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.card_movie.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar.title = "My Movies"
        setSupportActionBar(toolbar)
        supportFragmentManager.beginTransaction().replace(R.id.fragment, MainFragment()).commit()
        fab.setOnClickListener { startActivity(Intent(this, AddMovieActivity::class.java)) }
    }

}

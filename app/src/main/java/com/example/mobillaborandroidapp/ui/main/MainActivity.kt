package com.example.mobillaborandroidapp.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mobillaborandroidapp.R
import com.example.mobillaborandroidapp.ui.addMovie.AddMovieActivity
import com.example.mobillaborandroidapp.ui.movie.MovieActivity
import com.google.firebase.analytics.FirebaseAnalytics
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.card_movie.*
import javax.inject.Inject
import com.crashlytics.android.Crashlytics
import io.fabric.sdk.android.Fabric



class MainActivity : AppCompatActivity() {

    private lateinit var firebaseAnalytics: FirebaseAnalytics

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Fabric.with(this, Crashlytics())

        firebaseAnalytics = FirebaseAnalytics.getInstance(this)

        val params = Bundle()
        params.putString("name", "name")
        params.putString("full_text", "text")
        firebaseAnalytics.logEvent("main_activity", params)

        toolbar.title = "My Movies"
        setSupportActionBar(toolbar)
        supportFragmentManager.beginTransaction().replace(R.id.fragment, MainFragment()).commit()
        fab.setOnClickListener { startActivity(Intent(this, AddMovieActivity::class.java)) }
    }

}

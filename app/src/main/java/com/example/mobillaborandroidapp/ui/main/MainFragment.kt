package com.example.mobillaborandroidapp.ui.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mobillaborandroidapp.R
import com.example.mobillaborandroidapp.injector
import com.example.mobillaborandroidapp.model.Movie
import com.example.mobillaborandroidapp.ui.addMovie.AddMovieActivity
import com.example.mobillaborandroidapp.ui.movie.MovieActivity
import kotlinx.android.synthetic.main.card_movie.*
import kotlinx.android.synthetic.main.fragment_movies.*
import javax.inject.Inject


class MainFragment: Fragment(), MainScreen {

    private val displayedMovies: ArrayList<Movie> = ArrayList<Movie>()
    private var mainAdapter: MainAdapter? = null

    @Inject
    lateinit var mainPresenter: MainPresenter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        injector.inject(this)
        mainPresenter.attachScreen(this)
    }

    override fun onDetach() {
        mainPresenter.detachScreen()
        super.onDetach()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val llm = LinearLayoutManager(context)
        llm.orientation = RecyclerView.VERTICAL
        recyclerViewMovies.layoutManager = llm

        mainAdapter = MainAdapter(context!!, displayedMovies, mainPresenter)
        recyclerViewMovies.adapter = mainAdapter

        mainPresenter.showMovies()

        swipeRefreshLayoutMovies.setOnRefreshListener {
            mainPresenter.showMovies()
        }
    }

    override fun onResume() {
        super.onResume()
        mainPresenter.showMovies()
    }

    override fun showNetworkError(errorMsg: String) {
        swipeRefreshLayoutMovies.isRefreshing = false
        Toast.makeText(context, errorMsg, Toast.LENGTH_LONG).show()
    }

    override fun showMovies(movies: List<Movie>?) {
        swipeRefreshLayoutMovies.isRefreshing = false
        displayedMovies.clear()
        if (movies != null) {
            displayedMovies.addAll(movies)
        }
        mainAdapter?.notifyDataSetChanged()
    }

    override fun refresh() {
        fragmentManager!!.beginTransaction().detach(this).attach(this).commit()
    }

}
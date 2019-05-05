package com.example.mobillaborandroidapp.ui.main

import com.example.mobillaborandroidapp.interactor.movies.MoviesInteractor
import com.example.mobillaborandroidapp.interactor.movies.event.GetMoviesEvent
import com.example.mobillaborandroidapp.model.Movie
import com.example.mobillaborandroidapp.ui.Presenter
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.util.concurrent.Executor
import javax.inject.Inject

class MainPresenter @Inject constructor(private val executor: Executor, private val moviesInteractor: MoviesInteractor) : Presenter<MainScreen>() {

    val movieList = listOf(
        Movie(1L, "Inception", "Sci-fi", "", 9, 2010, 140, "", null),
        Movie(2L, "The Dark Knight", "Action", "", 10, 2008, 160, "", null),
        Movie(3L, "The Hangover", "Comedy", "", 8, 2009, 100, "", null)

    )

    override fun attachScreen(screen: MainScreen) {
        super.attachScreen(screen)
        EventBus.getDefault().register(this)
    }

    override fun detachScreen() {
        EventBus.getDefault().unregister(this)
        super.detachScreen()
    }

    fun showMovies() {
        executor.execute {
            moviesInteractor.getMovies()
        }
        //screen?.showMovies(movieList as MutableList<Movie>)
    }
    fun showMovieDetails(movieId: Int) {}
    fun deleteMovie(movieId: Int) {}
    fun rateMovie(movieId: Int) {}
    fun addMovie() {
        screen?.addMovie()
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEventMainThread(event: GetMoviesEvent) {
        if (event.throwable != null) {
            event.throwable?.printStackTrace()
            if (screen != null) {
                screen?.showNetworkError(event.throwable?.message.orEmpty())
            }
        } else {
            if (screen != null) {
                if (event.movies != null) {
                    screen?.showMovies(event.movies as MutableList<Movie>)
                }

            }
        }
    }
}
package com.example.mobillaborandroidapp.ui.movie

import com.example.mobillaborandroidapp.interactor.movies.MoviesInteractor
import com.example.mobillaborandroidapp.interactor.movies.event.GetMovieEvent
import com.example.mobillaborandroidapp.interactor.movies.event.GetMoviesEvent
import com.example.mobillaborandroidapp.model.Movie
import com.example.mobillaborandroidapp.ui.Presenter
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import org.greenrobot.eventbus.EventBus
import java.util.concurrent.Executor
import javax.inject.Inject

class MoviePresenter @Inject constructor(private val executor: Executor, private val moviesInteractor: MoviesInteractor) : Presenter<MovieScreen>() {

    override fun attachScreen(screen: MovieScreen) {
        super.attachScreen(screen)
        EventBus.getDefault().register(this)
    }

    override fun detachScreen() {
        EventBus.getDefault().unregister(this)
        super.detachScreen()
    }

    fun updateMovieRating(movieId: Int?, rating: Float) {
        moviesInteractor.updateMovieRating(movieId, rating)
    }

    fun showDetails(movieId: Int) {
        moviesInteractor.getMovieById(movieId)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEventMainThread(event: GetMovieEvent) {
        if (event.throwable != null) {
            event.throwable?.printStackTrace()
            if (screen != null) {
                screen?.showNetworkError(event.throwable?.message.orEmpty())
            }
        } else {
            if (screen != null) {
                if (event.movie != null) {
                    screen?.showDetails(event.movie as Movie)
                }

            }
        }
    }
}
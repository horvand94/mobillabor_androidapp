package com.example.mobillaborandroidapp

import com.example.mobillaborandroidapp.interactor.InteractorModule
import com.example.mobillaborandroidapp.mock.MockNetworkModule
import com.example.mobillaborandroidapp.ui.UIModule
import com.example.mobillaborandroidapp.ui.addMovie.AddMovieActivity
import com.example.mobillaborandroidapp.ui.main.MainActivity
import com.example.mobillaborandroidapp.ui.main.MainFragment
import com.example.mobillaborandroidapp.ui.movie.MovieActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [UIModule::class, MockNetworkModule::class, InteractorModule::class])
interface MobilLaborApplicationComponent {

    fun inject(mainActivity: MainActivity)
    fun inject(addMovieActivity: AddMovieActivity)
    fun inject(movieActivity: MovieActivity)
    fun inject(mainFragment: MainFragment)

}
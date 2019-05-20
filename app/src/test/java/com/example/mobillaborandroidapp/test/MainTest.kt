package com.example.mobillaborandroidapp.test

import com.example.mobillaborandroidapp.testInjector
import com.example.mobillaborandroidapp.utils.argumentCaptor
import com.example.mobillaborandroidapp.utils.mock
import com.example.mobillaborandroidapp.model.Movie
import com.example.mobillaborandroidapp.ui.main.MainPresenter
import com.example.mobillaborandroidapp.ui.main.MainScreen
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.verify
import org.robolectric.RobolectricTestRunner
import javax.inject.Inject

@RunWith(RobolectricTestRunner::class)
class MainTest {
    @Inject
    lateinit var mainPresenter: MainPresenter
    private lateinit var mainScreen: MainScreen


    @Before
    @Throws(Exception::class)
    fun setup() {
        testInjector.inject(this)
        mainScreen = mock()
        mainPresenter.attachScreen(mainScreen)
    }

    @Test
    fun testMovies() {
        mainPresenter.showMovies()

        val list = argumentCaptor<MutableList<Movie>>()
        verify(mainScreen).showMovies(list.capture())
        assert(list.value.size > 0)
    }

    @Test
    fun testDeleteMovie() {
        mainPresenter.deleteMovie(0)
        verify(mainScreen).refresh()
    }

    @After
    fun tearDown() {
        mainPresenter.detachScreen()
    }
}
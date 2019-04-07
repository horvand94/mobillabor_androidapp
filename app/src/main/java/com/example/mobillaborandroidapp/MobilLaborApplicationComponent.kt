package com.example.mobillaborandroidapp

import com.example.mobillaborandroidapp.interactor.InteractorModule
import com.example.mobillaborandroidapp.network.NetworkModule
import com.example.mobillaborandroidapp.ui.UIModule
import com.example.mobillaborandroidapp.ui.main.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [UIModule::class, NetworkModule::class, InteractorModule::class])
interface MobilLaborApplicationComponent {

    fun inject(mainActivity: MainActivity)

}
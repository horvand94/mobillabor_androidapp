package com.example.mobillaborandroidapp

import com.example.mobillaborandroidapp.MobilLaborApplicationComponent
import com.example.mobillaborandroidapp.TestModule
import com.example.mobillaborandroidapp.interactor.InteractorModule
import com.example.mobillaborandroidapp.test.MainTest
import com.example.mobillaborandroidapp.network.MockNetworkModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [MockNetworkModule::class, TestModule::class, InteractorModule::class])
interface TestComponent : MobilLaborApplicationComponent {
    fun inject(mainTest: MainTest)
}

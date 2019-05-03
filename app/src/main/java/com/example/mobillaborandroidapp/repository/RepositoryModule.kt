package com.example.mobillaborandroidapp.repository

import com.example.mobillaborandroidapp.repository.room.RoomRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Suppress("unused")
@Module
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindRepository(roomRepository: RoomRepository): Repository

}
package com.example.mobillaborandroidapp.repository.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mobillaborandroidapp.model.Movie

@Database(
    entities = [Movie::class],
    version = 1,
    exportSchema = false
)
abstract class MyDatabase : RoomDatabase() {

    abstract fun roomDao(): MoviesDao

}
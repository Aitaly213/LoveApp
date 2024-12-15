package com.example.loveapp

import android.app.Application
import androidx.room.Room
import com.example.loveapp.data.local.AppDatabase

class App : Application() {

    companion object{
        var appDatabase: AppDatabase?= null
    }

    override fun onCreate() {
        super.onCreate()

        getInstance()
    }

    public fun getInstance(): AppDatabase? {
        if (appDatabase == null){
            appDatabase = applicationContext?.let {
                Room.databaseBuilder(
                    it,
                    AppDatabase::class.java,
                    "love.database"
                ).fallbackToDestructiveMigration().allowMainThreadQueries().build()
            }
        }

        return appDatabase
    }
}
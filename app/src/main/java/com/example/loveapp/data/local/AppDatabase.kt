package com.example.loveapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.loveapp.data.model.LoveModel

@Database(entities = [LoveModel::class], version = 2)
abstract class AppDatabase : RoomDatabase(){

        abstract fun resultDao():ResultDao
}
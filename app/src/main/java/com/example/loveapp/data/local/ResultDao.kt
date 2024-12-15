//package com.example.loveapp.data.local
//
//import androidx.lifecycle.LiveData
//import androidx.room.Dao
//import androidx.room.Delete
//import androidx.room.Insert
//import androidx.room.OnConflictStrategy
//import androidx.room.Query
//import com.example.loveapp.data.model.LoveModel
//
//@Dao
//interface ResultDao {
//
//    @Query("SELECT * FROM loveModel")
//    fun getAll(): LiveData<List<LoveModel>>
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun insertNote(loveModel: LoveModel)
//
//    @Delete
//    fun deleteNote(loveModel: LoveModel)
//}
package com.example.loveapp.data.model

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

//@Entity(tableName = "loveModel")
data class LoveModel (
    @SerializedName("fname")
    val firstName: String,
    @SerializedName("sname")
    val secondName: String,
    @SerializedName("percentage")
    val percentage: String,
    @SerializedName("result")
    val result: String


): Serializable{
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
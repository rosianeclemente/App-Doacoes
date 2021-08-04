package com.example.myapplication.DATA

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface IDoacaoDAO {
    @Query("SELECT * FROM Doacao")
    fun getAll():LiveData<List<Doacao>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(doacao: Doacao)

}

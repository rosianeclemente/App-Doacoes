package com.example.myapplication.Data

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface IDoacaoDAO {

    @Query("SELECT * FROM Doacao")
    fun getAll():LiveData<List<Doacao>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(doacao: Doacao)

    @Update
    fun update(id: Doacao)

//    @Query("UPDATE Doacao SET nome = :description, contato= :title WHERE id =:id")
//    fun update(description: String?, title: String?, id: Int)


    @Delete
    fun  deleteAll(id: Doacao)
}

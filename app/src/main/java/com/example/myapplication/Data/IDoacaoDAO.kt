package com.example.myapplication.Data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface IDoacaoDAO {
    @Query("SELECT * FROM Doacao")
    fun getAll():LiveData<List<Doacao>>
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(doacao: Doacao)

    @Update
    suspend fun update(doacao: Doacao)
    @Query("SELECT * FROM doacao")
    suspend fun  all():MutableList<Doacao>

    @Query("DELETE FROM doacao WHERE id IN (:id)")
    suspend fun  deleteAll(id: MutableList<Int>)

}

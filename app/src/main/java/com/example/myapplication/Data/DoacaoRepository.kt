package com.example.myapplication.Data

import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class DoacaoRepository(private val doacaoDao: IDoacaoDAO) {
    fun insert(doacao: Doacao) = runBlocking {
        launch ( Dispatchers.IO ){
            doacaoDao.insert(doacao)
        }
    }
    fun getAll()= doacaoDao.getAll()

    fun update (doacao: Doacao) = runBlocking {
        launch ( Dispatchers.IO ){
            doacaoDao.update(doacao)
        }
    }

    suspend fun deleteAll(id:MutableList<Int>) = doacaoDao.deleteAll(id)
}
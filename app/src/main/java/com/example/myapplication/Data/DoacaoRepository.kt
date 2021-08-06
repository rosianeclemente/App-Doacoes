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
    suspend fun update(doacao: Doacao) = doacaoDao.update(doacao)
    fun getAll():LiveData<List<Doacao>> = doacaoDao.getAll()
    suspend fun deleteAll(id:MutableList<Int>) = doacaoDao.deleteAll(id)
}
package com.example.myapplication.Data

import androidx.lifecycle.LiveData

class DoacaoRepository(private val doacaoDao: IDoacaoDAO) {
    suspend fun insert(doacao: Doacao) = doacaoDao.insert(doacao)
    suspend fun update(doacao: Doacao) = doacaoDao.update(doacao)
    fun getAll():LiveData<List<Doacao>> = doacaoDao.getAll()
    suspend fun deleteAll(id:MutableList<Int>) = doacaoDao.deleteAll(id)
}
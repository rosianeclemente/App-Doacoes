package com.example.myapplication.Data

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
//
    fun update (id: Doacao) = runBlocking {
        launch ( Dispatchers.IO ){
            doacaoDao.update(id)
        }
    }
//
    fun deleteAll(id: Doacao) = runBlocking {
        launch( Dispatchers.IO){
            doacaoDao.deleteAll(id)
        }
}
}
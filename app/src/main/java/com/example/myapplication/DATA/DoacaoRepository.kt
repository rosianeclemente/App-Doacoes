package com.example.myapplication.DATA

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class DoacaoRepository(private val dao: IDoacaoDAO) {
    fun insert(doacao: Doacao) = runBlocking {
        launch(Dispatchers.IO){
            dao.insert(doacao)
        }
    }
    fun getAll() = dao.getAll()
}
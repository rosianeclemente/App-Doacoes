package com.example.myapplication.Data

class DoacaoRepository(private val doacaoDao: IDoacaoDAO) {
    suspend fun insert(doacao: Doacao) = doacaoDao.insert(doacao)
    suspend fun update(doacao: Doacao) = doacaoDao.update(doacao)
    suspend fun all():MutableList<Doacao> = doacaoDao.all()
    suspend fun deleteAll(id:MutableList<Int>) = doacaoDao.deleteAll(id)
}
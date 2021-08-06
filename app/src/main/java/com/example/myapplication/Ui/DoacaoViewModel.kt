package com.example.myapplication.Ui

import androidx.lifecycle.MutableLiveData
//import com.example.myapplication.Data.Doacao
//import com.example.myapplication.Data.DoacaoRepository
//import androidx.lifecycle.viewModelScope
//import com.example.myapplication.Data.IDoacaoDAO
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.launch
//import kotlinx.coroutines.runBlocking
//
//class DoacaoViewModel(private val doacaoDao: IDoacaoDAO) {
//    val listAll = MutableLiveData<MutableList<Doacao>>()
//
//    fun insert(doacao: Doacao) = runBlocking {
//        launch ( Dispatchers.IO ){
//            doacaoDao.insert(doacao)
//        }
//    }
//    fun getAll() = doacaoDao.getAll()
//
//    fun update(doacao: Doacao)= runBlocking {
//        launch( Dispatchers.IO){
//            doacaoDao.update(doacao)
//        }
//    }
//    fun deleteAll(id: MutableList<Int>)= runBlocking {
//        launch( Dispatchers.IO){
//            doacaoDao.deleteAll(id)
//        }
//    }
//
//
//}
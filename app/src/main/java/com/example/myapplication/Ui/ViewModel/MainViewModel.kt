package com.example.myapplication.Ui.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.Data.Doacao
import com.example.myapplication.Data.DoacaoRepository


class MainViewModel (private val doacaoRepository: DoacaoRepository): ViewModel(){

        fun insert(doacao: Doacao){
            doacaoRepository.insert(doacao)

        }
        fun getAll(): LiveData<List<Doacao>> {
            return doacaoRepository.getAll()
        }
        fun update(id: Doacao){
            doacaoRepository.update(id)
        }
        fun deleteAll(id: Doacao) {
            doacaoRepository.deleteAll(id)

        }

}
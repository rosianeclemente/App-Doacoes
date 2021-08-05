package com.example.myapplication.Model

import androidx.lifecycle.MutableLiveData
import com.example.myapplication.Data.Doacao
import com.example.myapplication.Data.DoacaoRepository
import androidx.lifecycle.viewModelScope

class DoacaoViewModel(private val repository: DoacaoRepository) {
    val listAll = MutableLiveData<MutableList<Doacao>>()


}
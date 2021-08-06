package com.example.myapplication.Ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.Data.Doacao
import com.example.myapplication.Data.DoacaoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainViewModel(private val doacaoRepository: DoacaoRepository): ViewModel() {

    fun insert(doacao: Doacao){
        doacaoRepository.insert(doacao)

    }
    fun getAll(): LiveData<List<Doacao>> {
        return doacaoRepository.getAll()
    }
    fun update(doacao: Doacao){
        doacaoRepository.update(doacao)
    }
    suspend fun deleteAll(id:MutableList<Int>) = doacaoRepository.deleteAll(id)
}
//manual pois n esta usando injeção de dependencia
class MainViewModelFactory(private val repository: DoacaoRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}
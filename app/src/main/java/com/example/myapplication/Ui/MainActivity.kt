package com.example.myapplication.Ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.viewModelScope
import com.example.myapplication.App
import com.example.myapplication.Data.Doacao
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


class MainActivity : AppCompatActivity() {

    private val binding by lazy{ ActivityMainBinding.inflate(layoutInflater)}
    private val mainViewModel: MainViewModel by viewModels{
        MainViewModelFactory((application as App).repository)
    }

    private val adapter by lazy { DoacaoAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.doacoes.adapter = adapter

        insertListener()
        getAll()
//        update()
//        deleteAll()
    }

    private fun insertListener() {
       binding.FloatButton.setOnClickListener{
           val intent = Intent(this, AddDoacaoActivity::class.java)
           startActivity(intent)
       }
    }
//    private fun update() {
//        binding.doacoes.setOnClickListener {
//            val intent = Intent(this, AddDoacaoActivity::class.java)
//            startActivity(intent)
//        }
//    }
//
    private fun getAll() {
    mainViewModel.getAll().observe(this, { Doacao ->
        adapter.submitList(Doacao)

    })
//    }

//    fun deleteAll(id: MutableList<Int>)= runBlocking {
//        launch( Dispatchers.IO){
//            mainViewModel.deleteAll(id)
//        }
//    }
}
}
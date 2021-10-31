package com.example.myapplication.Ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.myapplication.App
import com.example.myapplication.Data.Doacao
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding


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
        delete()
        update()
    }
    private fun insertListener() {
       binding.FloatButton.setOnClickListener{
           val intent = Intent(this, AddDoacaoActivity::class.java)
           startActivity(intent)
       }
    }

    private fun getAll() {
    mainViewModel.getAll().observe(this, { Doacao ->
        adapter.submitList(Doacao)

      })
    }
    private  fun delete() {
        adapter.listenerDelete= {
            mainViewModel.deleteAll(it)
            Toast.makeText(this, "Excluído com Sucesso!", Toast.LENGTH_LONG).show()
            getAll()
        }
    }

    private fun update(){
        adapter.listernerUpdate={
            val intent = Intent(this, AddDoacaoActivity::class.java)
            startActivity(intent)
        }
    }
}

package com.example.myapplication.Ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
        update()
        delete()


    }


    private fun insertListener() {
       binding.FloatButton.setOnClickListener{
           val intent = Intent(this, AddDoacaoActivity::class.java)
           startActivity(intent)
       }
        adapter.listernerUpdate = {
            val intent = Intent(this, AddDoacaoActivity::class.java)
            intent.putExtra(AddDoacaoActivity.DOACAO_ID, it.id)
            startActivityForResult(intent, CREATE_NEW_TASK)

        }

    }
    private fun update() {
//        binding.doacoes.setOnClickListener {
//            val intent = Intent(this, AddDoacaoActivity::class.java)
//            startActivity(intent)
//        }
//        adapter.listernerUpdate = {
//            val intent = Intent(this, AddDoacaoActivity::class.java)
//            startActivity(intent)
//            mainViewModel.update(it)
//
//        }
        adapter.listernerUpdate = {
            val intent = Intent(this, AddDoacaoActivity::class.java)
            startActivity(intent)
            intent.putExtra(AddDoacaoActivity.DOACAO_ID, it.id)
            mainViewModel.update(it)
        }

    }

//
    private fun getAll() {
    mainViewModel.getAll().observe(this, { Doacao ->
        adapter.submitList(Doacao)

      })
    }


    private  fun delete() {
        adapter.listenerDelete= {
            mainViewModel.deleteAll(it)
            getAll()
        }

    }
    companion object{
        private const val  CREATE_NEW_TASK = 1000
    }


}
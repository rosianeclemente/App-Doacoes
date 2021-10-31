package com.example.myapplication.Ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.App
import com.example.myapplication.Data.Doacao
import com.example.myapplication.R
import com.example.myapplication.databinding.ActicityAddDoacaoBinding


class UpdateDoacaoActivity : AppCompatActivity(){
    private val binding by lazy { ActicityAddDoacaoBinding.inflate(layoutInflater) }
    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        upddateListeners()
    }

    private fun upddateListeners() {
        binding.buttonConfirme.setOnClickListener {
            finish()
        }
        binding.buttonConfirmar.setOnClickListener {
            val doacao = Doacao(
                id = 1,
                nome = binding.tilNome.editText?.text.toString(),
                contato = binding.tilContato.editText?.text.toString(),
                caracteristicas = binding.tilCaracteristicas.editText?.text.toString()

            )
            mainViewModel.update(doacao)
            Toast.makeText(this, R.string.Cadastro_realizado, Toast.LENGTH_LONG).show()
            finish()
        }

    }
}
package com.example.myapplication.Ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.App
import com.example.myapplication.Data.Doacao
import com.example.myapplication.R
import com.example.myapplication.Ui.ViewModel.MainViewModel
import com.example.myapplication.Ui.ViewModel.MainViewModelFactory
import com.example.myapplication.databinding.ActicityAddDoacaoBinding


class AddDoacaoActivity : AppCompatActivity(){
    private val binding by lazy { ActicityAddDoacaoBinding.inflate(layoutInflater) }
    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }
    private val adapter by lazy { DoacaoAdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        insertListeners()
        updateListeners()
    }



    private fun insertListeners() {
        binding.buttonConfirme.setOnClickListener {
            finish()
        }
        binding.buttonConfirmar.setOnClickListener {
            val doacao = Doacao(
                id = intent.getIntExtra(DOACAO_ID, 0),
                nome = binding.tilNome.editText?.text.toString(),
                contato = binding.tilContato.editText?.text.toString(),
                caracteristicas = binding.tilCaracteristicas.editText?.text.toString()

            )
            mainViewModel.insert(doacao)
            Toast.makeText(this, R.string.Cadastro_realizado, Toast.LENGTH_LONG).show()
            finish()
        }

    }
    private fun updateListeners() {
        binding.buttonConfirme.setOnClickListener {
            finish()
        }
        adapter.listernerUpdate= {
            val doacao = Doacao(
                id = this.taskId,
                nome = binding.tilNome.editText?.text.toString(),
                contato = binding.tilContato.editText?.text.toString(),
                caracteristicas = binding.tilCaracteristicas.editText?.text.toString()

            )
            mainViewModel.update(doacao)
            Toast.makeText(this, "Atualizado com sucesso", Toast.LENGTH_LONG).show()
            finish()
        }

    }


    companion object{
        const val DOACAO_ID = "doacao_id"
    }
}
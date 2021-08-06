package com.example.myapplication.Data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Doacao(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nome: String,
    val caracteristicas: String,
    val contato: String,
//    val imagem: String

) {
}
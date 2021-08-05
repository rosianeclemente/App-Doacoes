package com.example.myapplication

import android.app.Application
import androidx.room.Database
import com.example.myapplication.Data.DoacaoRepository

class App : Application() {
    val database by lazy { Database.getDatabase(this) }
    val repository by lazy { DoacaoRepository(database.doacaoDAO())}


}
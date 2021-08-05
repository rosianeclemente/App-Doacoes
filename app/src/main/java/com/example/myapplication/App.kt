package com.example.myapplication

import android.app.Application
import androidx.room.Database
import com.example.myapplication.Data.DoacaoRepository
import com.example.myapplication.Data.appDatabase
import com.example.myapplication.Data.appDatabase.Companion.getDatabase
import java.lang.reflect.Array.get

class App : Application() {
    val database by lazy { appDatabase.getDatabase(this) }
    val repository by lazy { DoacaoRepository(database.doacaoDAO()) }



}
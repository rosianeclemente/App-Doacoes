package com.example.myapplication.DATA

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Doacao::class], version = 1)
abstract class Database: RoomDatabase() {
    abstract fun doacaoDAO(): IDoacaoDAO
}
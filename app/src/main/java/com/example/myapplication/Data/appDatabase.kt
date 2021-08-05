package com.example.myapplication.Data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Doacao::class], version = 1, exportSchema = false)
abstract class appDatabase: RoomDatabase() {
    abstract fun doacaoDAO(): IDoacaoDAO
    companion object {
        @Volatile
        private var INSTACE: appDatabase? = null

        fun getDatabase(context: Context): appDatabase{
            return INSTACE?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    appDatabase::class.java,
                    "businesscard_db"
                ).build()
                INSTACE = instance
                instance
            }
        }

    }
}
package com.josemanuel.damflix.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//esta clase une la entidad con el dao

//registra las tablas, fija la versión del esquema y desactiva la exportación a JSON.
@Database(entities = [PeliculaEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    //KSP genera la implementación de este método
    abstract fun peliculaDao(): PeliculaDao
    companion object {
        //@Volatile: todos los hilos ven siempre el valor actualizado de INSTANCE
        @Volatile
        private var INSTANCE: AppDatabase? = null
        fun getDatabase(context: Context): AppDatabase {
//si ya existe la devuelve; si no, la crea un solo hilo a la vez (Singleton)
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                "damflix_room.db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
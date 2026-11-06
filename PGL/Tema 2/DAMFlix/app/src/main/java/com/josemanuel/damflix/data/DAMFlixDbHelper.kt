package com.josemanuel.damflix.data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DAMFlixDbHelper(context: Context) : SQLiteOpenHelper(
    context,
    DATABASE_NAME,
    null,
    DATABASE_VERSION
) {
    companion object { //el companion es un objeto declarado dentro de una clase que permite definir propiedades y métodos a nivel de clase
        private const val DATABASE_NAME = "damflix_native.db"
        private const val DATABASE_VERSION = 1
        const val TABLE_PELICULAS = "peliculas"
        const val COLUMN_ID = "id"
        const val COLUMN_TITULO = "titulo"
        const val COLUMN_DIRECTOR = "director"
        const val COLUMN_AÑO = "año"
        const val COLUMN_ES_FAVORITA = "esFavorita"
        const val COLUMN_PELICULA_VISTA = "peliculaVista"
    }
    override fun onCreate(db: SQLiteDatabase) { //default 0 proporciona el valor false si no se especifica la columna

        val createTableSql = """
            CREATE TABLE $TABLE_PELICULAS (
                $COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                $COLUMN_TITULO TEXT NOT NULL,
                $COLUMN_DIRECTOR TEXT NOT NULL,
                $COLUMN_AÑO INTEGER NOT NULL,
                $COLUMN_ES_FAVORITA INTEGER NOT NULL DEFAULT 0, 
                $COLUMN_PELICULA_VISTA INTEGER NOT NULL DEFAULT 0
            )
        """.trimIndent()

        db.execSQL(createTableSql) //execSQL ejecuta la sentencia que crea la tabla
    }

    //onUpgrade() se ejecuta cuando la versión de la base de datos del dispositivo es menor que la versión indicada en DATABASE_VERSION.
    override fun onUpgrade(
        db: SQLiteDatabase,
        oldVersion: Int,
        newVersion: Int
    ) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_PELICULAS")
        onCreate(db)
    }
}
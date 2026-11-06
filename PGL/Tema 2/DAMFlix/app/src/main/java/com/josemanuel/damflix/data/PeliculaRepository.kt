package com.josemanuel.damflix.data

import android.content.ContentValues
import com.josemanuel.damflix.model.Pelicula
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PeliculaRepository(private val dbHelper: DAMFlixDbHelper) {
    suspend fun obtenerTodas(): List<Pelicula> =
        withContext(Dispatchers.IO) {
            val lista = mutableListOf<Pelicula>()
            val db = dbHelper.readableDatabase
            val sql = "SELECT * FROM " +
                    DAMFlixDbHelper.TABLE_PELICULAS +
                    " ORDER BY " + DAMFlixDbHelper.COLUMN_ID + " DESC" //ordena por ID descendente
            val cursor = db.rawQuery(sql, null)
            cursor.use { c ->
                if (c.moveToFirst()) {
                    do { //lee primero la fila actual y después intenta pasar a la siguiente. Solo entra si moveToFirst encontró alguna fila. Si la tabla está vacía, retorna la lista vacía.
                        val id = c.getInt(
                            c.getColumnIndexOrThrow(
                                DAMFlixDbHelper.COLUMN_ID
                            )
                        )
                        val titulo = c.getString(
                            c.getColumnIndexOrThrow(
                                DAMFlixDbHelper.COLUMN_TITULO
                            )
                        )
                        val director = c.getString(
                            c.getColumnIndexOrThrow(
                                DAMFlixDbHelper.COLUMN_DIRECTOR
                            )
                        )
                        val año = c.getInt(
                            c.getColumnIndexOrThrow(
                                DAMFlixDbHelper.COLUMN_AÑO
                            )
                        )
                        val esFavorita = c.getInt(
                            c.getColumnIndexOrThrow(
                                DAMFlixDbHelper.COLUMN_ES_FAVORITA
                            )
                        ) == 1
                        val peliculaVista = c.getInt(
                            c.getColumnIndexOrThrow(
                                DAMFlixDbHelper.COLUMN_PELICULA_VISTA
                            )
                        ) == 1
                        lista.add(
                            Pelicula(
                                id = id,
                                titulo = titulo,
                                director = director,
                                año = año,
                                esFavorita = esFavorita,
                                peliculaVista = peliculaVista
                            )
                        )
                    } while (c.moveToNext())
                }
            }
            // Última expresión: resultado de withContext.
            lista
        }
    suspend fun insertar(pelicula: Pelicula): Long =
        withContext(Dispatchers.IO) {
            val db = dbHelper.writableDatabase
            val values = ContentValues().apply {
                put(DAMFlixDbHelper.COLUMN_TITULO, pelicula.titulo)
                put(DAMFlixDbHelper.COLUMN_DIRECTOR, pelicula.director)
                put(DAMFlixDbHelper.COLUMN_AÑO, pelicula.año)
                put(
                    DAMFlixDbHelper.COLUMN_PELICULA_VISTA,
                    if (pelicula.peliculaVista) 1 else 0
                )
                put(
                    DAMFlixDbHelper.COLUMN_ES_FAVORITA,
                    if (pelicula.esFavorita) 1 else 0
                )
            }
            // No añadimos el ID: lo genera la base de datos.
            db.insert(DAMFlixDbHelper.TABLE_PELICULAS, null, values)
        }

    suspend fun actualizar(pelicula: Pelicula): Int =
        withContext(Dispatchers.IO) {
            val db = dbHelper.writableDatabase
            val values = ContentValues().apply {
                put(DAMFlixDbHelper.COLUMN_TITULO, pelicula.titulo)
                put(DAMFlixDbHelper.COLUMN_DIRECTOR, pelicula.director)
                put(DAMFlixDbHelper.COLUMN_AÑO, pelicula.año)
                put(
                    DAMFlixDbHelper.COLUMN_PELICULA_VISTA,
                    if (pelicula.peliculaVista) 1 else 0
                )
                put(
                    DAMFlixDbHelper.COLUMN_ES_FAVORITA,
                    if (pelicula.esFavorita) 1 else 0
                )
            }
            db.update(
                DAMFlixDbHelper.TABLE_PELICULAS,
                values,
                "${DAMFlixDbHelper.COLUMN_ID} = ?",
                arrayOf(pelicula.id.toString())
            )
        }

}

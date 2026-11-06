package com.josemanuel.damflix.data.local

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow


//EL DAO(data access object) es una interfaz donde declaro las operaciones que existen, no escribo la implementación
interface PeliculaDao {
    //room vigila la tabla y emite la lista otra vez cada vez que cambia, por eso esta función no es suspend: no devuelve un resultado una vez, sino un flujo que sigue vivo.
    @Query("SELECT * FROM peliculas ORDER BY id DESC")
    fun obtenerTodas(): Flow<List<PeliculaEntity>>
    //suspend fun : las escrituras se ejecutan en una corrutina, fuera del hilo principal, para no congelar la pantalla.
    @Insert(onConflict = OnConflictStrategy.REPLACE) //con "OnConflictStrategy.REPLACE" consigo que al intestar una pelicula, pongo un id repetido, sobreescribe el resgistro existente
    suspend fun insertar(pelicula: PeliculaEntity)
    @Update
    suspend fun actualizar(pelicula: PeliculaEntity)
    @Delete
    suspend fun eliminar(pelicula: PeliculaEntity)
}
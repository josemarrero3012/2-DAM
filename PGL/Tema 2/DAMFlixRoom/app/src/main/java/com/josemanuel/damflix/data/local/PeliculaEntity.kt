package com.josemanuel.damflix.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

//La entiadad es la clase de kotlin que voy a representar en la tabla

@Entity(tableName = "peliculas") //cada propiedad que yo escriba en esta clase se convierte en una columna de la tabla de peliculas
data class PeliculaEntity(
    //id = 0 le indica a Room que el id lo debe generar SQLite al insertar
    @PrimaryKey(autoGenerate = true) //indico que la primary key es el id
    val id: Int = 0, //al crear una película no debo indidicar el id
    val titulo: String,
    val director: String,
    val año: Int,
    val esFavorita: Boolean = false,
    val peliculaVista: Boolean = false

    //room convierte los tipos solo, por ejemplo de string a text, e int y boolean a integer
)

package com.josemanuel.damflix.model

data class Pelicula(
    val id: Int,
    val titulo: String,
    val director: String,
    val año: Int,
    val esFavorita: Boolean = false
)

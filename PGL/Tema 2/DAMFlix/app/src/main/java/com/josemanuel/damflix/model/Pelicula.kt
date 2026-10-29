package com.josemanuel.damflix.model

data class Pelicula(
    val id: Int,
    val titulo: String,
    val director: String,
    val año: Int,
    val esFavorita: Boolean = false,
    //voy a añadir la funcionalidad de que el rellenar el formulario, la película ha de añadirse al catálogo. Tengo que agregar el atributo peliculaVista, ya que es uno de los campos del formulario
    val peliculaVista: Boolean = false
)

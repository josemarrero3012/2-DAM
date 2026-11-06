package com.josemanuel.damflix.ui.theme.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.josemanuel.damflix.data.PeliculaRepository
import com.josemanuel.damflix.model.Pelicula
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PeliculaViewModel(
    private val repository: PeliculaRepository
) : ViewModel() {
    // Solo este ViewModel puede sustituir la lista.
    private val _listaPeliculas =
        MutableStateFlow<List<Pelicula>>(emptyList())
    val listaPeliculas: StateFlow<List<Pelicula>> =
        _listaPeliculas.asStateFlow()
    init {
        cargarPeliculas()
    }
    fun cargarPeliculas() {
        viewModelScope.launch {
            _listaPeliculas.value = repository.obtenerTodas()
        }
    }
    fun agregarPelicula(
        titulo: String,
        director: String,
        año: Int,
        peliculaVista: Boolean
    ) {
        viewModelScope.launch {
            val nueva = Pelicula(
                id = 0,
                titulo = titulo,
                director = director,
                año = año,
                peliculaVista = peliculaVista
            )
            repository.insertar(nueva)
            // SQLite nativo no emite automáticamente otra lista.
            cargarPeliculas()
        }
    }
    fun conmutarFavorito(pelicula: Pelicula) {
        viewModelScope.launch {
            val actualizada = pelicula.copy(
                esFavorita = !pelicula.esFavorita
            )
            repository.actualizar(actualizada)
            cargarPeliculas()
        }
    }
}
package com.josemanuel.damflix.ui.theme.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.josemanuel.damflix.data.PeliculaRepository

//tengo que usar Factory porque el ViewModel necesita el repositorio en su constructor y android no sabe como meterlo solo
// T : ViewModel -> con esto obligo a que el tipo que me pidan sea sí o sí un ViewModel
// Class<T> y ::class.java -> los uso para comparar la clase que me están pidiendo con la mía propia
// as T -> aquí transformo el resultado al tipo exacto de ViewModel que me han solicitado
// @Suppress -> esto lo pongo para callar la advertencia amarilla de Android Studio porque yo se qu el tipo es correcto
// IllegalArgumentException -> si me piden un ViewModel que no sé fabricar, lanzo este error


class PeliculaViewModelFactory(
    private val repository: PeliculaRepository
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PeliculaViewModel::class.java)) {
            return PeliculaViewModel(repository) as T
        }
        throw IllegalArgumentException("ViewModel desconocido")
    }
}
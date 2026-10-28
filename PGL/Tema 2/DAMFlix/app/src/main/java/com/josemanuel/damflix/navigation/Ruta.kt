package com.josemanuel.damflix.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

//clase que define las diferentes rutas de las pantallas de la aplicación
//cada ruta tiene una dirección, un nombre (etiqueta visible en la pantalla) y un icono.
sealed class Ruta(val path: String, val label: String, val icon: ImageVector) {

    object PerfilScreen : Ruta(
        path = "perfil",
        label = "Perfil",
        icon = Icons.Filled.Person
    )

    object FormularioScreen : Ruta(
        path = "alta",
        label = "Añadir",
        icon = Icons.Filled.Add
    )

    object CatalogoScreen : Ruta(
        path = "catalogo",
        label = "Catálogo",
        icon = Icons.AutoMirrored.Filled.List
    )
}
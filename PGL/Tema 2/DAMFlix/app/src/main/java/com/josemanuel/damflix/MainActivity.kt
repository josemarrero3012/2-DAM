package com.josemanuel.damflix

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.josemanuel.damflix.navigation.Ruta
import com.josemanuel.damflix.view.screens.FormularioScreen
import com.josemanuel.damflix.ui.theme.DAMFlixTheme
import com.josemanuel.damflix.ui.theme.viewmodel.PeliculaViewModel
import com.josemanuel.damflix.ui.theme.viewmodel.PeliculaViewModelFactory
import com.josemanuel.damflix.view.screens.CatalogoScreen
import com.josemanuel.damflix.view.screens.PerfilScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //fase 5 sqlite
        val app = application as DAMFlixApplication
        val factory = PeliculaViewModelFactory(app.repository)

        enableEdgeToEdge()
        setContent {
            DAMFlixTheme {
                //obtiene el ViewModel gestionado por Android
                //si necesita crearlo, utiliza nuestra fábrica
                val peliculaViewModel: PeliculaViewModel = viewModel(factory = factory)

                // Entrega ese ViewModel a tu interfaz.
                DAMFlixApp(viewModel = peliculaViewModel)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DAMFlixApp(viewModel: PeliculaViewModel) {
    //navcontrol es el controlador que me va a ayudar a cambiar de pantallas
    val navController = rememberNavController()

    //Rastreo del estado de la ruta activa: Con navController.currentBackStackEntryAsState() se observa en tiempo real el destino actual de la pila de navegación, permitiendo marcar la pestaña seleccionada mediante la condición selected = rutaActual == ruta.path .

    //Se hace esto primero porque la interfaz gráfica necesita saber exactamente en qué pantalla está el usuario antes de poder dibujar el título correcto.

    //Observamos en tiempo real qué destino está activo en la pila
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val rutaActual = navBackStackEntry?.destination?.route

    // 3) Título de la barra superior según la pantalla en la que estemos
    val titulo = when (rutaActual) {
        Ruta.FormularioScreen.path -> "DAMFlix - Nueva película"
        Ruta.PerfilScreen.path -> "DAMFlix - Mi perfil"
        else -> "DAMFlix - Catálogo"
    }


    //la lista ya no vive aquí: viene de SQLite a través del ViewModel.
    //collectAsStateWithLifecycle convierte el StateFlow en estado de Compose
    val peliculas by viewModel.listaPeliculas.collectAsStateWithLifecycle()

    //scaffold sirve para crear la estructura básica de una pantalla de la aplicación, colocando cada elemento en su sitio
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text(titulo) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xBF118493),
                    titleContentColor = Color.Black
                )
            )
        },
        bottomBar = {
            NavigationBar { //define el orden de los iconos de cada pantalla en el bottombar
                listOf(Ruta.PerfilScreen, Ruta.FormularioScreen, Ruta.CatalogoScreen).forEach { ruta ->
                    NavigationBarItem(
                        selected = rutaActual == ruta.path,
                        onClick = {
                            // Evita navegar a la pestaña en la que ya estamos
                            if (rutaActual != ruta.path) {
                                navController.navigate(ruta.path) {
                                    // Limpia la pila hasta la raíz, guardando el estado
                                    popUpTo(navController.graph.startDestinationId) {
                                        saveState = true
                                    }
                                    // No apila copias de la misma pantalla
                                    launchSingleTop = true
                                    // Recupera el estado (scroll, textos...) al volver
                                    restoreState = true
                                }
                            }
                        },
                        icon = { Icon(ruta.icon, contentDescription = ruta.label) },
                        label = { Text(ruta.label) }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Ruta.PerfilScreen.path,
            modifier = Modifier.padding(innerPadding)
        ) {
            //cuando entra en la pestaña Catálogo, se muestra esta pantalla.
            composable(Ruta.CatalogoScreen.path) {
                CatalogoScreen(
                    //la lista publicada por el ViewModel (leída de SQLite)
                    peliculas = peliculas,
                    //el ViewModel hace UPDATE en SQLite y recarga la lista
                    onToggleFavorito = { pelicula ->
                        viewModel.conmutarFavorito(pelicula)
                    }
                )
            }

            // Cuando entro en la pestaña Añadir, se muestra el formulario.
            composable(Ruta.FormularioScreen.path) {
                FormularioScreen(
                    //el ViewModel hace INSERT en SQLite y recarga la lista
                    onGuardar = { titulo, director, año, vista ->
                        viewModel.agregarPelicula(titulo, director, año, vista)
                    }
                )
            }

            //cuando entro en la pestaña Perfil, se muestra mi pantalla de perfil.
            composable(Ruta.PerfilScreen.path) {
                PerfilScreen()
            }
        }
    }
}
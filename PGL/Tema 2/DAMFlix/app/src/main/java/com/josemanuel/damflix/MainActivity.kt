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
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.josemanuel.damflix.model.Pelicula
import com.josemanuel.damflix.navigation.Ruta
import com.josemanuel.damflix.view.screens.FormularioScreen
import com.josemanuel.damflix.ui.theme.DAMFlixTheme
import com.josemanuel.damflix.view.screens.CatalogoScreen
import com.josemanuel.damflix.view.screens.PerfilScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DAMFlixTheme {
                DAMFlixApp() //toda la navegación vive aquí
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DAMFlixApp() {
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


    //He movido la lista de CatalogoScreen() a DAMFlixApp() ya que esta función contiene tanto el catálogo como el formulario
    val peliculas = remember {
        mutableStateListOf(
            Pelicula(1, "Interstellar", "Christopher Nolan", 2014),
            Pelicula(2, "Coherence", "James Ward Byrkit", 2014),
            Pelicula(3, "Clayface", "James Watkins", 2026),
            Pelicula(4, "La cura del bienestar", "Gore Verbinski", 2017),
            Pelicula(5, "Whalefall", "Brian Duffield", 2026),
            Pelicula(6, "Mother!", "Matt Reeves", 2017),
            Pelicula(7, "American Psycho", "Mary Harron", 2000),
            Pelicula(8, "The Amazing Spider-Man 2", "Marc Webb", 2014),
            Pelicula(9, "El Camino: A Breaking Bad Movie", "Vince Gilligan", 2019),
            Pelicula(10, "La invitación", "Karyn Kusama", 2015),
            Pelicula(11, "El lobo de Wall Street", "Martin Scorsese", 2013),
            Pelicula(12, "El maquinista", "Brad Anderson", 2004)
        )
    }

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
                    //le paso la lista que tengo en DAMFlixApp para que dibuje las tarjetas
                    peliculas = peliculas,

                    //cuando pulso un corazón, el catálogo me entrega la película pulsada.
                    onToggleFavorito = { pelicula ->
                        // Busco en qué posición de la lista está esa película usando su id.
                        val posicion = peliculas.indexOfFirst {
                            it.id == pelicula.id
                        }

                        //creo una copia de esa película cambiando solo esFavorita:
                        //si era false, pasa a true; si era true, pasa a false.
                        //la coloco en la misma posición, sustituyendo a la anterior.
                        //compose detecta el cambio y actualiza el corazón en pantalla.
                        peliculas[posicion] = pelicula.copy(
                            esFavorita = !pelicula.esFavorita
                        )
                    }
                )
            }

            // Cuando entro en la pestaña Añadir, se muestra el formulario.
            composable(Ruta.FormularioScreen.path) {
                FormularioScreen(
                    //cuando pulso Guardar, el formulario llama a onGuardar.
                    //aquí recibo el título, el director, el año y si la he visto.
                    onGuardar = { titulo, director, año, vista ->
                        //con los datos que acabo de recibir, creo la nueva película.
                        val nuevaPelicula = Pelicula(
                            //como tengo los ids seguidos y no elimino películas,
                            //si hay 12 películas, la siguiente tendrá el id 13.
                            id = peliculas.size + 1,
                            titulo = titulo,
                            director = director,
                            año = año,
                            peliculaVista = vista
                        )

                        //añado la nueva película al final de la lista compartida.
                        //cuando entre en Catálogo, aparecerá como una tarjeta más.
                        peliculas.add(nuevaPelicula)
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
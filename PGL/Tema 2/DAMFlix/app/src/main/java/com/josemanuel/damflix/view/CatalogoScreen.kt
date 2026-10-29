package com.josemanuel.damflix.view.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.josemanuel.damflix.R
import com.josemanuel.damflix.model.Pelicula
import com.josemanuel.damflix.ui.theme.DAMFlixTheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.state.ToggleableState


@Composable  //"onToggleFavorito: (Pelicula) -> Unit" Este parámetro contiene una función que se ejecutará cuando se pulse un corazón
//Necesitamos enviarle la película para que quien gestione la lista sepa qué película debe cambiar de favorita a no favorita, o al revés. El nombre onToggleFavorito lo elegimos nosotros; no es una función especial de Compose.
fun CatalogoScreen(peliculas: List<Pelicula>, onToggleFavorito: (Pelicula) -> Unit) {
    // Requisito 2: LazyColumn que es una lista vertical
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(10.dp), //margen alrededor de la lista tanto a los laterales como arriba y abajo
        verticalArrangement = Arrangement.spacedBy(10.dp) //10 dp de separación entre cada película
    ) {
        //Requisito 4: key única
        //items es una función de lazycolumn que crea tantas filas como películas haya
        //por cada película de la lista peliculas, dibuja una fila, y usa el id de la película como identificador único de esa fila
        items(items = peliculas, key = { pelicula -> pelicula.id }) { pelicula ->

            //uso una tarjeta para envolver cada película
            Card(modifier = Modifier.fillMaxWidth()) {
                //voy a dividirlo de la siguiente manera, una fila, que es un primer elemento va a estar constituito por una columna de 2 textos (nombre de la película y director, y a su derecha, el corazon
                Row(
                    modifier = Modifier.padding(12.dp), // margen interior de la tarjeta
                    verticalAlignment = Alignment.CenterVertically // centra textos y corazón en vertical
                ) {
                    //columna con título y subtítulo
                    // weight(1f) coge todo espacio y empuja hasta el final al icono
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = pelicula.titulo,
                            style = MaterialTheme.typography.titleMedium
                        )
                        Text(
                            //"%1$s • %2$d" rellenada con director y año
                            text = stringResource(
                                R.string.catalogo_subtitulo, pelicula.director, pelicula.año
                            ),
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }

                    //Requisito 3: Incluir un botón IconButton con icono de corazón para marcar
                    //o desmarcar películas como "Favoritas", provocando la recomposición instantánea de la
                    //tarjeta
                    IconButton(
                        //al pulsar marcar o desmarcar como favorita
                        onClick = {
                            onToggleFavorito(pelicula)
                        }
                    ) {
                        Icon( //imageVector contiene el dibujo, Icon es el componente que lo muestra en pantalla
                            imageVector = if (pelicula.esFavorita) {
                                Icons.Filled.Favorite
                            } else {
                                Icons.Outlined.FavoriteBorder
                            },
                            contentDescription = stringResource(
                                if (pelicula.esFavorita) {
                                    R.string.catalogo_desmarcar_favorita
                                } else {
                                    R.string.catalogo_marcar_favorita
                                }
                            ),
                            tint = if (pelicula.esFavorita) {
                                MaterialTheme.colorScheme.error
                            } else {
                                MaterialTheme.colorScheme.onSurfaceVariant
                            }
                        )
                    }
                }
            }
        }
    }
}

// El preview permite ver el catálogo en Android Studio sin ejecutar la aplicación.
// Como CatalogoScreen recibe una lista, aquí también hay que pasarle una:
// puede contener una, dos o las doce películas, según lo que queramos visualizar.
// Esas películas son datos de ejemplo y no se añaden a la lista real de DAMFlixApp.
// Al ejecutar la app, el catálogo recibe la lista real desde DAMFlixApp.
// En el preview, onToggleFavorito = {} pasa una función vacía: no cambia favoritos.
@Preview
@Composable
fun CatalogoScreenPreview() {
    DAMFlixTheme {
        CatalogoScreen(
            peliculas = listOf(
                Pelicula(
                    1,
                    "Interstellar",
                    "Christopher Nolan",
                    2014
                )
            ),
            onToggleFavorito = {}
        )
    }
}
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


@Composable
fun CatalogoScreen() {
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
                            //al clickarlo, primero ha de buscar la posición de esta película en la lista por su id
                            val posicion = peliculas.indexOfFirst { it.id == pelicula.id }
                            //este siguiente paso tuve que preguntarle a la ia, y aun así me cuesta entenderlo, al darle me gusta a una corazón, la propiedad val esFavorita y no puede cambiar directamente, la clave es crear una copia de la película con la variable esFavorita invertida, para tener una copia en true, y la coloco en la misma posicón sustituyendo a la vieja
                            //en el caso de haber cliclado coherence, la pelicula con id = 2, y posición 1
                            //peliculas[1] = copia de coherence con esFavorita = true
                            peliculas[posicion] = pelicula.copy(esFavorita = !pelicula.esFavorita)
                        }
                    ) {
                        Icon(
                            //el corazon se rellena si la marcas como favorita
                            imageVector = if (pelicula.esFavorita) Icons.Filled.Favorite
                            else Icons.Outlined.FavoriteBorder,
                            contentDescription = stringResource(
                                if (pelicula.esFavorita) R.string.catalogo_desmarcar_favorita
                                else R.string.catalogo_marcar_favorita
                            ),
                            //rojo del tema si es favorita, gris si no
                            tint = if (pelicula.esFavorita) MaterialTheme.colorScheme.error
                            else MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        }
    }
}


@Preview
@Composable
fun CatalogoScreenPreview() {
    DAMFlixTheme {
        CatalogoScreen()
    }
}
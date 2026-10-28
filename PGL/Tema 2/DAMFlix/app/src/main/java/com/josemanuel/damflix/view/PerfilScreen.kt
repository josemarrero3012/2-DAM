package com.josemanuel.damflix.view.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.josemanuel.damflix.R
import com.josemanuel.damflix.ui.theme.DAMFlixTheme

@Composable
fun PerfilScreen(modifier: Modifier = Modifier) {
    Column (
        modifier = modifier
            .fillMaxSize() //ocupa toda pantalla
            .padding(24.dp), //deja un margen de 24 unidades en los 4 lados
        horizontalAlignment = Alignment.CenterHorizontally //centra horizontalmente todos los hijos de la columna
    ) {
        //Avatar redondo con el borde
        Image (
            painter = painterResource(id = R.drawable.avatar),
            contentDescription = stringResource(R.string.perfil_avatar_desc),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
                .border(3.dp, Color(0xBF118493), CircleShape)//.border(3.dp, MaterialTheme.colorScheme.primary, CircleShape) en caso de querer coger el color primario de la app
        )
        Spacer(modifier = Modifier.height(16.dp)) //deja un espacio de 16 unidades con el siguiente elemento

        //Nombre del usuario y rol
        Text(
            text = stringResource(R.string.perfil_nombre),
            style = MaterialTheme.typography.headlineSmall, //estilo tipográfico de titular pequeño
            fontWeight = FontWeight.Bold //en negrita
        )
        Text(
            text = stringResource(R.string.perfil_rol),
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant //color secundario del tema
        )
        Spacer(modifier = Modifier.height(24.dp))

        //Estadísticas estáticas
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            // películas vistas
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = stringResource(R.string.perfil_stat_vistas_valor),
                    style = MaterialTheme.typography.headlineMedium,
                    color = Color(0xBF118493),
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = stringResource(R.string.perfil_stat_vistas_label),
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Center
                )
            }

            // Reseñas
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = stringResource(R.string.perfil_stat_resenas_valor),
                    style = MaterialTheme.typography.headlineMedium,
                    color = Color(0xBF118493),
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = stringResource(R.string.perfil_stat_resenas_label),
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Center
                )
            }
        }
        Spacer(modifier = Modifier.height(24.dp))

        //Ficha de bienvenida
        Card(modifier = Modifier.fillMaxWidth()) { //card de Material 3 a todo el ancho: la “ficha” con fondo y esquinas redondeadas.
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = stringResource(R.string.bienvenida_titulo),
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = stringResource(R.string.bienvenida_texto),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PerfilScreenPreview() {
    DAMFlixTheme {
        PerfilScreen()
    }
}
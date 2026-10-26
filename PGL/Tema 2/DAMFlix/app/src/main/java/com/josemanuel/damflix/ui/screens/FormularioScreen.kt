package com.josemanuel.damflix.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.josemanuel.damflix.R
import com.josemanuel.damflix.ui.theme.DAMFlixTheme

@Composable
fun FormularioScreen(modifier: Modifier = Modifier) {

    //===== ESTADO =====
    //remember: conserva el valor entre recomposiciones
    //mutableStateOf: hace que Compose se entere cuando el valor cambia
    //by: permite usar la variable como un String normal (sin .value)
    var titulo by remember { mutableStateOf("") }      // texto del campo Título
    var director by remember { mutableStateOf("") }    // texto del campo Director/a
    var anio by remember { mutableStateOf("") }        // texto del campo Año (String, porque un campo de texto siempre es texto)
    var esVista by remember { mutableStateOf(false) }  // checkbox: false = pendiente, true = vista

    //===== VALIDACIÓN =====
    //es true solo si el título y el director tienen texto (isNotBlank ignora los espacios en blanco).
    //se recalcula con cada tecla que se escribe, porque el estado cambia y se recompone.
    val formularioValido = titulo.isNotBlank() && director.isNotBlank()

    //toast necesita el context de android para mostrarse
    val context = LocalContext.current

    // Mensaje de confirmación leído de strings.xml; %1$s se sustituye por el título.
    // Se lee aquí (fuera del onClick) porque stringResource solo se puede usar en el cuerpo de una composable.
    val mensajeGuardada = stringResource(R.string.form_msg_guardada, titulo)

    // ===== INTERFAZ =====
    // Columna principal: todo el contenido, uno debajo de otro
    Column(
        modifier = modifier
            .fillMaxSize()   // ocupa toda la pantalla
            .padding(24.dp)  // margen interior de 24 dp
    ) {
        // Título de la pantalla ("Nueva película")
        Text(
            text = stringResource(R.string.form_titulo_pantalla),
            style = MaterialTheme.typography.headlineSmall
        )

        // Hueco vertical de 16 dp
        Spacer(modifier = Modifier.height(16.dp))

        // Campo: Título
        OutlinedTextField(
            value = titulo,                       // lo que muestra el campo (el estado)
            onValueChange = { titulo = it },      // al escribir, guarda el nuevo texto (it) en el estado
            label = { Text(text = stringResource(R.string.form_label_titulo)) }, // etiqueta flotante
            singleLine = true,                    // una sola línea
            modifier = Modifier
                .fillMaxWidth()                   // a todo el ancho
                .padding(vertical = 4.dp)         // 4 dp arriba y abajo para separar los campos
        )

        // Campo: Director/a (igual que el anterior, pero con su propio estado)
        OutlinedTextField(
            value = director,
            onValueChange = { director = it },
            label = { Text(text = stringResource(R.string.form_label_director)) },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
        )

        // Campo: Año de estreno
        OutlinedTextField(
            value = anio,
            onValueChange = { anio = it },
            label = { Text(text = stringResource(R.string.form_label_año)) },
            singleLine = true,
            // Abre el teclado numérico en lugar del normal
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
        )

        // Fila con el checkbox y su texto, centrados verticalmente entre sí
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = esVista,                  // marcado o no según el estado
                onCheckedChange = { esVista = it }  // al pulsar, guarda el nuevo valor (true/false)
            )
            Text(text = stringResource(R.string.form_check_vista))
        }

        // Hueco vertical antes del botón
        Spacer(modifier = Modifier.height(16.dp))

        // Botón "Guardar película"
        Button(
            // Código que se ejecuta al pulsar el botón
            onClick = {
                // Muestra un mensaje breve de confirmación
                Toast.makeText(
                    context,
                    mensajeGuardada,
                    Toast.LENGTH_SHORT
                ).show()
                // Limpiamos el formulario: al cambiar los estados, la pantalla se actualiza sola
                titulo = ""
                director = ""
                anio = ""
                esVista = false
            },
            // Validación dinámica: el botón solo se puede pulsar si el formulario es válido
            enabled = formularioValido,
            modifier = Modifier.fillMaxWidth()
        ) {
            // Contenido del botón: su texto
            Text(text = stringResource(R.string.form_btn_guardar))
        }
    }
}

// Vista previa en Android Studio (no se ejecuta en la app real)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun FormularioScreenPreview() {
    // El tema da los colores y tipografías de la app a la vista previa
    DAMFlixTheme {
        FormularioScreen()
    }
}
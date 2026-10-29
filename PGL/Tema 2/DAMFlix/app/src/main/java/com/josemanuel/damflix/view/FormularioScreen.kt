package com.josemanuel.damflix.view.screens

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

/*Requisitos Funcionales:
1) Campos de Entrada: Crear un formulario con campos para el Título de la
película, Director/a y Año de estreno con OutlinedTextField.
2) Selección e Interacción: Incluir un Checkbox para indicar si la película ya ha
sido vista o está pendiente.
.
3) Gestión de Estado: Guardar el contenido de los campos mediante remember y
mutableStateOf.
4) Validación Dinámica: El botón "Guardar Película" debe permanecer
deshabilitado si el título o director están vacíos.*/

@Composable //ahora necesito que el formulario comunique los datos
//onGuardar va a ser la función que recibe el título, director, año, y si la película se ha visto
fun FormularioScreen(modifier: Modifier = Modifier, onGuardar: (String, String, Int, Boolean) -> Unit) {

    //Estado de las variables
    //remember: conserva el valor entre recomposiciones
    //mutableStateOf: hace que Compose se entere cuando el valor cambia
    //by: permite usar la variable como un String normal (sin .value)
    var titulo by remember { mutableStateOf("") }
    var director by remember { mutableStateOf("") }
    var año by remember { mutableStateOf("") }
    var peliculaVista by remember { mutableStateOf(false) } //checkbox: false = pendiente, true = vista

    //Validaciones (creo variables para las validaciones)
    //el botón "Guardar Película" debe permanecer deshabilitado si el título o director están vacíos

    //entonces creo una variable que diga si el formulario es válido o no, si el campo de titulo o director está vacío, no es válido
    val formularioValido = titulo.isNotBlank() && director.isNotBlank()

    //toast necesita el context de android para mostrarse
    val context = LocalContext.current

    //mensaje de confirmación leído de strings.xml; %1$s se sustituye por el título.
    // Se lee aquí (fuera del onClick) porque stringResource solo se puede usar en el cuerpo de una composable.
    val mensajePeliculaGuardada = stringResource(R.string.form_msg_guardada, titulo)

    //Interfaz
    Column(
        modifier = modifier
            .fillMaxSize()   // ocupa toda la pantalla
            .padding(80.dp)  // margen interior de 24 dp
    ) {

        Spacer(modifier = Modifier.height(16.dp))
        // Campo: título, el ejercicio pide usar OutlinedTextField
        OutlinedTextField(
            value = titulo, // lo que muestra el campo antes de escribir, var si hubiera escrito "titulo by remember { mutableStateOf("hola") }" pues aparecería "hola" en el campo
            onValueChange = { titulo = it }, // al escribir, guarda el nuevo texto (it) en el estado
            label = { Text(text = stringResource(R.string.form_label_titulo)) }, // la etiqueta flotante que hay justo encima del campo
            singleLine = true, // con esto evito que se pueda hacer un salto de linea dentro del propio campo, es decir, solo se puede escribir horizontalmente
            modifier = Modifier
                .fillMaxWidth()// a todo el ancho
                .padding(vertical = 4.dp)// 4 dp arriba y abajo para separar los campos
        )

        //campo director
        OutlinedTextField(
            value = director,
            onValueChange = { director = it },
            label = { Text(text = stringResource(R.string.form_label_director)) },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
        )

        //campo año de estreno
        OutlinedTextField(
            value = año,
            onValueChange = { año = it },
            label = { Text(text = stringResource(R.string.form_label_año)) },
            singleLine = true,
            //me interesa que solo se pueda abrir el teclado numérico, esto lo consigo con KeyboardOptions
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
        )

        //fila con el checkbox y su texto, centrados verticalmente entre sí, me interesa para que salga el cuadro del checkbox, y justo a su derecha, el texto "Ya he visto esta película"
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = peliculaVista, //lee el estado (comienza en false). Cambia a true si hago click en el checbox y se marca
                onCheckedChange = { peliculaVista = it }  //guardar el nuevo estado en la variable peliculaVista
            )
            Text(text = stringResource(R.string.form_check_vista))
        }

        //hueco vertical antes del botón
        Spacer(modifier = Modifier.height(16.dp))

        //botón para guardar la película
        Button(
            onClick = { //al hacer click...
                onGuardar(
                    titulo,
                    director,
                    año.toIntOrNull() ?: 0, //si no se puede convertir o es nulo, valdrá 0
                    peliculaVista
                )
                //muestra un mensaje breve de confirmación
                Toast.makeText(
                    context,
                    mensajePeliculaGuardada, //esta variable la declaré arriba en "Validación", y es igual a una string referenciada en "strings.xml"
                    Toast.LENGTH_SHORT //define la cantidad de tiempo que va a mostrar el mensaje en pantalla, short en unos 2 segundos, LONG sería unos 3,5 segundos
                ).show()
                //al clickar el botón, finalmente, se limpian los campos
                titulo = ""
                director = ""
                año = ""
                peliculaVista = false //importante "reiniciar" la condición a false, porque si no se mantiene en true, aunque al introducir de nuevo otra película el campo del título y del director estén vacíos
            },
            //validación dinámica: el botón solo se puede pulsar si el formulario es válido
            enabled = formularioValido,
            modifier = Modifier.fillMaxWidth()
        ) {
            //texto dentro del botón
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
        FormularioScreen(
            //la vista previa solo enseña el formulario; no necesita guardar una película.
            //esta función vacía ocupa el lugar del onGuardar obligatorio.
            onGuardar = { _, _, _, _ -> }
        )
    }
}
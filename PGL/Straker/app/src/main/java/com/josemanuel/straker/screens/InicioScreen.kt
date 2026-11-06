package com.josemanuel.straker.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.josemanuel.straker.R
import com.josemanuel.straker.ui.theme.StrakerTheme

@Composable
fun InicioScreen(modifier: Modifier = Modifier) {

    var usuario by remember { mutableStateOf("") }
    var contraseña by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(id = R.drawable.strakerlogo),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(top = 170.dp)
                .size(130.dp)
        )
        Spacer(modifier = Modifier.height(30.dp))

        OutlinedTextField (
            value = usuario,
            onValueChange = { usuario = it },
            label = { Text(text = stringResource(id = R.string.usuario_label)) },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
        )
        OutlinedTextField (
            value = contraseña,
            onValueChange = { contraseña = it },
            label = { Text(text = stringResource(id = R.string.contraseña_label)) },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
        )
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun InicioScreenPreview() {
    StrakerTheme {
        InicioScreen()
    }
}
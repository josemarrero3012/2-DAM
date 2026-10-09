package com.example.autopark

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvTituloPark = findViewById<TextView>(R.id.tvTituloPark)
        val etConductor = findViewById<EditText>(R.id.etConductor)
        val etHoras = findViewById<EditText>(R.id.etHoras)
        val btnReservar = findViewById<Button>(R.id.btnReservar)

        btnReservar.setOnClickListener {
            //CORRECCIÓN DE ERRORES DE FUNCIONAMIENTO

            //Voy a validar que no se permiten introducir caractéres vacío en los campos
            if (etConductor.text.toString().isEmpty()) { //con isEmpty compruebo si está vacío
                Toast.makeText(this, "El campo del nombre del conductor no puede estar vacío", Toast.LENGTH_LONG).show()
                return@setOnClickListener //detiene inmediatamente el código del botón para que la aplicación no siga procesando un formulario vacío
            }
            //ahora hago lo mismo con el dato del numero de horas
            if (etHoras.text.toString().isEmpty()) {
                Toast.makeText(this, "El campo del número de horas no puede estar vacío", Toast.LENGTH_LONG).show()
                return@setOnClickListener //detiene inmediatamente el código del botón para que la aplicación no siga procesando un formulario vacío
            }

            val conductor = etConductor.text.toString()
            val horas = etHoras.text.toString().toInt()

            //He cambiado los nombres de las variables que manda por "conductor" y "horas" para que coincida con las de la segunda pantalla
            val intent = Intent(this, TicketActivity::class.java)
            intent.putExtra("conductor", conductor)
            intent.putExtra("horas", horas)
            startActivity(intent)
        }
    }
}
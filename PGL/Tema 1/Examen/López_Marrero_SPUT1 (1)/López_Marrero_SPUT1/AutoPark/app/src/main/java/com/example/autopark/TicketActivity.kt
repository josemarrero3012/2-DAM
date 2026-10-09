package com.example.autopark

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class TicketActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ticket)

        //AMPLIACIÓN DE FUNCIONALIDAD
        //Me pide añadir un "EditText" y un "TextView", ya lo hice en el xml design y ahora me falta declararlas
        val etValor = findViewById<EditText>(R.id.etValor)
        val tvTarifa = findViewById<TextView>(R.id.tvTarifa)
        //añadí un botón para que al pulsar, haga el cálculo del valor y las horas
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val btnVolver = findViewById<Button>(R.id.btnVolver)

        val tvConductor = findViewById<TextView>(R.id.tvConductor)
        val tvHoras = findViewById<TextView>(R.id.tvHoras)
        val conductor = intent.getStringExtra("conductor") ?: "Desconocido"
        val horas = intent.getIntExtra("horas", 0)

        //Si el tiempo es superior al valor introducido en el "EditText" debe mostrar "Tarifa Larga Estancia (Descuento 20%)"
        //Si el tiempo es inferior o igual al valor debe mostrar "Tarifa Estándar: 2.50€/hora".
        btnCalcular.setOnClickListener {
            //Guardo al valor que introduzco en una variable "valor" y la paso a int.
            //Si es null salta el mensaje de que que introduce una valor válido
            val valor = etValor.text.toString().toIntOrNull() //el valor se lee al pulsar el botón, en onCreate el campo estaría vacío
            if (valor == null) { //si está vacío toIntOrNull devuelve null
                Toast.makeText(this, "Introduce un valor válido", Toast.LENGTH_SHORT).show()
                return@setOnClickListener //detiene inmediatamente el código del botón para que la aplicación no siga procesando un formulario vacío
            }
            if (horas > valor) {
                //Si las horas es mayor al valor introducido en el "editText" le asigno al TextView con ".text" la cadena string correspondiente
                tvTarifa.text = "Tarifa Larga Estancia (Descuento 20%)"
            } else { //Contempla si es menor o igual
                tvTarifa.text = "Tarifa Estándar: 2.50€/hora"
            }
        }

        btnVolver.setOnClickListener {
            val intent = Intent(this@TicketActivity, MainActivity::class.java) //Conecto esta activity con la main
            startActivity(intent)
        }

        tvConductor.text = "Conductor: $conductor"
        tvHoras.text = "Tiempo: $horas horas"
    }
}

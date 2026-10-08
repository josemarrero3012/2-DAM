package com.example.actividadrepaso

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SegundaActivity : AppCompatActivity()  {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_segunda)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Desde mainactivity he enviado
        // intent.putExtra("nombre", etNombre.text.toString())
        //intent.putExtra("apellido", etApellidos.text.toString())
        //intent.putExtra("dni", etDNI.text.toString())
        val tvNombre = findViewById<TextView>(R.id.tvNombre2)
        val tvApellido = findViewById<TextView>(R.id.tvApellidos2)
        val tvDNI = findViewById<TextView>(R.id.tvDNI2)

        // Recojo los datos enviados desde MainActivity
        val nombre = intent.getStringExtra("nombre")
        val apellido = intent.getStringExtra("apellido")
        val dni = intent.getStringExtra("dni")

        // Muestro los datos
        tvNombre.text = nombre
        tvApellido.text = apellido
        tvDNI.text = dni
    }
}
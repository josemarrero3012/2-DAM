package com.example.aplicacionvistas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Segunda : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_segunda)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //Definimos un objeto Bundle para acceder a los datos que se han enviado desde la otra Activty
        val bundle = intent.extras
        val usuario  = bundle?.getString("usuario")

        //Accedemos a los componentes que definimos en fichero xml asociado a esta Activity.
        val tvusuario = findViewById<TextView>(R.id.tvUsuario)
        val btnvolver = findViewById<Button>(R.id.btnVolver)

        tvusuario.text = "Hola ${usuario}"

        //Definimos el listener para el boton volver
        btnvolver.setOnClickListener {
            //Creamos el objeto Intent para comunicarnos con la Activity Principal
            val intento2 = Intent(this@Segunda, MainActivity::class.java)
            //Iniciamos la activity
            startActivity(intento2)
        }

    }
}
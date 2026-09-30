package com.example.aplicacionvistas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //Accedemos a los componentes que definimos en fichero xml asociado a esta Activity.
        val etusuario = findViewById<EditText>(R.id.etUsuario)
        val etpassword = findViewById<EditText>(R.id.etPassword)
        val btnacceder = findViewById<Button>(R.id.btnAcceder)

        //Definimos el listener para el boton acceder
        btnacceder.setOnClickListener {
            //Creamos el objeto Intent para comunicarnos con la otra Activity
            val intento1 = Intent(this@MainActivity, Segunda::class.java)
            //Pasamos el parámetro en este caso el nombre de usuario.
            intento1.putExtra("usuario",etusuario.text.toString())
            //Iniciamos la actividad
            startActivity(intento1)
        }
    }
}
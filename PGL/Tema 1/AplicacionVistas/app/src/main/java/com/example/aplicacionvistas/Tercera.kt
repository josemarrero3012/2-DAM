package com.example.aplicacionvistas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Tercera : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tercera)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Declaro las variables del botón y el textview
        val btnVolver2 = findViewById<Button>(R.id.btnVolver2)
        val mostrarContraseña = findViewById<TextView>(R.id.tvContraseña)

        val contraseña = intent.getStringExtra("password")
        mostrarContraseña.text = contraseña

        btnVolver2.setOnClickListener {
            val intento = Intent(this@Tercera, MainActivity::class.java)
            startActivity(intento)
        }
    }
}



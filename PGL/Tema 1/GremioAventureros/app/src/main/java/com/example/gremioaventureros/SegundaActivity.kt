package com.example.gremioaventureros

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SegundaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_segunda)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tvHeroe2 = findViewById<TextView>(R.id.tvHeroe2)
        val tvClaseRango = findViewById<TextView>(R.id.tvClaseRango)
        val btnVolverGremio = findViewById<Button>(R.id.btnVolverGremio)

        val datos = intent.extras

        val nombreHeroe2 = datos?.getString("nombreHeroe") //recibo el nombre del herie para el textview
        val clase = datos?.getString("clase")
        val nivel = datos?.getString("nivel")

        val rango = when (nivel.toString().toInt()) {
            in 1..10 -> "Novato"
            in 11..50 -> "Veterano"
            in 51..98 -> "Héroe"
            99 -> "Leyenda"
            else -> "Desconocido"
        }

        tvHeroe2.text = nombreHeroe2
        tvClaseRango.text = "$clase - $rango"

        btnVolverGremio.setOnClickListener {
            val intent2 = Intent(this@SegundaActivity, MainActivity::class.java) //conecta mainactivity con segundaactivity
            startActivity(intent2)
        }
    }
}
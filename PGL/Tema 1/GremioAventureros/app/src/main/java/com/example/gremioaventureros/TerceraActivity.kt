package com.example.gremioaventureros

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TerceraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tercera)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tvApp = findViewById<TextView>(R.id.tvApp)
        val tvVersion = findViewById<TextView>(R.id.tvVersion)
        val tvRumorAleatorio = findViewById<TextView>(R.id.tvRumorAleatorio)
        val btnRumorAleatorio = findViewById<Button>(R.id.btnRumorAleatorio)
        val btnVolver = findViewById<Button>(R.id.btnVolver)

        val datos = intent.extras
        val nombreApp = datos?.getString("nombreApp")
        val versionApp = datos?.getString("versionApp")

        tvApp.text = nombreApp
        tvVersion.text = versionApp

        val rumores = listOf(
            "Dicen que un mago perdió su barba en una apuesta contra un enano borracho.",
            "Se rumorea que en el sótano de esta taberna duerme un dragón muy pequeño.",
            "Un guerrero juró haber derrotado a cien orcos… aunque nadie le vio salir de la taberna.",
            "Cuentan que la tabernera fue una vez la mejor espadachina del reino.",
            "Dicen que la cerveza de la casa la bendijo un clérigo, y por eso nadie tiene resaca.",
            "Se comenta que el mago de la torre del norte busca aprendices… pero ninguno vuelve.",
            "Un bardo asegura que bajo la tercera mesa hay un mapa del tesoro escondido.",
            "Dicen que el caballero del rincón lleva diez años esperando a que deje de llover."
        )
        tvRumorAleatorio.text = "Rumor aleatorio: ${rumores.random()}"

        btnRumorAleatorio.setOnClickListener {
            tvRumorAleatorio.text = "Rumor aleatorio: ${rumores.random()}"
        }

        btnVolver.setOnClickListener {
            val intent3 = Intent(this@TerceraActivity, MainActivity::class.java) //conecta mainactivity con segundaactivity
            startActivity(intent3)
        }
    }
}
package com.example.gremioaventureros

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
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

        val tvTitulo = findViewById<TextView>(R.id.tvTitulo)
        val etHeroe = findViewById<EditText>(R.id.etHeroe)
        val etClase = findViewById<EditText>(R.id.etClase)
        val etNivel = findViewById<EditText>(R.id.edNivel)
        val etPfuerza = findViewById<EditText>(R.id.etPfuerza)
        val etPmagia = findViewById<EditText>(R.id.etPmagia)
        val btnCrearFicha = findViewById<Button>(R.id.btnCrearFicha)
        val btnTirarDado = findViewById<Button>(R.id.btnTirarDado)
        val btnTaberna = findViewById<Button>(R.id.btnTaberna)

        btnCrearFicha.setOnClickListener {
            if (etClase.text.toString().isEmpty()) {
                Toast.makeText(
                    this,
                    "El campo del nombre del héroe no puede estar vacío",
                    Toast.LENGTH_LONG
                ).show()
                return@setOnClickListener //detiene inmediatamente el código del botón para que la aplicación no siga procesando un formulario vacío
            }
            if (etClase.text.toString() != "Guerrero" && etClase.text.toString() != "Mago" && etClase.text.toString() != "Pícaro") {
                Toast.makeText(this, "La clase debe ser Guerrero, Mago o Pícaro", Toast.LENGTH_LONG)
                    .show()
                return@setOnClickListener
            }
            val puntosNivel = etPfuerza.text.toString().toIntOrNull()
            if (puntosNivel == null || puntosNivel !in 1..99) {
                Toast.makeText(this, "Los puntos de fuerza deben estar entre 1 y 99", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            //La suma de puntos de fuerza y puntos de magia no puede ser mayor a 20, ya que se disponen de 20 puntos totales a repartir
            val puntosFuerza = etPfuerza.text.toString().toIntOrNull()
            val puntosMagia = etPmagia.text.toString().toIntOrNull()
            val sumaPuntos = puntosFuerza!! + puntosMagia!! //con !! le estoy diciendo que estoy seguro de que no es nulo y que lo trate como entero
            if (sumaPuntos != 20) {
                Toast.makeText(this, "La suma de puntos de fuerza y puntos de magia no puede ser distinto de 20", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            val intent1 = Intent(this@MainActivity, SegundaActivity::class.java)
            intent1.putExtra("nombreHeroe", etHeroe.text.toString())
            intent1.putExtra("clase", etClase.text.toString())
            intent1.putExtra("nivel", etNivel.text.toString())
            intent1.putExtra("fuerza", etPfuerza.text.toString())
            intent1.putExtra("magia", etPmagia.text.toString())
            startActivity(intent1)
        }

        btnTaberna.setOnClickListener {
            val nombreApp = getString(R.string.app_name)
            val versionApp = packageManager.getPackageInfo(packageName, 0).versionName

            val intent3 = Intent(this@MainActivity, TerceraActivity::class.java)
            intent.putExtra("nombreApp", nombreApp)
            intent.putExtra("versionApp", versionApp)
            startActivity(intent3)
        }

        btnTirarDado.setOnClickListener {
            val dado = (1..20).random()
            Toast.makeText(this, "El número del dado es: $dado", Toast.LENGTH_LONG).show()
        }
    }
}
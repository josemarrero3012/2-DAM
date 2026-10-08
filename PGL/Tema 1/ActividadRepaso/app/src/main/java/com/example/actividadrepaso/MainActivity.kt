package com.example.actividadrepaso

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

        //inicializo los componentes que he añadido a MAINACTIVITY
        val tvTitulo = findViewById<TextView>(R.id.tvTitulo)
        val etNombre = findViewById<EditText>(R.id.etNombre)
        val etApellidos = findViewById<EditText>(R.id.etApellidos)
        val etDNI = findViewById<EditText>(R.id.etDNI)
        val btnConsultar = findViewById<Button>(R.id.btnConsultar)
        val btnSobreMi = findViewById<Button>(R.id.btnSobreMi)

        btnConsultar.setOnClickListener {

            if (etNombre.text.toString().isEmpty()) {
                Toast.makeText(this, "El campo nombre no puede estar vacío", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if (etApellidos.text.toString().isEmpty()) {
                Toast.makeText(this, "El campo apellidos no puede estar vacío", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if (etDNI.text.toString().isEmpty()) {
                Toast.makeText(this, "El campo DNI no puede estar vacío", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            val intent1 = Intent(this@MainActivity, SegundaActivity::class.java)

            intent1.putExtra("nombre", etNombre.text.toString())
            intent1.putExtra("apellido", etApellidos.text.toString())
            intent1.putExtra("dni", etDNI.text.toString())

            startActivity(intent1)
        }

        btnSobreMi.setOnClickListener {

            val intent2 = Intent(this@MainActivity, TerceraActivity::class.java)
            startActivity(intent2)
        }
    }
}
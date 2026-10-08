package com.example.apppizzeria

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
        val etNombre = findViewById<EditText>(R.id.etNombre)
        val etDireccion = findViewById<EditText>(R.id.etDireccion)
        val etnPizzas = findViewById<EditText>(R.id.etnPizzas)
        val etIngrediente = findViewById<EditText>(R.id.etIngrediente)
        val btnPedido = findViewById<Button>(R.id.btnPedido)
        val btnCarta = findViewById<Button>(R.id.btnCarta)

        btnPedido.setOnClickListener {
            if (etNombre.text.toString().isEmpty()) {
                Toast.makeText(this, "El campo nombre no puede estar vacío", Toast.LENGTH_LONG).show()
                return@setOnClickListener //detiene inmediatamente el código del botón para que la aplicación no siga procesando un formulario vacío
            }
            if (etDireccion.text.toString().isEmpty()) {
                Toast.makeText(this, "El campo de dirección no puede estar vacío", Toast.LENGTH_LONG).show()
                return@setOnClickListener //detiene inmediatamente el código del botón para que la aplicación no siga procesando un formulario vacío
            }

            // Convierte el número de pizzas escrito a un número real, o da un error limpio si el usuario no escribió nada.
            val numPizzas = etnPizzas.text.toString().toIntOrNull()
            if (numPizzas == null || numPizzas !in 1..9) {
                Toast.makeText(this, "Sólo puedes pedir entre 1 y 9 pizzas", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if (etIngrediente.text.toString().isEmpty()) {
                Toast.makeText(this, "El ingrediente estrella no puede estar vacío", Toast.LENGTH_LONG).show()
                return@setOnClickListener //detiene inmediatamente el código del botón para que la aplicación no siga procesando un formulario vacío
            }

            val intent1 = Intent(this@MainActivity, SegundaActivity::class.java) //conecta mainactivity con segundaactivity

            //guarda los datos que escribió el usuario para mandárselos a la segundaactivity.
            intent1.putExtra("Nombre", etNombre.text.toString())
            intent1.putExtra("Dirección", etDireccion.text.toString())
            intent1.putExtra("Nº pizzas", etnPizzas.text.toString())
            intent1.putExtra("Ingrediente estrella", etIngrediente.text.toString())

            startActivity(intent1) //abre segundaactivity
        }

        btnCarta.setOnClickListener {

            val nombreApp = getString(R.string.app_name)
            val versionApp = packageManager.getPackageInfo(packageName, 0).versionName

            val intent = Intent(this@MainActivity, TerceraActivity::class.java)
            intent.putExtra("nombreApp", nombreApp)
            intent.putExtra("versionApp", versionApp)
            startActivity(intent)
        }
    }
}
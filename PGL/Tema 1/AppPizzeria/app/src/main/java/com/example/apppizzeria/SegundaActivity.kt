package com.example.apppizzeria

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

        val tvNombreDireccion = findViewById<TextView>(R.id.tvNombreDireccion)
        val tvnPizzasIng = findViewById<TextView>(R.id.tvnPizzasIng)
        val btnNuevoPedido = findViewById<Button>(R.id.btnNuevoPedido)

        val datos = intent.extras //"bolsa" para recoger los datos que envié de mainactivity

        //creo variables independientes porque me interesa poder concatenarlos
        val nombre = datos?.getString("Nombre")
        val direccion = datos?.getString("Dirección")
        val numPizzas = datos?.getString("Nº pizzas")
        val ingrediente = datos?.getString("Ingrediente estrella")

        tvNombreDireccion.text = "Nombre: $nombre Dirección: $direccion"
        tvnPizzasIng.text = "Has pedido $numPizzas con el ingrediente estrella $ingrediente"

        btnNuevoPedido.setOnClickListener {
            val intent2 = Intent(this@SegundaActivity, MainActivity::class.java) //conecta mainactivity con segundaactivity
            startActivity(intent2)
        }
    }
}
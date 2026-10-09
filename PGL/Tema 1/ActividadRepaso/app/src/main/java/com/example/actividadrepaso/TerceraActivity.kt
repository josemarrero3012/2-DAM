package com.example.actividadrepaso

import android.os.Bundle
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

        //Ahora creo dos variables para recoger app y la version y se los asigno al et
        val app = getString(R.string.app_name)
        val info = packageManager.getPackageInfo(packageName, 0)

        tvApp.text = app
        tvVersion.text = info.versionName
    }
}
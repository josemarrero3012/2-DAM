package com.josemanuel.damflix

import android.app.Application
import com.josemanuel.damflix.data.PeliculaRepository

//Application vive durante el proceso de la aplicación. by lazy retrasa la creación hasta el primer
//acceso y conserva el resultado para los accesos siguientes. Este repositorio recibe el helper
class DAMFlixApplication : Application() {
    // Se crean la primera vez que alguien los necesita.
    val dbHelper by lazy { DAMFlixDbHelper(this) }
    val repository by lazy { PeliculaRepository(dbHelper) }
}

//añadir en AndroidManifest.xml: android:name=".DAMFlixApplication"
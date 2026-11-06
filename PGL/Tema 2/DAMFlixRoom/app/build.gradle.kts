plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.compose)
    //plugin KSP imprescindible para procesar las anotaciones de Room
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.josemanuel.damflix"
    compileSdk {
        version = release(37)
    }

    defaultConfig {
        applicationId = "com.josemanuel.damflix"
        minSdk = 24
        targetSdk = 37
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            optimization {
                enable = true
                packageScope = setOf("androidx.**", "kotlin.**", "kotlinx.**")
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
    debugImplementation(libs.androidx.compose.ui.tooling)
    //añadir para el icono de corazón de la app
    implementation("androidx.compose.material:material-icons-extended")
    //navegación oficial de Jetpack Compose para la fase 4
    implementation("androidx.navigation:navigation-compose:2.10.2")
    // para trabajar con la api nativa de sqlite no hace falta librerías de tercero, únicamente las dependencias oficiales de ViewModel e integración del ciclo de vida con Jetpack Compose
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.11.0")
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.11.0")
    //fase 6: componentes del ORM Room
    val roomVersion = "2.8.5"
    implementation("androidx.room:room-runtime:${roomVersion}")
    implementation("androidx.room:room-ktx:${roomVersion}")
    ksp("androidx.room:room-compiler:$roomVersion")
}
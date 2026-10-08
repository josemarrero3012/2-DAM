data class Alumno (
    val id: Long,
    val nombre: String,
    var nota: Int?,
    val email: String = "sin_email@centro.es"
)
{
    fun esAprobado() = (nota?:0) >= 5

    fun obtenerCalificacionTexto():String {
        nota?:return "Sin calificar"
        return when (nota) {
            in 0..4 -> "Suspenso"
            in 5..6 -> "Aprobado"
            in 7..8 -> "Notable"
            in 9..10 -> "Sobresaliente"
            else -> "Nota no válida"
        }
    }

    fun esExcelente() = (nota?:0)>=9
}



fun main() {

    val listaAlumnos: List<Alumno> = listOf(Alumno(id = 1, nombre = "Laura", nota = 8), Alumno(id = 2, nombre = "José", nota = 10), Alumno(id = 3, nombre = "Eva", nota = 1), Alumno(id = 4, nombre = "Jacinto", nota = 2), Alumno(id = 5, nombre = "Ale", nota = 9))

    listaAlumnos.forEach { alumno -> println("ID:${alumno.id}, Nombre:${alumno.nombre}, Nota:${alumno.nota}") }

    val aprobadosAlumnos = listaAlumnos.filter { it.esAprobado() }
    val suspensosAlumnos = listaAlumnos.filter { !it.esAprobado() }

    println(aprobadosAlumnos)
    println(suspensosAlumnos)

    val excelenteAlumnos = listaAlumnos.filter { it.esExcelente() }
    println(excelenteAlumnos)

    val notaMediaAprobados = aprobadosAlumnos.mapNotNull { it.nota }.average() //mapnotnutll hace que no tenga en cuenta los nulos
    println(notaMediaAprobados)

    val noteMediaSuspensos = suspensosAlumnos.mapNotNull { it.nota }.average()
    println(noteMediaSuspensos)

    val notamediaGlobal = listaAlumnos.mapNotNull { it.nota }.average()
    println(notamediaGlobal)
}

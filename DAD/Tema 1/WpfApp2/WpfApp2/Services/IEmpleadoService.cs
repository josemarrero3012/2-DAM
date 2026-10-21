using System;
using System.Collections.Generic;
using System.Text;
using WpfApp2.Models; // Necesario para que reconozca la clase Empleado (está en otra carpeta/namespace)

namespace WpfApp2.Services
{
    // PASO 1.2 (Interfaz): define el "contrato" del servicio.
    // - Una interfaz SOLO declara la firma de los métodos: sin public, sin llaves { } y termina en ;
    // - El ViewModel dependerá de esta interfaz y NO de la clase concreta. Así mañana se puede
    //   cambiar el mockup por una base de datos sin tocar el ViewModel (esto es la inyección de dependencias).
    // - Por convención el nombre de una interfaz empieza por la letra I.
    public interface IEmpleadoService
    {
        // Devuelve la lista de empleados de prueba (mockup = datos simulados)
        List<Empleado> ObtenerEmpleadosMockup();
    }
}

using System;
using System.Collections.Generic;
using System.Text;
using WpfApp2.Models;

namespace WpfApp2.Services
{
    // PASO 1.3 (Servicio Mockup): implementa el contrato de IEmpleadoService.
    // Truco en Visual Studio: escribe ": IEmpleadoService", pulsa Ctrl + . y elige
    // "Implementar interfaz": crea el método vacío automáticamente.
    // "Mockup" = datos inventados para probar, sin base de datos real.
    public class EmpleadoService : IEmpleadoService
    {
        public List<Empleado> ObtenerEmpleadosMockup()
        {
            // El enunciado pide AL MENOS 4 registros de prueba
            return new List<Empleado>
            {
                // La "m" al final del salario indica que es decimal; sin ella C# lo trata como double y da error.
                // Se usa un inicializador de objeto: new Empleado { Propiedad = valor, ... }
                new Empleado { Id = 1, Nombre = "Juan Pérez", Departamento = "Ventas", Salario = 3000.00m, JornadaCompleta = true },
                new Empleado { Id = 2, Nombre = "María López", Departamento = "Marketing", Salario = 3500.00m, JornadaCompleta = false },
                new Empleado { Id = 3, Nombre = "Carlos García", Departamento = "IT", Salario = 4000.00m, JornadaCompleta = true },
                new Empleado { Id = 4, Nombre = "Ana Ruiz", Departamento = "RRHH", Salario = 2800.00m, JornadaCompleta = true }
            };
        }
    }
}

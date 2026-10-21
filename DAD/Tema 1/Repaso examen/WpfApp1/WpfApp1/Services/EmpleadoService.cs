using System;
using System.Collections.Generic;
using System.Text;
using WpfApp1.models;

namespace WpfApp1.services
{
    internal class EmpleadoService : IEmpleadoService
    {
        // Implementación del método ObtenerEmpleadosMockup que devuelve una lista de empleados de ejemplo
        public List<Empleado> ObtenerEmpleadosMockup()
        {
            // Aquí se crea una lista de empleados de ejemplo con datos ficticios
            return new List<Empleado>()
            {
                new Empleado{Id = 1, Nombre = "Miguel", Departamento = "Lengua", Salario=2000.00m, JornadaCompleta=true},
                new Empleado{Id = 2, Nombre = "Juan", Departamento = "Matemáticas", Salario=1500.00m, JornadaCompleta=false},
                new Empleado{Id = 3, Nombre = "Luis", Departamento = "Física", Salario=1200.00m, JornadaCompleta=true},
                new Empleado{Id = 4, Nombre = "Jose", Departamento = "Historia", Salario=1500.00m, JornadaCompleta=false},
                new Empleado{Id = 5, Nombre = "Carlos", Departamento = "Matemáticas", Salario=1600.00m, JornadaCompleta=false}
            };
        }
    }         
}

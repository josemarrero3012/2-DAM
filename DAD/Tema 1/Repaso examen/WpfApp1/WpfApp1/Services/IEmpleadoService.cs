using System;
using System.Collections.Generic;
using System.Text;
using WpfApp1.models;

namespace WpfApp1.services
{
    internal interface IEmpleadoService
    {
        // Definición del método ObtenerEmpleadosMockup que devuelve una lista de empleados de ejemplo
        public List<Empleado> ObtenerEmpleadosMockup();
    }
}

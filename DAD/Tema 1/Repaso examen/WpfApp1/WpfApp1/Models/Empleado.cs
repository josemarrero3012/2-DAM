using System;
using System.Collections.Generic;
using System.Text;

namespace WpfApp1.models
{
    internal class Empleado
    {
        //Definición de propiedades de la clase Empleado
        public int Id{  get; set; }
        public string Nombre { get; set; } = string.Empty;
        public string Departamento { get; set; } = string.Empty;
        public decimal Salario {  get; set; }
        public bool JornadaCompleta { get; set; }

    }
}

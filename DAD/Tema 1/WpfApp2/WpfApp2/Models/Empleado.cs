using System;
using System.Collections.Generic;
using System.Text;

namespace WpfApp2.Models
{
    // PASO 1.1 (Modelo): clase "tonta" que solo guarda datos, sin lógica.
    // Cada objeto Empleado representa UNA FILA del ListView.
    // Tiene que ser public para que la usen el servicio, el ViewModel y la vista.
    public class Empleado
    {
        // { get; set; } = propiedad automática: se puede leer y escribir
        public int Id { get; set; }

        // = string.Empty -> empieza con texto vacío "" y no con null.
        // Evita el aviso de "nullable" y los errores por usar un texto nulo.
        public string Nombre { get; set; } = string.Empty;
        public string Departamento { get; set; } = string.Empty;

        // decimal es el tipo correcto para dinero (double puede dar errores de redondeo)
        public decimal Salario { get; set; }

        // bool = verdadero/falso; en la interfaz se enlaza con el CheckBox
        public bool JornadaCompleta { get; set; }
    }
}

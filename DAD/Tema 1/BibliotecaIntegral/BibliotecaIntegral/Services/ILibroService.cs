using System;
using System.Collections.Generic;
using System.Text;
using BibliotecaIntegral.Models; //necesario para que reconozca la clase Libro porque está en otra carpeta

namespace BibliotecaIntegral.Services
{
    public interface ILibroService //visual la puso internal y la cambio a public para que el viewmodel pueda usarla
    {
        List<Libro> ObtenerLibrosMockup();
    }
}

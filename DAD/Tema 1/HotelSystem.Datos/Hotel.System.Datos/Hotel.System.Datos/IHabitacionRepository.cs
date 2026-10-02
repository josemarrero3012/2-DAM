using System;
using System.Collections.Generic;
using System.Text;

namespace HotelSystem.Datos
{
    public interface IHabitacionRepository
    {
        decimal ObtenerPrecioNoche(string tipoHabitacion);
    }
}

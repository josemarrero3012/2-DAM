using System;
using System.Collections.Generic;
using System.Text;

namespace HotelSystem.Datos
{
    public class HabitacionRepository : IHabitacionRepository
    {
        public decimal ObtenerPrecioNoche(string tipoHabitacion)
        {
            string tipo = tipoHabitacion.ToLower();

            if (tipo == "suite")
            {
                return 150.0m;
            }
            else if (tipo == "doble")
            {
                return 80.0m;
            }
            else
            {
                return 50.0m;
            }
        }
    }
}

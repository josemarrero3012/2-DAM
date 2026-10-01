using System;
using System.Collections.Generic;
using System.Text;

namespace HotelSystem.Negocio
{
    public interface IReservaManager
    {
        decimal CalcularTotalReserva(string tipo, int noches);
    }
}

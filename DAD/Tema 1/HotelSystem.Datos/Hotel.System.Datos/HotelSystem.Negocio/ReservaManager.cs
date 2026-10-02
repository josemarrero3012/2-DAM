using System;
using System.Collections.Generic;
using System.Text;
using HotelSystem.Datos;

namespace HotelSystem.Negocio
{
    public class ReservaManager : IReservaManager
    {
        private readonly IHabitacionRepository _repository;

        public ReservaManager(IHabitacionRepository repository)
        {
            _repository = repository;
        }

        public decimal CalcularTotalReserva(string tipo, int noches)
        {
            decimal precio = _repository.ObtenerPrecioNoche(tipo);

            decimal subtotal = precio * noches;

            if (noches > 5)
            {
                subtotal *= 0.90m;
            }

            return subtotal;
        }
    }
}

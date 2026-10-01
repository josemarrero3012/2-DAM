using System;
using System.Collections.Generic;
using System.Text;

namespace ConsoleApp1
{
    public interface IVehiculo
    {
        string Marca { get; }
        string Modelo { get; }
        bool EstaEncendido { get; }

       
        //una interfaz solo define el contrato.
        void Encender();
        void Acelerar();
    }
}

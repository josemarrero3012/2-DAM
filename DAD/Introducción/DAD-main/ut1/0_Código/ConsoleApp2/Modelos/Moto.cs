using ConsoleApp1.Abstracciones;
using System;
using System.Collections.Generic;
using System.Reflection;
using System.Text;

namespace ConsoleApp1.Modelos
{
    public class Moto : VehiculoBase
    {
        public Moto(string marca, string modelo) : base(marca, modelo) { }

        // Polimorfismo: Implementación específica de acelerar para una Moto
        public override void Acelerar()
        {
            if (EstaEncendido)
            {
                Console.WriteLine("La moto " + Marca + " " + Modelo + " ruge al acelerar: ¡Wrum wrummm! (Acelerador de puño)");
            }
            else
            {
                Console.WriteLine("¡No puedes acelerar la moto " + Marca + "! El motor está apagado.");
            }
        }
    }
}

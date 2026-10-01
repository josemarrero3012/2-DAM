using ConsoleApp1.Abstracciones;
using System;
using System.Collections.Generic;
using System.Reflection;
using System.Text;

namespace ConsoleApp1.Modelos
{
    public class Coche : VehiculoBase
    {
        // Pasa los parámetros al constructor de la clase base (VehiculoBase)
        public Coche(string marca, string modelo) : base(marca, modelo) { }

        // Polimorfismo: Implementación específica de acelerar para un Auto
        public override void Acelerar()
        {
            if (EstaEncendido)
            {
                Console.WriteLine("El auto " + Marca + " " + Modelo + " acelera suavemente: ¡Rummmm! (Tracción en las 4 ruedas)");
            }
            else
            {
                Console.WriteLine("¡No puedes acelerar el auto " + Marca + "! El motor está apagado.");
            }
        }
    }
    }

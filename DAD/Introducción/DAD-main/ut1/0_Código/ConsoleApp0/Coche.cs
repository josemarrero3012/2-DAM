using System;

namespace ConsoleApp1
{
    // Implementación directa de la interfaz sin pasar por VehiculoBase
    public class Coche : IVehiculo
    {
        // Propiedades requeridas por IVehiculo
        public string Marca { get; }
        public string Modelo { get; }
        public bool EstaEncendido { get; private set; }

        // Constructor propio
        public Coche(string marca, string modelo)
        {
            Marca = marca;
            Modelo = modelo;
            EstaEncendido = false;
        }


        public void Encender()
        {
            EstaEncendido = true;
            Console.WriteLine("[SISTEMA]: El " + Marca + " " + Modelo + " ha encendido el motor.");
        }

     
        public void Acelerar()
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

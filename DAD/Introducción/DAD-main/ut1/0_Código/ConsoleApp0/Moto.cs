using System;


namespace ConsoleApp1
{
    // Implementación directa de la interfaz sin pasar por VehiculoBase
    public class Moto : IVehiculo
    {
        // Propiedades requeridas por IVehiculo
        public string Marca { get; }
        public string Modelo { get; }
        public bool EstaEncendido { get; private set; }

        // Constructor propio
        public Moto(string marca, string modelo)
        {
            Marca = marca;
            Modelo = modelo;
            EstaEncendido = false;
        }


        public void Encender()
        {
            EstaEncendido = true;
            Console.WriteLine("[SISTEMA]: La moto " + Marca + " " + Modelo + " ha encendido el motor.");
        }

      
        public void Acelerar()
        {
            if (EstaEncendido)
            {
                Console.WriteLine("La moto " + Marca + " " + Modelo + " acelera: ¡Brummm brummm! (Acelerador en el puño)");
            }
            else
            {
                Console.WriteLine("¡No puedes acelerar la moto " + Marca + "! El motor está apagado.");
            }
        }
    }
}
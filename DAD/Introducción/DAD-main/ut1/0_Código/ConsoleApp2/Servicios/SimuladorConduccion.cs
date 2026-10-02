using ConsoleApp1.Abstracciones;
using System;

namespace ConsoleApp1.Servicios
{
    public class SimuladorConduccion
    {
        // Recibe la interfaz, permitiendo recibir CUALQUIER vehículo existente o futuro
        public void IniciarPrueba(IVehiculo vehiculo)
        {
            Console.WriteLine("\n--- Iniciando prueba con: " + vehiculo.Marca + " " + vehiculo.Modelo + " ---");

            vehiculo.Encender();
            vehiculo.Acelerar();

            Console.WriteLine("--- Prueba finalizada con éxito ---");
        }
    }
}
using System;
using System.Collections.Generic;
using System.Text;

namespace ConsoleApp1.Abstracciones
{
    // Clase abstracta: No se puede crear con "new", sirve solo como plantilla base
    public abstract class VehiculoBase : IVehiculo
    {
        // Campos compartidos por todos los vehículos hijos
        public string Marca { get; }
        public string Modelo { get; }

        // Encapsulamiento: El estado solo puede cambiarse desde dentro de las clases hijas
        public bool EstaEncendido { get; protected set; }

        // Constructor de la clase base
        protected VehiculoBase(string marca, string modelo)
        {
            Marca = marca;
            Modelo = modelo;
            EstaEncendido = false; // Por defecto arrancan apagados
        }

        // Método común ya implementado para todos
        public void Encender()
        {
            if (!EstaEncendido)
            {
                EstaEncendido = true;
                Console.WriteLine("[SISTEMA]: El " + Marca + " " + Modelo + " ha encendido el motor.");
            }
        }

        // Método abstracto: Obliga a cada hijo a definir cómo acelera (Polimorfismo)
        public abstract void Acelerar();
    }
}

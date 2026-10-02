using System;
using ConsoleApp1.Abstracciones;

namespace ConsoleApp1.Abstracciones
{
    // Clase abstracta: No se puede instanciar con "new", sirve como plantilla base
    public abstract class GraficoBase : IGrafico
    {
        // Propiedades compartidas por todos los gráficos hijos
        public string Titulo { get; }
        public string Tipo { get; }

        // Encapsulamiento: El estado solo se puede modificar internamente o desde las clases hijas
        public bool TieneDatos { get; protected set; }

        // Constructor de la clase base
        protected GraficoBase(string titulo, string tipo)
        {
            Titulo = titulo;
            Tipo = tipo;
            TieneDatos = false; 
        }

        // Método común ya implementado para todos los gráficos
        public void CargarDatos()
        {
            if (!TieneDatos)
            {
                TieneDatos = true;
                Console.WriteLine("[SISTEMA]: Datos cargados para el gráfico " + Titulo + ".");
            }
        }

        // Método abstracto: Obliga a cada clase hija a definir CÓMO se dibuja (Polimorfismo)
        public abstract void Dibujar();
    }
}
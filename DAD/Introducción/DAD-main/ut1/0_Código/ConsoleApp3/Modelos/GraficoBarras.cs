using System;
using ConsoleApp1.Abstracciones;

namespace ConsoleApp1.Modelos
{
    // Hereda de GraficoBase para reutilizar la lógica común
    public class GraficoBarras : GraficoBase
    {
        // Pasa el título y el tipo "Barras" al constructor de GraficoBase
        public GraficoBarras(string titulo) : base(titulo, "Barras") { }

        // Polimorfismo: Implementación específica del dibujado de barras
        public override void Dibujar()
        {
            if (TieneDatos)
            {
                Console.WriteLine("Renderizando gráfico de barras " + Titulo + ": [  ]");
            }
            else
            {
                Console.WriteLine("¡No se puede dibujar el gráfico " + Titulo + "! No hay datos cargados.");
            }
        }
    }
}
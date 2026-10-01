using System;
using ConsoleApp1.Abstracciones;

namespace ConsoleApp1.Modelos
{
    // Hereda de GraficoBase en lugar de implementar IGrafico directamente
    public class GraficoPastel : GraficoBase
    {
        // El constructor envía el título y el tipo "Pastel" a la clase base (GraficoBase)
        public GraficoPastel(string titulo) : base(titulo, "Pastel") { }

        // Polimorfismo: Implementación específica de cómo se dibuja un gráfico de pastel
        public override void Dibujar()
        {
            if (TieneDatos)
            {
                Console.WriteLine("Renderizando gráfico de pastel " + Titulo + ": [ 25% | 50% | 25% ]");
            }
            else
            {
                Console.WriteLine("¡No se puede dibujar el gráfico " + Titulo + "! No hay datos cargados.");
            }
        }
    }
}
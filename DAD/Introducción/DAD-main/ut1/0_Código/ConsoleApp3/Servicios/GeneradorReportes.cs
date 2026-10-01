using System;
using ConsoleApp1.Abstracciones;

namespace ConsoleApp1.Servicios
{
    public class GeneradorReportes
    {
        // Recibe la interfaz, permitiendo procesar CUALQUIER tipo de gráfico actual o futuro
        public void ExportarGrafico(IGrafico grafico)
        {
            Console.WriteLine("\n--- Generando reporte para gráfico de tipo: " + grafico.Tipo + " ---");

            grafico.CargarDatos();
            grafico.Dibujar();

            Console.WriteLine("--- Reporte exportado con éxito ---");
        }
    }
}
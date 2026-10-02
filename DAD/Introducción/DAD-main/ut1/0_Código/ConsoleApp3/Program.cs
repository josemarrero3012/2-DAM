using ConsoleApp1.Modelos;
using ConsoleApp1.Servicios;

Console.WriteLine("========================================");
Console.WriteLine("    CLASE MAESTRA: PRINCIPIOS DE POO    ");
Console.WriteLine("========================================\n");

// INSTANCIACIÓN
GraficoBarras miBarras = new GraficoBarras("Ventas Mensuales");
GraficoPastel miPastel = new GraficoPastel("Distribución de Usuarios");

// ENCAPSULAMIENTO
// Intentamos dibujar sin cargar datos primero
miBarras.Dibujar();

miPastel.CargarDatos();
miPastel.Dibujar();

// POLIMORFISMO 
GeneradorReportes generador = new GeneradorReportes();

// Enviamos el gráfico de barras al generador
generador.ExportarGrafico(miBarras);

// Enviamos el gráfico de pastel al mismo generador (Polimorfismo mediante IGrafico)
generador.ExportarGrafico(miPastel);

Console.WriteLine("\nPresiona cualquier tecla para cerrar la simulación...");
Console.ReadKey();
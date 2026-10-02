using Aplicación1.Interfaces;
using Aplicación1.Servicios;

Console.WriteLine("==============================================");
Console.WriteLine("   SIMULADOR DE EXPORTACIÓN DE REPORTES");
Console.WriteLine("==============================================");

// INSTANCIACIÓN DE LAS CLASES DE EXPORTADOR DE PDF Y EXCEL
ExportadorPdf pdf = new ExportadorPdf("ReporteAnual.pdf");
ExportadorExcel excel = new ExportadorExcel("ListadoEmpleados.xlsx");

// POLIMORFISMO: el gestor procesa diferentes formatos con el mismo método
GestorReportes gestor = new GestorReportes();

// Enviamos PDF al gestor, es decir, el nombre del objeto
gestor.ProcesarExportacion(pdf, "Datos de ingresos 2026");

// Enviamos Excel al mismo gestor
gestor.ProcesarExportacion(excel, "Listado de empleados activos");

Console.WriteLine("Presiona cualquier tecla para cerrar la simulación...");
Console.ReadKey();
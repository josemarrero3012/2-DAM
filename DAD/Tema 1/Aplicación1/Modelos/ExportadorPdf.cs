using System;
using System.Collections.Generic;
using System.Text;
using Aplicación1.Abstracciones;

namespace Aplicación1.Interfaces
{
    public class ExportadorPdf : IExportador
    {
        public string Datos { get; }
        public string TipoDocumento => "PDF";

        
        //Constructor
        public ExportadorPdf(string datos)
        {
            Datos = datos;
        }
        
        
        //Métodos
        public void ConfigurarPagina()
        {
            Console.WriteLine("Configurando página a PDF...");
        }
        public void GenerarContenido(string Datos)
        {
            Console.WriteLine("Generando contenido para PDF: "+Datos+"...");
        }
        public void GuardarArchivo()
        {
            Console.WriteLine("Guardando archivo PDF...");
        }
    }
}

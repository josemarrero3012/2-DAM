using Aplicación1.Abstracciones;

namespace Aplicación1.Interfaces
{
    public class ExportadorExcel : IExportador
    {
        public string Datos { get; }
        // Le pongo una restricción a la propiedad para que devuelva ese tipo de dato al crear el objeto exportador excel
        public string TipoDocumento => "Excel";
        
        //Constructor
        public ExportadorExcel(string datos)
        {
            Datos = datos;
        }
        
        
        //Métodos
        public void ConfigurarPagina()
        {
            Console.WriteLine("Configurando página de Excel...");
        }
        public void GenerarContenido(string Datos)
        {
            Console.WriteLine("Generando contenido para Excel: "+Datos+"...");
        }
        public void GuardarArchivo()
        {
            Console.WriteLine("Guardando archivo Excel...");
        }
    }
}
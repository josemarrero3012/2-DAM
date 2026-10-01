using System;
using System.Collections.Generic;
using System.Text;

namespace Aplicación1.Abstracciones
{
    public interface IExportador
    {
        // Áñado datos para poder recibir la info que se quiere exportar  
        string Datos {  get; }
        // Añado la propiedad TIPO DE DOCUMENTO para obtenerlo
        string TipoDocumento { get; }

        //Métodos a implementar 
        void ConfigurarPagina();
        void GenerarContenido(string Datos);
        void GuardarArchivo();
    }
}

using System;
using System.Collections.Generic;
using System.Text;
using Aplicación1.Abstracciones;

namespace Aplicación1.Servicios
{
    public class GestorReportes
    {
        // IExportador permite recibir cualquier objeto que cumpla el contrato de la interfaz
        // (por ejemplo, ExportadorPdf o ExportadorExcel), aplicando polimorfismo.
        // string datos NO es el objeto del que habla el enunciado: simplemente contiene
        // la información que se enviará al método GenerarContenido()
        public void ProcesarExportacion(IExportador exportador, string datos)
        {
            exportador.ConfigurarPagina();
            exportador.GenerarContenido(datos);
            exportador.GuardarArchivo();
        }
    }
}

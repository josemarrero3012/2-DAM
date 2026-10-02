using DemoTienda.Datos;
using DemoTienda.Negocio;
using DemoTienda.Presentacion;

namespace DemoTienda.Consola
{
    internal class Program
    {
        static void Main(string[] args)
        {
            // Instanciación manual (de abajo hacia arriba)
            IDataRepository repo = new DataRepository();
            IBusinessManager negocio = new BusinessManager(repo);
            IPresentationManager presentacion = new PresentationManager(negocio);

            // Ejecución de la aplicación
            presentacion.MostrarFactura();
        }
    }
}
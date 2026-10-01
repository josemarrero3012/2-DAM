using DemoTienda.Negocio;

namespace DemoTienda.Presentacion;

public class PresentationManager : IPresentationManager
{
    private readonly IBusinessManager _businessManager;

    public PresentationManager(IBusinessManager manager)
    {
        _businessManager = manager;
    }

    public void MostrarFactura()
    {
        decimal total = _businessManager.calcularPrecioFinal();
        Console.WriteLine("El precio final con IVA es: " + total);
    }
}
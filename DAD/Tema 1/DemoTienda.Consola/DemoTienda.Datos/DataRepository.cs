namespace DemoTienda.Datos;

public class DataRepository : IDataRepository
{
    public decimal ObtenerPrecioBase()
    {
        return 200.0m;
    }
}
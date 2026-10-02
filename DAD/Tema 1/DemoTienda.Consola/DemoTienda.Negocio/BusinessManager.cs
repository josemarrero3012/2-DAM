using DemoTienda.Datos;
namespace DemoTienda.Negocio;

public class BusinessManager : IBusinessManager
{
    private readonly IDataRepository _dataRepository;
    
    public BusinessManager(IDataRepository repo)
    {
        _dataRepository = repo;
    }

    public decimal calcularPrecioFinal()
    {
        decimal basePrice = _dataRepository.ObtenerPrecioBase();
        return basePrice * 1.21m; //IVA 21%
    }
}
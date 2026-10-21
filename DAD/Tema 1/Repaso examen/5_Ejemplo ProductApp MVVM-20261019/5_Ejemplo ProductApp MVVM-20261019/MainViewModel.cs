using System.Collections.ObjectModel;
using CommunityToolkit.Mvvm.ComponentModel;
using CommunityToolkit.Mvvm.Input;
using WpfApp1.Models;
using WpfApp1.Services;

namespace WpfApp1.ViewModels
{
    public partial class MainViewModel : ObservableObject
    {
        private readonly IProductoService _productoService;

        // Lista observable para refrescar el ListView automáticamente
        [ObservableProperty]
        private ObservableCollection<Producto> _productos = new();

        // Categorías disponibles para el ComboBox
        [ObservableProperty]
        private List<string> _categorias = new() { "Periféricos", "Pantallas", "Audio", "Otros" };

        // Campos del formulario para añadir un nuevo producto
        [ObservableProperty]
        [NotifyCanExecuteChangedFor(nameof(AgregarProductoCommand))]
        private string _nuevoNombre = string.Empty;

        [ObservableProperty]
        private string _nuevaCategoria = "Periféricos";

        [ObservableProperty]
        private decimal _nuevoPrecio = 10.00m;

        [ObservableProperty]
        private bool _nuevoDisponible = true;

        // Producto seleccionado en la lista
        [ObservableProperty]
        private Producto? _productoSeleccionado;

        // Inyección de dependencias por constructor
        public MainViewModel(IProductoService productoService)
        {
            _productoService = productoService;
            CargarDatos();
        }

        private void CargarDatos()
        {
            var datos = _productoService.ObtenerProductosMockup();
            Productos = new ObservableCollection<Producto>(datos);
        }

        // Validación: Solo permite agregar si el nombre no está vacío
        private bool CanAgregar => !string.IsNullOrWhiteSpace(NuevoNombre);

        [RelayCommand(CanExecute = nameof(CanAgregar))]
        private void AgregarProducto()
        {
            var nuevo = new Producto
            {
                Id = Productos.Count + 1,
                Nombre = NuevoNombre,
                Categoria = NuevaCategoria,
                Precio = NuevoPrecio,
                Disponible = NuevoDisponible
            };

            Productos.Add(nuevo);

            // Limpiamos el formulario
            NuevoNombre = string.Empty;
        }
    }
}
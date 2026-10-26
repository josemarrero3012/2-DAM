using CommunityToolkit.Mvvm.ComponentModel;
using CommunityToolkit.Mvvm.Input; 
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using BibliotecaIntegral.Models;
using BibliotecaIntegral.Services;

namespace BibliotecaIntegral.ViewModels
{
    //tiene que ser partial
    public partial class MainViewModel : ObservableObject
    {
        private readonly ILibroService _libroService;

        //con ObservableCollection aviso a la vista cuando se añade o borra un libro
        [ObservableProperty]
        private ObservableCollection<Libro> _libros = new();

        //libro seleccionado en la lista puede ser null por eso el ?
        [ObservableProperty]
        private Libro? _libroSeleccionado;

        //campos del formulario que hay que rellenar para añadir un libro nuevo, en este caso yo no dejo valores por defecto
        [ObservableProperty]
        [NotifyCanExecuteChangedFor(nameof(AgregarLibroCommand))]
        private string _nuevoTitulo = string.Empty;

        [ObservableProperty]
        private string _nuevoGenero = "";

        [ObservableProperty]
        private decimal _nuevoPrecio; 

        [ObservableProperty]
        private bool _nuevoDisponible;

        //opciones del combobox de género
        [ObservableProperty]
        private List<string> _generos = new() { "Aventura", "Tragedia", "Historia", "Social" };

        public MainViewModel(ILibroService libroService)
        {
            _libroService = libroService;
            CargarDatos();
        }

        //pide la lista al servicio y la convierte en ObservableCollection
        private void CargarDatos()
        {
            var datos = _libroService.ObtenerLibrosMockup();
            Libros = new ObservableCollection<Libro>(datos);
        }

        //si devuelve false el botón se pone gris solo, IsNullOrWhiteSpace tmabien controla los textos que solo tienen espacios
        private bool PuedeAgregar => !string.IsNullOrWhiteSpace(NuevoTitulo);
        //relaycommand genera AgregarLibroCommand que es el nombre del metodo + command
        [RelayCommand(CanExecute = nameof(PuedeAgregar))]
        private void AgregarLibro()
        {
            var nuevo = new Libro
            {
                Id = Libros.Count + 1,
                Titulo = NuevoTitulo,
                Genero = NuevoGenero,
                PrecioAlquiler = NuevoPrecio,
                Disponibilidad = NuevoDisponible
            };

            Libros.Add(nuevo);
            //al vaciar el título el etxtbox se limpia y el botón se vuelve a desactivar
            NuevoTitulo = string.Empty;
        }
    }
}

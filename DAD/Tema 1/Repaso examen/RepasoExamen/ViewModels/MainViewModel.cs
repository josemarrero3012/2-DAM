using CommunityToolkit.Mvvm.ComponentModel;
using CommunityToolkit.Mvvm.Input;
using RepasoExamen.Model;
using RepasoExamen.Services;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Text;

namespace RepasoExamen.ViewModels
{
    public partial class MainViewModel : ObservableObject
    {
        private readonly ILibroService _libroService;

        [ObservableProperty]
        private ObservableCollection<Libro> _librosDisponibles = new();

        [ObservableProperty]
        private ObservableCollection<Libro> _libros = new();

        [ObservableProperty]
        [NotifyCanExecuteChangedFor(nameof(AgregarLibroCommand))]
        private string _nuevoTitulo = string.Empty;

        [ObservableProperty]
        private string _nuevoAutor = string.Empty;

        [ObservableProperty]
        private int _nuevoAnioPublicacion;

        [ObservableProperty]
        private string _nuevoGenero = "Ficción";

        [ObservableProperty]
        private bool _nuevoDisponible = true;

        [ObservableProperty]
        private List<string> _generos = new List<string> { "Ficción", "Ciencia ficción", "Infantil", "Romance", "Misterio" };

        [ObservableProperty]
        private Libro? _libroSeleccionado;


        public MainViewModel(ILibroService libroService)
        {
            _libroService = libroService;
            CargarLibros();
        }

        private void CargarLibros()
        {
            var datos = _libroService.ObtenerLibrosMockUp();
            Libros = new ObservableCollection<Libro>(datos);
        }

        private bool CanAgregar => !string.IsNullOrWhiteSpace(NuevoTitulo);
        [RelayCommand(CanExecute = nameof(CanAgregar))]
        private void AgregarLibro()
        {
            var nuevoLibro = new Libro
            {
                Id = Libros.Count + 1, // Asignar un ID único basado en la cantidad de libros existentes
                Titulo = _nuevoTitulo,
                Autor = _nuevoAutor,
                AnioPublicacion = _nuevoAnioPublicacion,
                Genero = _nuevoGenero,
                Disponible = _nuevoDisponible
            };

            _libroService.AgregarLibro(nuevoLibro);
            Libros.Add(nuevoLibro);

            // Limpiar los campos después de agregar el libro
            NuevoTitulo = string.Empty;
            NuevoAutor = string.Empty;
            NuevoAnioPublicacion = 0;
            NuevoGenero = "Ficción";
            NuevoDisponible = true;
        }

        [RelayCommand]
        private void ObtenerLibrosDisponibles()
        {
            var librosDisponinles = _libroService.ObtenerLibrosDisponibles();
            LibrosDisponibles = new ObservableCollection<Libro>(librosDisponinles);
        }
    }
}

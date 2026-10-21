using CommunityToolkit.Mvvm.ComponentModel;
using CommunityToolkit.Mvvm.Input;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using WpfApp1.models;
using WpfApp1.services;

namespace WpfApp1.ViewModels
{
    internal partial class MainViewModel : ObservableObject
    {
        // Inyección de dependencia del servicio de empleados
        private readonly IEmpleadoService _empleadoService;

        // Campo para el TextBox de nombre
        [ObservableProperty]
        [NotifyCanExecuteChangedFor(nameof(AgregarEmpleadoCommand))]
        private string _NuevoNombre = string.Empty;

        // Campo para el ComboBox de departamento
        [ObservableProperty]
        private string _NuevoDepartamento = string.Empty;

        // Campo para el TextBox de salario
        [ObservableProperty]
        private decimal _NuevoSalario;

        // Campo para el CheckBox de jornada completa
        [ObservableProperty]
        private bool _JornadaCompleta = true;

        // Lista observable para refrescar el ListView automáticamente
        [ObservableProperty]
        private ObservableCollection<Empleado> _empleados = new();

        // Lista de departamentos disponibles para el ComboBox
        [ObservableProperty]
        private List<string> _departamentos = new() { "Lengua", "Ingles", "Matemáticas", "Historia", "Física" };

        // Empleado seleccionado en la lista
        [ObservableProperty]
        private Empleado? _empleadoSeleccionado;

        // Inyección de dependencias por constructor
        public MainViewModel(IEmpleadoService empleadoService)
        {
            _empleadoService = empleadoService;
            CargarDatos();
        }

        // Método para cargar los datos iniciales de empleados
        private void CargarDatos()
        {
            // Obtener los datos de empleados desde el servicio
            var datos = _empleadoService.ObtenerEmpleadosMockup();
            // Asignar los datos a la colección observable
            Empleados = new ObservableCollection<Empleado>(datos);
        }

        // Validación: Solo permite agregar si el nombre no está vacío
        private bool _CanAgregar => !string.IsNullOrWhiteSpace(_NuevoNombre);
        [RelayCommand(CanExecute = nameof(_CanAgregar))]

        // Método que se ejecuta al invocar el comando AgregarEmpleado
        private void AgregarEmpleado()
        {
            // Crear un nuevo empleado con los datos ingresados
            var nuevo = new Empleado
            {
                Id = Empleados.Count + 1,
                Nombre = _NuevoNombre,
                Departamento = _NuevoDepartamento,
                Salario = 2300m,
                JornadaCompleta = _JornadaCompleta,
            };
            // Agregar el nuevo empleado a la colección observable
            Empleados.Add(nuevo);
            // Limpiar los campos de entrada después de agregar
            NuevoNombre = string.Empty;
        }
    }
}

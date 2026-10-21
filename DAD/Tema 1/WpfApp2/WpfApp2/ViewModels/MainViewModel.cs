using CommunityToolkit.Mvvm.ComponentModel; // ObservableObject y [ObservableProperty]
using CommunityToolkit.Mvvm.Input;          // [RelayCommand]
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;       // ObservableCollection
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using WpfApp2.Models;
using WpfApp2.Services;

namespace WpfApp2.ViewModels
{
    // PASO 2.1 (MainViewModel)
    // - Hereda de ObservableObject: implementa INotifyPropertyChanged, que es lo que permite
    //   que la vista se actualice cuando cambia una propiedad.
    // - DEBE ser "partial": el Toolkit genera código en otro archivo oculto (Source Generator).
    //   Si falta partial -> error CS0260.
    // - El ViewModel NO conoce la vista (no hay ningún using de System.Windows).
    public partial class MainViewModel : ObservableObject
    {
        // Servicio inyectado. readonly = solo se puede asignar en el constructor.
        // Se declara con la INTERFAZ, no con EmpleadoService.
        private readonly IEmpleadoService _empleadoService;

        // ---------------------------------------------------------------------------
        // PASO 2.2 (Propiedades reactivas) con [ObservableProperty]
        // REGLA: campo privado que empieza por _ y en minúscula  ->  el Toolkit genera
        //        una propiedad PÚBLICA con el mismo nombre en MAYÚSCULA y sin el guion bajo.
        //        _nuevoNombre -> NuevoNombre   (esa es la que se usa en el XAML y en el código)
        // Dentro de los métodos usa SIEMPRE la propiedad (NuevoNombre), nunca el campo (_nuevoNombre).
        // ---------------------------------------------------------------------------

        // Texto del TextBox. [NotifyCanExecuteChangedFor] hace que, cada vez que cambie el nombre,
        // se vuelva a evaluar si el botón Agregar debe estar activo o desactivado.
        [ObservableProperty]
        [NotifyCanExecuteChangedFor(nameof(AgregarEmpleadoCommand))]
        private string _nuevoNombre = string.Empty;

        // Elemento elegido en el ComboBox (arranca con un valor de la lista)
        [ObservableProperty]
        private string _nuevoDepartamento = "Ventas";

        // Estado del CheckBox de jornada completa (true = marcado al arrancar)
        [ObservableProperty]
        private bool _nuevoActivo = true;

        // ObservableCollection avisa a la vista cuando se AÑADE o BORRA un elemento,
        // así el ListView se refresca solo. Una List normal NO lo hace.
        [ObservableProperty]
        private ObservableCollection<Empleado> _empleados = new();

        // Opciones que se muestran en el ComboBox (ItemsSource)
        [ObservableProperty]
        private List<string> _departamentos = new() { "Ventas", "Marketing", "IT", "RRHH" };

        // Fila seleccionada en el ListView (SelectedItem). Puede ser null si no hay selección
        // (por eso lleva el signo ? : Empleado? ).
        [ObservableProperty]
        private Empleado? _empleadoSeleccionado;

        // INYECCIÓN DE DEPENDENCIAS POR CONSTRUCTOR:
        // quien crea el ViewModel (el code-behind) le pasa el servicio ya creado.
        public MainViewModel(IEmpleadoService empleadoService)
        {
            _empleadoService = empleadoService;
            CargarDatos(); // al crear el ViewModel se cargan los datos iniciales
        }

        // Pide la lista al servicio y la convierte en ObservableCollection
        private void CargarDatos()
        {
            var datos = _empleadoService.ObtenerEmpleadosMockup();
            Empleados = new ObservableCollection<Empleado>(datos);
        }

        // VALIDACIÓN DE EJECUCIÓN (CanExecute):
        // si devuelve false, el botón enlazado al comando se pone gris automáticamente.
        // IsNullOrWhiteSpace también considera vacío un texto que solo tenga espacios.
        private bool PuedeAgregar => !string.IsNullOrWhiteSpace(NuevoNombre);

        // [RelayCommand] sobre un método genera el comando "AgregarEmpleadoCommand"
        // (nombre del método + la palabra Command). Ese es el nombre que se usa en el XAML:
        // Command="{Binding AgregarEmpleadoCommand}"
        // CanExecute = nameof(PuedeAgregar) lo conecta con la validación de arriba.
        [RelayCommand(CanExecute = nameof(PuedeAgregar))]
        private void AgregarEmpleado()
        {
            // Crear un empleado con los datos que hay en el formulario
            var nuevo = new Empleado
            {
                Id = Empleados.Count + 1, // siguiente número de ID
                Nombre = NuevoNombre,
                Departamento = NuevoDepartamento,
                Salario = 1500.00m,       // salario fijo de ejemplo (no hay campo para él)
                JornadaCompleta = NuevoActivo
            };

            // Al añadir a la ObservableCollection, el ListView se actualiza solo
            Empleados.Add(nuevo);

            // Limpiar el formulario: como NuevoNombre avisa a la vista, el TextBox se vacía
            // y el botón se vuelve a desactivar.
            NuevoNombre = string.Empty;
        }
    }
}

using System.Windows;
using WpfApp2.Services;
using WpfApp2.ViewModels;

// El namespace debe coincidir con x:Class del XAML (WpfApp2.Views.MainWindow).
// Si no coinciden -> error CS0103: 'InitializeComponent' no existe.
namespace WpfApp2.Views
{
    // PASO 2.4 (Code-Behind): aquí NO hay eventos Click ni lógica de la aplicación;
    // solo se "pegan" las piezas MVVM.
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            // Carga y construye los controles definidos en el XAML. Siempre va primero.
            InitializeComponent();

            // 1. Crear el servicio (se declara con la interfaz, se instancia la clase concreta)
            IEmpleadoService servicio = new EmpleadoService();

            // 2. REGLA DE ORO: el DataContext se asigna AQUÍ, desde C#, pasando el servicio
            //    al constructor del ViewModel. Prohibido hacer <Window.DataContext><vm:MainViewModel/>
            //    en el XAML: el ViewModel necesita un servicio y no tiene constructor vacío.
            //    Todos los {Binding ...} del XAML buscan sus propiedades en este objeto.
            DataContext = new MainViewModel(servicio);
        }
    }
}

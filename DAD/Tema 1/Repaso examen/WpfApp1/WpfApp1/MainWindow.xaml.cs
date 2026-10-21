using System.Text;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;
using WpfApp1.services;
using WpfApp1.ViewModels;

namespace WpfApp1
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();

            // Crear una instancia del servicio de empleados (puede ser un mockup o una implementación real)
            IEmpleadoService servicioMock = new EmpleadoService();

            // Inyectar el servicio en el ViewModel y asignarlo al DataContext
            DataContext = new MainViewModel(servicioMock);
        }
    }
}
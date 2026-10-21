using System.Windows;
using WpfApp1.Services;
using WpfApp1.ViewModels;

namespace WpfApp1.Views
{
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();

            // 1. Instanciamos el servicio mockup
            IProductoService servicioMock = new ProductoService();

            // 2. Asignamos el DataContext inyectando la dependencia
            DataContext = new MainViewModel(servicioMock);
        }
    }
}
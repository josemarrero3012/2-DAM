using System.ComponentModel;
using System.Runtime.CompilerServices;
namespace WpfApp1
{
    public class SaludoViewModel : INotifyPropertyChanged
    {
        private string _nombre = "Carlos";
        // Propiedad a la que se conectan el TextBox y el TextBlock
        public string Nombre
        {
            get
            {
                return _nombre;
            }
            set
            {
                if (_nombre != value)
                {
                    _nombre = value;
                    OnPropertyChanged();
                }
            }
        }
        public event PropertyChangedEventHandler PropertyChanged;
        protected void OnPropertyChanged([CallerMemberName] string propertyName = null)
        {
            if (PropertyChanged != null)
            {
                PropertyChanged(this, new PropertyChangedEventArgs(propertyName));
            }
        }
    }
}
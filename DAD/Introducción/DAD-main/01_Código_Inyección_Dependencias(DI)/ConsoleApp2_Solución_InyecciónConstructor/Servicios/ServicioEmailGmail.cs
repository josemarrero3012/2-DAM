using ConsoleApp1.Interfaces;

namespace ConsoleApp1.Servicios
{
    public class ServicioEmailGmail: INotificador
    {
        public void Enviar(string destinatario, string mensaje)
        {
            Console.WriteLine("[Gmail] Enviando Email a " + destinatario + ": " + mensaje);
        }
    }
}
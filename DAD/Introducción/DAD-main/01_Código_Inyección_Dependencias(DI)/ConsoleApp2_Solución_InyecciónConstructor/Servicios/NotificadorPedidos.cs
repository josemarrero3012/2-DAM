using ConsoleApp1.Interfaces;

namespace ConsoleApp1.Servicios
{
    public class NotificadorPedidos
    {
        // Dependemos de una abstracción (la interfaz), no de una clase concreta
        private readonly INotificador _notificador;

        // INYECCIÓN POR CONSTRUCTOR: Alguien de afuera le entrega la herramienta
        public NotificadorPedidos(INotificador notificador)
        {
            _notificador = notificador;
        }

        public void NotificarCliente(string cliente, string mensaje)
        {
            // Ejecuta el envío sin importarle si es Gmail, SMS o WhatsApp
            _notificador.Enviar(cliente, mensaje);
        }
    }
}
using ConsoleApp1.Interfaces;

namespace ConsoleApp1.Servicios
{
    public class NotificadorPedidos
    {
        
        // La dependencia se inyecta directamente en el método que la necesita.
        public void NotificarCliente(INotificador notificador, string cliente, string mensaje)
        {
            // Usa la herramienta que le pasaron en este preciso momento
            notificador.Enviar(cliente, mensaje);
        }
    }
}
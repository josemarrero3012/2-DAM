namespace ConsoleApp1.Servicios
{
    public class NotificadorPedidos
    {
        // El acoplamiento fuerte: 
        /*
         1-   Rigidez al cambiar de tecnología: Si el negocio te dice "ya no queremos usar
        Gmail, ahora usaremos Outlook o SMS", te ves obligado a modificar el código fuente de la clase existente.


        2-  Imposibilidad de hacer pruebas unitarias (Unit Testing): Si tu clase de negocio crea directamente una conexión a una base de datos real o a un servicio web mediante un new, cada vez que ejecutes una prueba automática estarás intentando conectarte a la red o a la base de datos real, haciendo las pruebas lentas, frágiles y dependientes de factores externos.
         
         */
        private readonly ServicioEmailGmail _emailService = new ServicioEmailGmail();

        public void NotificarCliente(string cliente, string mensaje)
        {
            _emailService.EnviarCorreo(cliente, mensaje);
        }
    }
}
namespace ConsoleApp1.Servicios
{
    public class ServicioEmailGmail
    {
        public void EnviarCorreo(string destinatario, string mensaje)
        {
            Console.WriteLine("[Gmail] Enviando Email a " + destinatario + ": " + mensaje);
        }
    }
}
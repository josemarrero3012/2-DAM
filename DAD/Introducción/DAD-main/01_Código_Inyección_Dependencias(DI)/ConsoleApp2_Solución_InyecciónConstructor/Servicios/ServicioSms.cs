using ConsoleApp1.Interfaces;
using System;
using System.Collections.Generic;
using System.Text;

namespace ConsoleApp1.Servicios
{
    public class ServicioSms : INotificador
    {
        public void Enviar(string destinatario, string mensaje)
        {
            Console.WriteLine("[SMS] Enviando texto a " + destinatario + ": " + mensaje);
        }
    }
}

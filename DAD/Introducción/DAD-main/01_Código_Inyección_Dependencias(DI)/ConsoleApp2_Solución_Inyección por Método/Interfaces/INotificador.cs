using System;
using System.Collections.Generic;
using System.Text;

namespace ConsoleApp1.Interfaces
{
    public interface INotificador
    {
        void Enviar(string destinatario, string mensaje);
    }
}

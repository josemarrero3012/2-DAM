using System;
using ConsoleApp1.Abstracciones;

namespace ConsoleApp1.Modelos
{
    public class ConexionPostgreSql : ConexionBase
    {
        public ConexionPostgreSql(string cadenaConexion)
            : base(cadenaConexion, "PostgreSQL") { }

        public override void EjecutarConsulta(string consultaSQL)
        {
            if (EstaAbierta)
            {
                Console.WriteLine(" [PostgreSQL]: Ejecutando via PL/pgSQL -> " + consultaSQL);
            }
            else
            {
                Console.WriteLine("[PostgreSQL]: Error. La conexión está cerrada.");
            }
        }
    }
}
using System;
using ConsoleApp1.Abstracciones;

namespace ConsoleApp1.Modelos
{
    public class ConexionSqlServer : ConexionBase
    {
        public ConexionSqlServer(string cadenaConexion)
            : base(cadenaConexion, "SQL Server") { }

        public override void EjecutarConsulta(string consultaSQL)
        {
            if (EstaAbierta)
            {
                Console.WriteLine("[SQL Server]: Ejecutando via T-SQL -> " + consultaSQL);
            }
            else
            {
                Console.WriteLine("[SQL Server]: Error. La conexión está cerrada.");
            }
        }
    }
}
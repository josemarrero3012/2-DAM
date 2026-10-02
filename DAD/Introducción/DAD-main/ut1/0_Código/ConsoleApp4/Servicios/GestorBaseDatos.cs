using System;
using ConsoleApp1.Abstracciones;

namespace ConsoleApp1.Servicios
{
    public class GestorBaseDatos
    {
        // Polimorfismo: Recibe CUALQUIER motor que implemente IConexionBD
        public void ProcesarTransaccion(IConexionBD conexion, string sql)
        {
            Console.WriteLine("\n--- Iniciando transacción en motor: " + conexion.MotorBD + " ---");

            conexion.Abrir();
            conexion.EjecutarConsulta(sql);
            conexion.Cerrar();

            Console.WriteLine("--- Transacción finalizada ---");
        }
    }
}
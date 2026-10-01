using System;
using ConsoleApp1.Abstracciones;

namespace ConsoleApp1.Abstracciones
{
    public abstract class ConexionBase : IConexionBD
    {
        public string CadenaConexion { get; }
        public string MotorBD { get; }
        public bool EstaAbierta { get; protected set; }

        protected ConexionBase(string cadenaConexion, string motorBD)
        {
            CadenaConexion = cadenaConexion;
            MotorBD = motorBD;
            EstaAbierta = false;
        }

        public void Abrir()
        {
            if (!EstaAbierta)
            {
                EstaAbierta = true;
                Console.WriteLine("[CONEXIÓN]: Conexión abierta con éxito hacia " + MotorBD + ".");
            }
        }

        public void Cerrar()
        {
            if (EstaAbierta)
            {
                EstaAbierta = false;
                Console.WriteLine("[CONEXIÓN]: Conexión cerrada con " + MotorBD + ".");
            }
        }

        // Obliga a cada motor a definir CÓMO procesa las consultas (Polimorfismo)
        public abstract void EjecutarConsulta(string consultaSQL);
    }
}
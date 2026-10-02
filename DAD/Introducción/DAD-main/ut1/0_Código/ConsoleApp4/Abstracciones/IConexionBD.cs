namespace ConsoleApp1.Abstracciones
{
    public interface IConexionBD
    {
        string CadenaConexion { get; }
        string MotorBD { get; }
        bool EstaAbierta { get; }

        void Abrir();
        void Cerrar();
        void EjecutarConsulta(string consultaSQL);
    }
}
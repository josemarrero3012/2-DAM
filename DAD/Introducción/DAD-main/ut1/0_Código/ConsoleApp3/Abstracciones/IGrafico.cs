namespace ConsoleApp1.Abstracciones
{
    public interface IGrafico
    {
        string Titulo { get; }
        string Tipo { get; }
        bool TieneDatos { get; }

        void CargarDatos();
        void Dibujar();
    }
}
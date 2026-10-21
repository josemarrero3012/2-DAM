using RepasoExamen.Model;

namespace RepasoExamen.Services
{
    public interface ILibroService
    {
        List<Libro> ObtenerLibrosMockUp();
        List<Libro> ObtenerLibrosDisponibles();
        void AgregarLibro(Libro libro);
    }
}

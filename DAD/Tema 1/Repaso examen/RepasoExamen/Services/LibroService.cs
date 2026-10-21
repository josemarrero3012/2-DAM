using RepasoExamen.Model;

namespace RepasoExamen.Services
{
    public class LibroService : ILibroService
    {
        private readonly List<Libro> _libros = new()
        {
            new Libro { Id = 1, Titulo = "El principito", Autor = "Antoine de Saint-Exupéry",
                        AnioPublicacion = 1943, Genero = "Ficción", Disponible = true },
            new Libro { Id = 2, Titulo = "Dune", Autor = "Frank Herbert",
                        AnioPublicacion = 1965, Genero = "Ciencia ficción", Disponible = false },
            new Libro { Id = 3, Titulo = "Matilda", Autor = "Roald Dahl",
                        AnioPublicacion = 1988, Genero = "Infantil", Disponible = true }
        };

        public List<Libro> ObtenerLibrosMockUp()
        {
            return _libros;
        }

        public List<Libro> ObtenerLibrosDisponibles()
        {
            var librosDisponibles = new List<Libro>();
            foreach (var libro in _libros)
            {
                if (libro.Disponible)
                {
                    librosDisponibles.Add(libro);
                }
            }
            return librosDisponibles;
        }

        public void AgregarLibro(Libro libro)
        {
            _libros.Add(libro);
        }
    }
}

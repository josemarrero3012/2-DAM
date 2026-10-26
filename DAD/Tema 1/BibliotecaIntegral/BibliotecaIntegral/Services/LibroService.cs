using System;
using System.Collections.Generic;
using System.Text;
using BibliotecaIntegral.Models;

namespace BibliotecaIntegral.Services
{
    public class LibroService : ILibroService 
    {
        public List<Libro> ObtenerLibrosMockup()
        {
            return new List<Libro>
            {
                //la m del final indica que el precio es decimal, sin ella lo toma como double y da error
                new Libro { Id = 1, Titulo = "Berserk", Genero = "Aventura", PrecioAlquiler = 2.50m, Disponibilidad = true },
                new Libro { Id = 2, Titulo = "Solanin", Genero = "Tragedia", PrecioAlquiler = 3.00m, Disponibilidad = false },
                new Libro { Id = 3, Titulo = "Mi lucha - Adolf Hitler", Genero = "Historia", PrecioAlquiler = 2.00m, Disponibilidad = true },
                new Libro { Id = 4, Titulo = "Como ganar amigos e influir sobre las personas", Genero = "Social", PrecioAlquiler = 3.50m, Disponibilidad = true }
            };
        }
    }
}

using System;
using System.Collections.Generic;
using System.Text;
using WpfApp1.Models;

namespace WpfApp1.Services
{
    public class ProductoService : IProductoService
    {
        public List<Producto> ObtenerProductosMockup()
        {
            return new List<Producto>
            {
                new Producto { Id = 1, Nombre = "Teclado Mecánico", Categoria = "Periféricos", Precio = 79.99m, Disponible = true },
                new Producto { Id = 2, Nombre = "Ratón Óptico", Categoria = "Periféricos", Precio = 29.50m, Disponible = true },
                new Producto { Id = 3, Nombre = "Monitor 4K", Categoria = "Pantallas", Precio = 349.00m, Disponible = false },
                new Producto { Id = 4, Nombre = "Auriculares Bluetooth", Categoria = "Audio", Precio = 59.90m, Disponible = true }
            };
        }
    }
}

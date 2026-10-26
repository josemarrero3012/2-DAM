using System;
using System.Collections.Generic;
using System.Text;

namespace BibliotecaIntegral.Models
{
    public class Libro //visual me puso internal class por defecto y lo cambio a clase pública para que otras clases la puedan usar
    {
        //lo primero que me pide el ejercicio es crear la clase de libro con sus propiedades
        public int Id { get; set; }
        public string Titulo { get; set; } = string.Empty;
        public string Genero { get; set; } = string.Empty;
        public decimal PrecioAlquiler { get; set; } //pongo decimal para controlar los precios con decimales
        public bool Disponibilidad { get; set; }
    }
}

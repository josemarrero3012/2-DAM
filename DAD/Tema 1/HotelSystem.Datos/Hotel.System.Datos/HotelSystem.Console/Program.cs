using System;
using HotelSystem.Datos;
using HotelSystem.Negocio;

IHabitacionRepository repo = new HabitacionRepository();

IReservaManager negocio = new ReservaManager(repo);

string tipo = "suite";
int noches = 7;

decimal total = negocio.CalcularTotalReserva(tipo, noches);

Console.WriteLine("=== SISTEMA DE RESERVAS DE HOTEL ===");
Console.WriteLine("Tipo de habitacion: " + tipo);
Console.WriteLine("Noches de estancia: " + noches);
Console.WriteLine("Total a pagar: " + total + " EUR");

Console.ReadKey();
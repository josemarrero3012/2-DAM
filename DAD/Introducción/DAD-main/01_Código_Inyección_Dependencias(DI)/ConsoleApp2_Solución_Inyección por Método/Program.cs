using ConsoleApp1.Interfaces;
using ConsoleApp1.Servicios;

Console.WriteLine("========================================");
Console.WriteLine("   SIMULADOR CON INYECCIÓN POR MÉTODO");
Console.WriteLine("========================================\n");

// Instanciamos la clase 
NotificadorPedidos gestorNotificaciones = new NotificadorPedidos();

// Creamos los servicios de notificación
INotificador servicioEmail = new ServicioEmailGmail();
INotificador servicioSms = new ServicioSms();

// ESCENARIO 1: Queremos usar Gmail (Inyectamos el servicio en el método)
Console.WriteLine("--- Enviando por Gmail ---");
gestorNotificaciones.NotificarCliente(servicioEmail, "joseacosta@email.com", "Tu pedido ha sido procesado.");


Console.WriteLine("\n----------------------------------------");
Console.WriteLine("CAMBIO DE ÚLTIMA HORA: El cliente quiere SMS");
Console.WriteLine("----------------------------------------\n");


// ESCENARIO 2: Cambiamos a SMS SIN MODIFICAR la clase NotificadorPedidos
// Inyectamos el SMS directamente en el método
Console.WriteLine("--- Enviando por SMS ---");
gestorNotificaciones.NotificarCliente(servicioSms, "+34111111", "Tu paquete va en camino por SMS.");


Console.WriteLine("\nPresiona cualquier tecla para cerrar la simulación...");
Console.ReadKey();
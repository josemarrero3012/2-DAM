using ConsoleApp1.Interfaces;
using ConsoleApp1.Servicios;

Console.WriteLine("========================================");
Console.WriteLine("   SIMULADOR CON INYECCIÓN DE DEPENDENCIAS");
Console.WriteLine("========================================\n");

// ESCENARIO 1: Queremos usar Gmail

INotificador servicioEmail = new ServicioEmailGmail();

//   INYECTAMOS por el constructor a nuestra clase de negocio
NotificadorPedidos notificadorConEmail = new NotificadorPedidos(servicioEmail);
notificadorConEmail.NotificarCliente("joseacosta@email.com", "Tu pedido ha sido procesado.");


Console.WriteLine("\n----------------------------------------");
Console.WriteLine("CAMBIO DE ÚLTIMA HORA: El cliente quiere SMS");
Console.WriteLine("----------------------------------------\n");


// ESCENARIO 2: Cambiamos a SMS SIN MODIFICAR la clase NotificadorPedidos

INotificador servicioSms = new ServicioSms();

//  INYECTAMOS el SMS por el constructor
NotificadorPedidos notificadorConSms = new NotificadorPedidos(servicioSms);
notificadorConSms.NotificarCliente("+34111111", "Tu paquete va en camino por SMS.");


Console.WriteLine("\nPresiona cualquier tecla para cerrar la simulación...");
Console.ReadKey();
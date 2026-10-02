using ConsoleApp1.Servicios;

Console.WriteLine("========================================");
Console.WriteLine("   SIMULADOR DE NOTIFICACIONES (ACOPLADO)");
Console.WriteLine("========================================\n");

// Instanciamos el negocio
NotificadorPedidos notificador = new NotificadorPedidos();

// Ejecutamos la notificación
notificador.NotificarCliente("Jose Acosta@email.com", "Tu pedido ha sido procesado con éxito.");

Console.WriteLine("Presiona cualquier tecla para cerrar la simulación...");
Console.ReadKey();
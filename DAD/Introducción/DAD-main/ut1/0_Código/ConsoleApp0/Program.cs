using ConsoleApp1;

Console.WriteLine("========================================");
Console.WriteLine("    CLASE MAESTRA: PRINCIPIOS DE POO    ");
Console.WriteLine("========================================\n");

// INSTANCIACIÓN: Objetos concretos que implementan IVehiculo directamente
Coche miCoche = new Coche("Cupra", "Raval");
Moto miMoto = new Moto("Yamaha", "MT-07");

// Nota pedagógica: Las interfaces no se pueden instanciar directamente
// IVehiculo baseErronea = new IVehiculo(); 

// ENCAPSULAMIENTO
// Intentamos acelerar sin encender
miCoche.Acelerar();

miMoto.Encender();
miMoto.Acelerar();


Console.WriteLine("\nPresiona cualquier tecla para cerrar ...");
Console.ReadKey();
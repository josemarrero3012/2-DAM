using ConsoleApp1.Modelos;

    Console.WriteLine("========================================");
    Console.WriteLine("    CLASE MAESTRA: PRINCIPIOS DE POO    ");
    Console.WriteLine("========================================\n");

    //INSTANCIACIÓN: Creamos objetos concretos usando el molde (clases)
    Coche miCoche = new Coche("Toyota", "Corolla");
    Moto miMoto = new Moto("Yamaha", "MT-07");

    // Nota pedagógica: Descomentar la siguiente línea dará error porque es abstracta
    // IVehiculo baseErronea = new VehiculoBase("Error", "Grave"); 

    // ENCAPSAMIENTO
    // Intentamos acelerar sin encender
    
    miCoche.Acelerar();

    miMoto.Encender();
    miMoto.Acelerar();


    Console.WriteLine("\nPresiona cualquier tecla para cerrar la simulación...");
    Console.ReadKey();


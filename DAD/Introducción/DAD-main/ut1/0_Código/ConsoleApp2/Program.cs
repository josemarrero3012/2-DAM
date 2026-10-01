using ConsoleApp1.Modelos;
using ConsoleApp1.Servicios;

    Console.WriteLine("========================================");
    Console.WriteLine("    CLASE MAESTRA: PRINCIPIOS DE POO    ");
    Console.WriteLine("========================================\n");

    //INSTANCIACIÓN:
    Coche miCoche = new Coche("Toyota", "Corolla");
    Moto miMoto = new Moto("Yamaha", "MT-07");

    // Nota pedagógica: Descomentar la siguiente línea dará error porque es abstracta
    // IVehiculo baseErronea = new VehiculoBase("Error", "Grave"); 

    // ENCAPSAMIENTO
    // Intentamos acelerar sin encender
    
    miCoche.Acelerar();

    miMoto.Encender();
    miMoto.Acelerar();


    //POLIMORFISMO
    SimuladorConduccion simulador = new SimuladorConduccion();

    // Enviamos el Auto al simulador
    simulador.IniciarPrueba(miCoche);

    // Enviamos la Moto al mismo simulador (Polimorfismo mediante IVehiculo)
    simulador.IniciarPrueba(miMoto);



    Console.WriteLine("\nPresiona cualquier tecla para cerrar la simulación...");
    Console.ReadKey();


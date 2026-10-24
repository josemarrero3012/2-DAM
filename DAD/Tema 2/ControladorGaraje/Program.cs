using System;
using System.Speech.Recognition;

// Pongo las palabras en arrays para que sea mas facil añadir mas luego
string[] verbos = new string[] { "abrir", "cerrar", "arrancar" };
string[] dispositivos = new string[] { "puerta", "coche", "luces" };
string[] comandos = new string[] { "ayuda", "salir" };

using SpeechRecognitionEngine reconocedor = new SpeechRecognitionEngine();

Choices opcionesVerbos = new Choices(verbos);
Choices opcionesDispositivos = new Choices(dispositivos);
Choices opcionesDirectas = new Choices(comandos);

// Junto verbo + dispositivo para que entienda frases como "abrir puerta"
GrammarBuilder fraseCompuesta = new GrammarBuilder();
fraseCompuesta.Append(opcionesVerbos);
fraseCompuesta.Append(opcionesDispositivos);

Choices todas = new Choices(new GrammarBuilder[] {
    fraseCompuesta,
    new GrammarBuilder(opcionesDirectas)
});

reconocedor.LoadGrammar(new Grammar(todas));

// Conecto el evento y el microfono para que escuche todo el rato
reconocedor.SpeechRecognized += AlEscucharUnaFrase;
reconocedor.SetInputToDefaultAudioDevice();
reconocedor.RecognizeAsync(RecognizeMode.Multiple);

Console.WriteLine("Controlador de garaje");
Console.WriteLine("Prueba a decir: 'abrir puerta', 'arrancar coche', 'cerrar luces', 'ayuda' o 'salir'.\n");

Console.ReadLine();



static void AlEscucharUnaFrase(object sender, SpeechRecognizedEventArgs e)
{
    try
    {
        string accion = "";
        string dispositivo = "";

        foreach (RecognizedWordUnit palabra in e.Result.Words)
        {
            string texto = palabra.Text;

            // Miro primero si es ayuda o salir porque son de una sola palabra
            if (texto == "salir")
            {
                Console.WriteLine("\nCerrando el controlador del garaje.");
                Environment.Exit(0);
            }
            else if (texto == "ayuda")
            {
                Console.WriteLine("\nVerbos: abrir, cerrar, arrancar");
                Console.WriteLine("Dispositivos: puerta, coche, luces");
                Console.WriteLine("Comandos: ayuda, salir");
            }
            // La primera palabra es el verbo y la segunda el dispositivo
            else if (accion == "")
            {
                accion = texto;
            }
            else if (dispositivo == "")
            {
                dispositivo = texto;
            }
        }

        // Si tengo las dos cosas ya puedo hacer la accion
        if (accion != "" && dispositivo != "")
        {
            Console.WriteLine("\n[ACCION]: " + accion + " | [DISPOSITIVO]: " + dispositivo);

            if (accion == "abrir" && dispositivo == "puerta")
            {
                Console.WriteLine("Abriendo la puerta del garaje...");
            }
            else if (accion == "cerrar" && dispositivo == "puerta")
            {
                Console.WriteLine("Cerrando la puerta del garaje...");
            }
            else if (accion == "arrancar" && dispositivo == "coche")
            {
                Console.WriteLine("Arrancando el coche...");
            }
            else if (accion == "abrir" && dispositivo == "luces")
            {
                Console.WriteLine("Encendiendo las luces del garaje.");
            }
            else if (accion == "cerrar" && dispositivo == "luces")
            {
                Console.WriteLine("Apagando las luces del garaje.");
            }
            else
            {
                Console.WriteLine("No se puede " + accion + " " + dispositivo + ".");
            }
        }
    }
    catch (Exception ex)
    {
        Console.WriteLine("\n[ERROR NO CONTROLADO]: " + ex.Message);
        Environment.Exit(1);
    }
}

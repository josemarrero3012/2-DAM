using System.Speech.Recognition;

//pongo las palabras en arrays para que sea más facil añadir más luego
string[] verbos = new string[] { "abrir", "cerrar", "arrancar" };
string[] dispositivos = new string[] { "puerta", "coche", "luces" };
string[] comandos = new string[] { "ayuda", "salir" };

// El reconocedor es el "oído" del programa: escucha el micrófono y lo convierte en texto.
// Con "using" se libera solo (se cierra el micrófono, etc.) cuando el programa termina
using SpeechRecognitionEngine reconocedor = new SpeechRecognitionEngine();

// Choices = "una de estas opciones". El reconocedor entenderá UNA palabra de cada lista,
// por ejemplo "abrir" o "cerrar" o "arrancar", pero no varias a la vez
Choices opcionesVerbos = new Choices(verbos);
Choices opcionesDispositivos = new Choices(dispositivos);
Choices opcionesDirectas = new Choices(comandos);

// Junto verbo + dispositivo para que entienda frases como "abrir puerta"
GrammarBuilder fraseCompuesta = new GrammarBuilder(); //grammarBuilder sirve para construir frases paso a paso: Append añade el siguiente trozo, y el orden importa (primero verbo, luego dispositivo)
fraseCompuesta.Append(opcionesVerbos);
fraseCompuesta.Append(opcionesDispositivos);

// Las frases válidas son: "verbo + dispositivo" (ej: "abrir puerta") O una palabra suelta ("ayuda", "salir").
// Todo lo que no esté aquí, el reconocedor lo ignora
Choices todas = new Choices(new GrammarBuilder[] {
    fraseCompuesta,
    new GrammarBuilder(opcionesDirectas)
});

// La gramática es el conjunto de frases que el programa es capaz de entender.
// Al tener pocas frases posibles, el reconocimiento es mucho más preciso
reconocedor.LoadGrammar(new Grammar(todas));

// Conecto el evento y el microfono para que escuche todo el rato
// Un evento es un aviso: cuando el reconocedor entienda una frase, llamará a mi método AlEscucharUnaFrase.
// El "+=" significa "suscribirme" a ese aviso
reconocedor.SpeechRecognized += AlEscucharUnaFrase;
// Le digo que use el micrófono que Windows tenga por defecto
reconocedor.SetInputToDefaultAudioDevice();
// Async = escucha en segundo plano sin bloquear el programa.
// Multiple = no para después de la primera frase, sigue escuchando indefinidamente
reconocedor.RecognizeAsync(RecognizeMode.Multiple);

Console.WriteLine("Controlador de garaje");
Console.WriteLine("Prueba a decir: 'abrir puerta', 'arrancar coche', 'cerrar luces', 'ayuda' o 'salir'.\n");

// Esta línea es para que el programa no termine: se queda esperando a que pulses Enter.
// Mientras tanto, el reconocedor sigue escuchando en segundo plano
Console.ReadLine();



// Este método se ejecuta automáticamente cada vez que el reconocedor entiende una frase.
// "sender" es quien lanzó el evento y "e" trae los datos de lo que se ha entendido
static void AlEscucharUnaFrase(object sender, SpeechRecognizedEventArgs e)
{
    // try/catch: intento ejecutar el código y, si algo falla, en vez de que el programa explote
    // salto al catch y puedo mostrar un mensaje del error
    try
    {
        // Aquí guardo lo que voy entendiendo de la frase. Empiezan vacías ("")
        string accion = "";
        string dispositivo = "";

        // e.Result.Words es la lista de palabras de la frase. Por ejemplo "abrir puerta" son 2 palabras.
        // El foreach recorre la lista y en cada vuelta "palabra" es una de ellas
        foreach (RecognizedWordUnit palabra in e.Result.Words)
        {
            // Text es la palabra ya convertida a texto
            string texto = palabra.Text;

            // Miro primero si es ayuda o salir porque son de una sola palabra
            if (texto == "salir")
            {
                Console.WriteLine("\nCerrando el controlador del garaje.");
                // Termina el programa. El 0 es el código de salida y significa "todo ha ido bien"
                Environment.Exit(0);
            }
            else if (texto == "ayuda")
            {
                // Muestro todo lo que se puede decir
                Console.WriteLine("\nVerbos: abrir, cerrar, arrancar");
                Console.WriteLine("Dispositivos: puerta, coche, luces");
                Console.WriteLine("Comandos: ayuda, salir");
            }
            // La primera palabra es el verbo y la segunda el dispositivo
            // Si accion sigue vacía es que esta es la primera palabra, así que es el verbo
            else if (accion == "")
            {
                accion = texto;
            }
            // Si ya tengo el verbo pero no el dispositivo, esta es la segunda palabra
            else if (dispositivo == "")
            {
                dispositivo = texto;
            }
        }

        // Si tengo las dos cosas ya puedo hacer la accion
        // (&& significa "y": las dos condiciones tienen que cumplirse; != significa "distinto de")
        // Si has dicho "ayuda" no entra aquí porque accion y dispositivo siguen vacíos
        if (accion != "" && dispositivo != "")
        {
            Console.WriteLine("\n[ACCION]: " + accion + " | [DISPOSITIVO]: " + dispositivo);

            // Compruebo la combinación exacta. "abrir" las luces significa encenderlas y "cerrar" apagarlas
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
            // Combinaciones que la gramática permite pero no tienen sentido, como "arrancar puerta"
            else
            {
                Console.WriteLine("No se puede " + accion + " " + dispositivo + ".");
            }
        }
    }
    // Si ocurre cualquier error dentro del try, se ejecuta esto. "ex.Message" es la descripción del error
    catch (Exception ex)
    {
        Console.WriteLine("\n[ERROR NO CONTROLADO]: " + ex.Message);
        // El 1 como código de salida indica que el programa terminó por un error
        Environment.Exit(1);
    }
}

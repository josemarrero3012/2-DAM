import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;
import java.util.Scanner;

public class Main {

    // Archivo donde se guarda y se carga la biblioteca
    private static final String ARCHIVO = "biblioteca.xml";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();
        int opcion = 0;

        do {
            System.out.println();
            System.out.println("===== GESTOR DE BIBLIOTECA DIGITAL =====");
            System.out.println("1. Añadir un libro");
            System.out.println("2. Mostrar todos los libros");
            System.out.println("3. Guardar biblioteca");
            System.out.println("4. Cargar biblioteca");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");

            try {
                opcion = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                opcion = 0;
            }

            switch (opcion) {
                case 1:
                    anadirLibro(biblioteca, sc);
                    break;
                case 2:
                    mostrarLibros(biblioteca);
                    break;
                case 3:
                    guardarBiblioteca(biblioteca);
                    break;
                case 4:
                    biblioteca = cargarBiblioteca(biblioteca);
                    break;
                case 5:
                    System.out.println("Hasta luego.");
                    break;
                default:
                    System.out.println("Opción no válida, escribe un número del 1 al 5.");
            }
        } while (opcion != 5);

        sc.close();
    }

    // Pide los datos por consola y añade el libro a la lista
    private static void anadirLibro(Biblioteca biblioteca, Scanner sc) {
        System.out.print("Título: ");
        String titulo = sc.nextLine();

        System.out.print("Autor: ");
        String autor = sc.nextLine();

        System.out.print("ISBN: ");
        String isbn = sc.nextLine();

        int anio = 0;
        boolean anioCorrecto = false;
        while (!anioCorrecto) {
            System.out.print("Año de publicación: ");
            try {
                anio = Integer.parseInt(sc.nextLine().trim());
                anioCorrecto = true;
            } catch (NumberFormatException e) {
                System.out.println("El año tiene que ser un número.");
            }
        }

        Libro libro = new Libro(isbn, titulo, autor, anio);
        biblioteca.getLibros().add(libro);
        System.out.println("Libro añadido correctamente.");
    }

    private static void mostrarLibros(Biblioteca biblioteca) {
        if (biblioteca.getLibros().isEmpty()) {
            System.out.println("La biblioteca está vacía.");
            return;
        }

        System.out.println("--- Lista de libros ---");
        int contador = 1;
        for (Libro libro : biblioteca.getLibros()) {
            System.out.println(contador + ". " + libro);
            contador++;
        }
    }

    // Convierte la biblioteca a XML (marshal) y la guarda en el archivo
    private static void guardarBiblioteca(Biblioteca biblioteca) {
        try {
            JAXBContext contexto = JAXBContext.newInstance(Biblioteca.class);
            Marshaller marshaller = contexto.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(biblioteca, new File(ARCHIVO));
            System.out.println("Biblioteca guardada en " + ARCHIVO);
        } catch (JAXBException e) {
            System.out.println("Error al guardar la biblioteca: " + e.getMessage());
        }
    }

    // Lee el XML (unmarshal) y devuelve la biblioteca cargada
    private static Biblioteca cargarBiblioteca(Biblioteca actual) {
        File archivo = new File(ARCHIVO);
        if (!archivo.exists()) {
            System.out.println("No existe el archivo " + ARCHIVO + ", primero guarda la biblioteca.");
            return actual;
        }

        try {
            JAXBContext contexto = JAXBContext.newInstance(Biblioteca.class);
            Unmarshaller unmarshaller = contexto.createUnmarshaller();
            Biblioteca cargada = (Biblioteca) unmarshaller.unmarshal(archivo);
            System.out.println("Biblioteca cargada: " + cargada.getLibros().size() + " libros.");
            return cargada;
        } catch (JAXBException e) {
            System.out.println("Error al cargar la biblioteca: " + e.getMessage());
            return actual;
        }
    }
}

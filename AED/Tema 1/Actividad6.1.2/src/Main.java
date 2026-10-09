import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Crear directorio");
            System.out.println("2. Crear fichero");
            System.out.println("3. Borrar fichero");
            System.out.println("4. Borrar directorio");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del directorio: ");
                    crearDirectorio(sc.nextLine());
                    break;
                case 2:
                    System.out.print("Ruta del fichero: ");
                    crearFichero(sc.nextLine());
                    break;
                case 3:
                    System.out.print("Ruta del fichero: ");
                    borrarFichero(sc.nextLine());
                    break;
                case 4:
                    System.out.print("Nombre del directorio: ");
                    File dir = new File(sc.nextLine());
                    if (dir.exists() && dir.isDirectory()) {
                        borrarDirectorio(dir);
                        System.out.println("Directorio borrado");
                    } else {
                        System.out.println("El directorio no existe");
                    }
                    break;
                case 0:
                    System.out.println("Adios");
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        } while (opcion != 0);

        sc.close();
    }

    public static void crearDirectorio(String directorio) {
        try {
            boolean exito = (new File(directorio)).mkdirs();
            if (exito)
                System.out.println("Directorio: " + directorio + " creado");
            else
                System.out.println("No se ha podido crear el directorio");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static void crearFichero(String ruta) {
        try {
            File fichero = new File(ruta);
            if (fichero.createNewFile())
                System.out.println("El fichero se ha creado correctamente");
            else
                System.out.println("No ha podido ser creado el fichero");
        } catch (IOException ioe) {
            System.err.println("Error: " + ioe.getMessage());
        }
    }

    public static void borrarFichero(String ruta) {
        File fichero = new File(ruta);
        if (fichero.exists() && fichero.isFile()) {
            if (fichero.delete())
                System.out.println("Fichero borrado");
            else
                System.out.println("No se ha podido borrar el fichero");
        } else {
            System.out.println("El fichero no existe");
        }
    }

    public static void borrarDirectorio(File dir) {
        File[] contenido = dir.listFiles();
        if (contenido != null) {
            for (File f : contenido) {
                if (f.isDirectory())
                    borrarDirectorio(f);
                else
                    f.delete();
            }
        }
        dir.delete();
    }
}

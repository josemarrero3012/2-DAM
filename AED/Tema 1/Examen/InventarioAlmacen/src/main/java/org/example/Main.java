package org.example;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static final String FICHERO = "inventario.xml";
    private static final Inventario inventario = new Inventario();
    //voy a usar scanner para leer por pantalla
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion = -1;

        do {
            mostrarMenu();
            try {
                System.out.print("Elige una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine(); //limpio el salto , necesario siempre que se lee un entero
                switch (opcion) {
                    case 1 -> anadirProducto();
                    case 2 -> mostrarProductos();
                    case 3 -> guardarInventario();
                    case 4 -> cargarInventario();
                    case 5 -> System.out.println("Saliendo del programa...");
                    default -> System.out.println("Opción no válida, tiene que ser del 1 al 5.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Formato no válido");
                scanner.nextLine(); //si no limpio esto se queda en bucle infinito
            }
            System.out.println();
        } while (opcion != 5); //mientas la opcón sea distinta de 5, muestro el menú
    }
    private static void mostrarMenu() {
        System.out.println("=========================================");
        System.out.println("        INVENTARIO DEL ALMACÉN           ");
        System.out.println("=========================================");
        System.out.println("1. Añadir un producto");
        System.out.println("2. Mostrar todos los productos");
        System.out.println("3. Guardar inventario");
        System.out.println("4. Cargar inventario");
        System.out.println("5. Salir");
        System.out.println("-----------------------------------------");
    }

    //método para añadir un producto en caso de seleccionar el número 1
    private static void anadirProducto() {
        System.out.println("\n--- AÑADIR PRODUCTO ---");
        //Voy pidiendo los atributos y quiero los espacios
        System.out.print("Código: ");
        String codigo = scanner.nextLine().trim();

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine().trim();

        System.out.print("Descripción: ");
        String descripcion = scanner.nextLine().trim();

        int cantidad = leerEntero("Cantidad: ");
        double precio = leerDecimal("Precio: ");
        //creo el objeto producto con los atributos que recogo de las preguntas
        Producto nuevo = new Producto(nombre, descripcion, codigo, cantidad, precio);
        inventario.agregarProducto(nuevo); //llamo al metodo de la clase inventado que simplemente va a aañadir el producot con "productos.add(producto)
        System.out.println("-> Producto añadido.");
    }

    //tengo la práctica de crear métodos que me simplificarán la vida como un metodo que se encargue de leer los numeros enteros
    private static int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                int numero = scanner.nextInt();
                scanner.nextLine();
                return numero;
            } catch (InputMismatchException e) {
                System.out.println("Formato no válido");
                scanner.nextLine();
            }
        }
    }
    //método que uso para leer numeros decimales
    private static double leerDecimal(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                //leo la linea y cambio la coma por punto para que valga 2,5 y 2.5
                String texto = scanner.nextLine().trim().replace(',', '.');
                return Double.parseDouble(texto);
            } catch (NumberFormatException e) {
                System.out.println("Formato no válido");
            }
        }
    }
    //método para imprimir
    private static void mostrarProductos() {
        System.out.println("\n--- PRODUCTOS DEL INVENTARIO ---");
        if (inventario.getProductos().isEmpty()) {
            System.out.println("No hay productos en el inventario.");
            return;
        }
        //en caso contrario a estar vacío, pues imprime un objeto en cada iteración
        for (Producto p : inventario.getProductos()) {
            System.out.println(p);
        }
    }

    //guardo el inventario siempre en el mismo fichero inventario.xml
    private static void guardarInventario() {
        try {
            JAXBContext contexto = JAXBContext.newInstance(Inventario.class);
            Marshaller m = contexto.createMarshaller();
            //para que el xml salga ordenado con saltos de linea
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.marshal(inventario, new File(FICHERO));
            System.out.println("-> Iventario guardado en " + FICHERO);
        } catch (JAXBException e) {
            System.out.println("Error al guardar el inventario");
        }
    }

    //leo el inventario.xml y lo paso al inventario que tengo en memoria
    private static void cargarInventario() {
        File fichero = new File(FICHERO);
        if (!fichero.exists()) {
            System.out.println("Todavía no hay ningún inventario guardado");
            return;
        }

        try {
            JAXBContext contexto = JAXBContext.newInstance(Inventario.class);
            Unmarshaller u = contexto.createUnmarshaller();
            Inventario cargado = (Inventario) u.unmarshal(fichero);

            //borro lo que había en memoria y meto lo del fichero
            inventario.getProductos().clear();
            inventario.getProductos().addAll(cargado.getProductos());
            System.out.println("-> Inventario cargado");
        } catch (JAXBException e) {
            System.out.println("Error al cargar el inventario");
        }
    }
}

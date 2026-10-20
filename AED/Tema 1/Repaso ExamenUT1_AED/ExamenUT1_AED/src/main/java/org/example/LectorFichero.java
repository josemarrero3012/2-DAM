package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LectorFichero {


    public static List<Persona> leerTexto(String rutaFichero){
        List<Persona> lista = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaFichero))){

            String linea;

            while ((linea = br.readLine()) != null){
                if (linea.trim().isEmpty()) continue;

                String[] partes = linea.split(",");

                if (partes.length == 3){
                    String nombre = partes[0];
                    int edad = Integer.parseInt(partes[1]);
                    String email = partes[2];

                    System.out.printf("Contenidos del archivo: %s, %s, %s%n", nombre, edad, email);

                    lista.add(new Persona(nombre, edad, email));
                }


            }

        } catch (IOException e){
            System.out.println("Error, "+ e.getMessage());

        }
        return lista;
    }
}

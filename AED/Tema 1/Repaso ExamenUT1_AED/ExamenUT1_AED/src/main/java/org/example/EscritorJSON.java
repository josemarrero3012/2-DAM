package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;

public class EscritorJSON {


    public static void exportarJson(Object datos, String rutaSalida){
        try {
            ObjectMapper mapper = new ObjectMapper();

            //Formatear JSON con sangria
            mapper.enable(SerializationFeature.INDENT_OUTPUT);

            //Escribir a fichero
            File fichero = new File(rutaSalida);

            mapper.writeValue(fichero, datos);

            System.out.println("JSON generado con exito en: " + fichero.getAbsolutePath());

        } catch (IOException e){
            System.out.println("Error, "+e.getMessage());

        }
    }


}

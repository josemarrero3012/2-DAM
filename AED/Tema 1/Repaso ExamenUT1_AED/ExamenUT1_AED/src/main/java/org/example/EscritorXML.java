package org.example;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.File;

public class EscritorXML {

    public static void exportarXml(ListaPersonas datos, String rutaSalida){
        try{

            JAXBContext context = JAXBContext.newInstance(ListaPersonas.class);
            Marshaller marshaller = context.createMarshaller();

            //Formatear salida
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            //Escribir a fichero
            File fichero = new File(rutaSalida);
            marshaller.marshal(datos, fichero);
            System.out.println("XML Generado con exito en: " + fichero.getAbsolutePath());


        } catch (JAXBException e){
            System.out.println("Error, "+e.getMessage());


        }
    }

}

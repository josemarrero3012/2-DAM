package org.example;

import java.util.List;

public class Main {

    void main(){
        String archivoTexto = "datos.txt";

        //Leer fichero
        List<Persona> personasList = LectorFichero.leerTexto(archivoTexto);
        ListaPersonas contenedor = new ListaPersonas(personasList);

        //Volcar a XML
        EscritorXML.exportarXml(contenedor, "salida.xml");

        //Volcar a JSON
        EscritorJSON.exportarJson(contenedor, "salida.json");

    }


}

package org.example;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "personas")
@XmlAccessorType(XmlAccessType.FIELD)
public class ListaPersonas {

    @XmlElement(name = "persona")
    private List<Persona> listaPersonas;

    public ListaPersonas(){}


    public ListaPersonas(List<Persona> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }


    public List<Persona> getListaPersonas() {
        return listaPersonas;
    }

    public void setListaPersonas(List<Persona> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }
}

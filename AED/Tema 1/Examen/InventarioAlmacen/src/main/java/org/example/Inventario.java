package org.example;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;

@XmlRootElement(name = "inventario")
@XmlAccessorType(XmlAccessType.FIELD)
public class Inventario {
    //pongo name = "producto" para que en el xml cada producto tenga la etiqueta <producto>
    @XmlElement(name = "producto")
    private ArrayList<Producto> productos = new ArrayList<>();

    public Inventario(){

    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }
}

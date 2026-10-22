package org.example;

import jakarta.xml.bind.annotation.*;

//pongo field para que jaxb mire solo los campos y no se equivoque con los getters y setters
@XmlRootElement(name = "producto")
@XmlAccessorType(XmlAccessType.FIELD)
public class Producto {
    @XmlElement(name = "nombre", required = true)
    private String nombre;
    @XmlElement(name = "descripcion")
    private String descripcion;
    //el enuncciado pide el codigo como atributo xml y no como elemento
    @XmlAttribute(name = "codigo", required = true)
    private String codigo;
    @XmlElement(name = "cantidad", required = true)
    private int cantidad;
    @XmlElement(name = "precio", required = true)
    private double precio;

    //este constructor lo necesito vacío por que jaxb lo usa al leer el xml
    public Producto() {
    }

    //con este constructor espero recibir los atributos al crear un producto
    public Producto(String nombre, String descripcion, String codigo, int cantidad, double precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    //getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override //Genero automaticamente el tooString con click derecho -> generate -> toString()
    public String toString() {
        return "Producto{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", cantidad=" + cantidad +
                ", precio=" + precio +
                '}';
    }
}

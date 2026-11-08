package org.egibide.proyecto3.Modelo;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Piezas")
public class Piezas {
    @Id
    String codigoPieza ;
    String nombre;
    Double precio;
    String descripcion;

    public Piezas() {}
    public Piezas(String codigoPieza, String nombre, Double precio, String descripcion) {
        this.codigoPieza = codigoPieza;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
    }
    @OneToMany( mappedBy = "piezas",fetch = FetchType.LAZY)
    private List<Gestion> gestiones;

    public String getCodigoPieza() {
        return codigoPieza;
    }

    public void setCodigoPieza(String codigoPieza) {
        this.codigoPieza = codigoPieza;
    }

    public List<Gestion> getGestiones() {
        return gestiones;
    }

    public void setGestiones(List<Gestion> gestiones) {
        this.gestiones = gestiones;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Piezas{" +
                "codigoPieza='" + codigoPieza + '\'' +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", descripcion='" + descripcion + '\'' +
                ", gestiones=" + gestiones +
                '}';
    }
}

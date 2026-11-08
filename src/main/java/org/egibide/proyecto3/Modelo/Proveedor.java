package org.egibide.proyecto3.Modelo;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Proveedor")
public class Proveedor {
    @Id
    String codigo;
    String nombre;
    String apellido;
    String direccionPostal;
    @OneToMany(mappedBy = "proveedor", fetch = FetchType.LAZY)
    private List<Gestion> gestiones;

    public Proveedor(String codigo, String nombre, String apellido, String direccionPostal) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccionPostal = direccionPostal;
    }

    public Proveedor() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public List<Gestion> getGestiones() {
        return gestiones;
    }

    public void setGestiones(List<Gestion> gestiones) {
        this.gestiones = gestiones;
    }

    public String getDireccionPostal() {
        return direccionPostal;
    }

    public void setDireccionPostal(String direccionPostal) {
        this.direccionPostal = direccionPostal;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Proveedor{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", direccionPostal='" + direccionPostal + '\'' +
                ", gestiones=" + gestiones +
                '}';
    }
}

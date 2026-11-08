package org.egibide.proyecto3.Modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Proyecto {
    @Id
    String codigoProyecto;
    String nombre;
    String ciudad;
    @OneToMany(mappedBy = "proyecto", fetch = FetchType.LAZY)
    private List<Gestion> gestiones;

    public Proyecto(String codigoProyecto, String nombre, String ciudad) {
        this.codigoProyecto = codigoProyecto;
        this.nombre = nombre;
        this.ciudad = ciudad;
    }

    public Proyecto() {
    }

    public String getCodigoPoryecto() {
        return codigoProyecto;
    }

    public void setCodigoPoryecto(String codigoPoryecto) {
        this.codigoProyecto = codigoPoryecto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public List<Gestion> getGestiones() {
        return gestiones;
    }

    public void setGestiones(List<Gestion> gestiones) {
        this.gestiones = gestiones;
    }

    @Override
    public String toString() {
        return "Proyecto{" +
                "codigoPoryecto='" + codigoProyecto + '\'' +
                ", nombre='" + nombre + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", gestiones=" + gestiones +
                '}';
    }
}

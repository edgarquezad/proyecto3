package org.egibide.proyecto3.Modelo;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "gestiones")
public class Gestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Temporal(TemporalType.DATE)
    private Date fecha;
    private int cantidad;

    @ManyToOne
    @JoinColumn(name = "codigo_pieza")
    private Piezas piezas;

    @ManyToOne
    @JoinColumn(name = "codigo_proveedor")
    private Proveedor proveedor;

    @ManyToOne
    @JoinColumn(name = "codigo_proyecto")
    private Proyecto proyecto;


    public Gestion() {
    }


    public Gestion(Date fecha, int cantidad, Piezas piezas,
                   Proveedor proveedor, Proyecto proyecto) {

        this.fecha = fecha;
        this.cantidad = cantidad;
        this.piezas = piezas;
        this.proveedor = proveedor;
        this.proyecto = proyecto;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }


    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }


    public Piezas getPiezas() {
        return piezas;
    }

    public void setPiezas(Piezas piezas) {
        this.piezas = piezas;
    }


    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }


    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }


    @Override
    public String toString() {
        return "Gestion{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", cantidad=" + cantidad +
                ", piezas=" + piezas +
                ", proveedor=" + proveedor +
                ", proyecto=" + proyecto +
                '}';
    }
}
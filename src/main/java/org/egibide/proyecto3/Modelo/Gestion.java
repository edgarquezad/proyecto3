package org.egibide.proyecto3.Modelo;

import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

import java.util.Date;
import java.util.List;

public class Gestion {
    private int id;
    private Date fecha;
    private int cantidad;
    private Piezas piezas;
    private Proveedor proveedor;
    private Proyecto proyecto;
    private List<Gestion> gestiones;

@OneToMany(mappedBy = "proveedor", fetch = FetchType.LAZY)
    public List<Gestion> getGestiones() {
        return gestiones;
    }
}

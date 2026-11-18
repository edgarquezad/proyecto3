package org.egibide.proyecto3.IDao;

import org.egibide.proyecto3.Modelo.Piezas;

import java.util.List;

public interface IPiezasDao {
    Piezas buscarPorNombre(String nombrePiezas);
    List<Piezas> listarPiezas();

    List<Piezas> listarPieza(String nombre,String codigo);
}

package org.egibide.proyecto3.IDao;

import org.egibide.proyecto3.Modelo.Proyecto;

import java.util.List;

public interface IProyectoDao {
    List<Proyecto> busquedaProyecto(String codigoProyecto, String nombreProyecto, String ciudad);

}

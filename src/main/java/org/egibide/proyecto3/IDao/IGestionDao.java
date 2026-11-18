package org.egibide.proyecto3.IDao;

import org.egibide.proyecto3.Modelo.Gestion;

import java.util.Date;
import java.util.List;

public interface IGestionDao {
    List<Gestion> listarGestiones();
    boolean existeGestionPiezas(String codigo);
    boolean existeGestionProyecto(String codigo);
    boolean existeGestionProveedor(String codigo);
    List<Gestion> buscarGestion(int id, Date fecha );

}

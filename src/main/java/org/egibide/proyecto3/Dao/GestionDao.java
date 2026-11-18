package org.egibide.proyecto3.Dao;

import org.egibide.proyecto3.IDao.IGestionDao;
import org.egibide.proyecto3.Modelo.Gestion;
import org.egibide.proyecto3.Modelo.Proveedor;
import org.egibide.proyecto3.Modelo.Proyecto;

import java.util.Date;
import java.util.List;

public class GestionDao extends Dao<Gestion, Integer> implements IGestionDao {

    @Override
    public Gestion find(Integer codigo) {

        return em.find(Gestion.class, codigo);
    }

    @Override
    public List<Gestion> listarGestiones() {
        return em.createQuery("SELECT g from Gestion g", Gestion.class)
                .getResultList();
    }

    @Override
    public boolean existeGestionPiezas(String codigo) {
        return !em.createQuery("SELECT g from Gestion g where g.piezas.codigoPieza = :codigoPiezas", Gestion.class)
                .setParameter("codigoPiezas", codigo)
                .getResultList().isEmpty();
    }

    @Override
    public boolean existeGestionProyecto(String codigo) {
        return !em.createQuery("SELECT g from Gestion g where g.proyecto.codigoProyecto = :codigo", Gestion.class)
                .setParameter("codigo", codigo).
                getResultList().isEmpty();
    }

    @Override
    public boolean existeGestionProveedor(String codigo) {
        return !em.createQuery("select g from Gestion g where g.proveedor.codigo = :codigo", Gestion.class)
                .setParameter("codigo", codigo)
                .getResultList().isEmpty();
    }

    @Override
    public List<Gestion> buscarGestion(int id, Date fecha ) {
        return em.createQuery("select g from Gestion g where g.id = :id or g.fecha = :fecha ",Gestion.class)
                .setParameter("id", id)
                .setParameter("fecha", fecha)
                .getResultList();
    }
}

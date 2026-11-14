package org.egibide.proyecto3.Dao;

import org.egibide.proyecto3.IDao.IProyectoDao;
import org.egibide.proyecto3.Modelo.Proyecto;

import java.util.List;

public class ProyectoDao extends Dao<Proyecto, String> implements IProyectoDao {
    @Override
    public Proyecto find(String codigo) {
        return em.find(Proyecto.class, codigo);
    }


    @Override
    public List<Proyecto> busquedaProyecto(String codigoProyecto, String nombreProyecto, String ciudad) {
        return em.createQuery("select p from Proyecto p " +
                        "where p.nombre = :nombre or p.codigoProyecto =:codigoProyecto or p.ciudad=:ciudad", Proyecto.class)
                .setParameter("nombre", nombreProyecto)
                .setParameter("codigoProyecto", codigoProyecto)
                .setParameter("ciudad", ciudad)
                .getResultList();
    }
}

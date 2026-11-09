package org.egibide.proyecto3.Dao;

import org.egibide.proyecto3.Modelo.Proyecto;

public class ProyectoDao extends Dao<Proyecto,String> {
    @Override
    public Proyecto find(String codigo) {
        return em.find(Proyecto.class, codigo);
    }
}

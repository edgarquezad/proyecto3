package org.egibide.proyecto3.Dao;

import org.egibide.proyecto3.Modelo.Gestion;

public class GestionDao extends Dao <Gestion,Integer> {

    @Override
    public Gestion find(Integer codigo) {
        return em.find(Gestion.class, codigo);
    }
}

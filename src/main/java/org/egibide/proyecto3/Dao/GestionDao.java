package org.egibide.proyecto3.Dao;

import org.egibide.proyecto3.IDao.IGestionDao;
import org.egibide.proyecto3.Modelo.Gestion;

import java.util.List;

public class GestionDao extends Dao <Gestion,Integer>implements IGestionDao {

    @Override
    public Gestion find(Integer codigo) {

        return em.find(Gestion.class, codigo);
    }

    @Override
    public List<Gestion> listarGestiones() {
        return em.createQuery("SELECT g from Gestion g",Gestion.class)
                .getResultList();
    }
}

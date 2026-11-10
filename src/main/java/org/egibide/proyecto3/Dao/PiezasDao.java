package org.egibide.proyecto3.Dao;

import org.egibide.proyecto3.IDao.IPiezasDao;
import org.egibide.proyecto3.Modelo.Piezas;

import java.util.List;

public class PiezasDao extends Dao <Piezas,String> implements IPiezasDao {

    @Override
    public Piezas find(String codigo) {
        Piezas pieza = em.find(Piezas.class,codigo);
        return pieza;
    }

    @Override
    public List<Piezas> listarPiezas() {
        return em.createQuery("select p from Piezas p",Piezas.class).getResultList();
    }
}

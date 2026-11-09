package org.egibide.proyecto3.Dao;

import org.egibide.proyecto3.Modelo.Piezas;

public class PiezasDao extends Dao <Piezas,String> {

    @Override
    public Piezas find(String codigo) {
        Piezas pieza = em.find(Piezas.class,codigo);
        return pieza;
    }
}

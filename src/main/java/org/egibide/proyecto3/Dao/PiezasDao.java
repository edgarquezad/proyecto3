package org.egibide.proyecto3.Dao;

import org.egibide.proyecto3.IDao.IPiezasDao;
import org.egibide.proyecto3.Modelo.Piezas;

import java.util.List;

public class PiezasDao extends Dao<Piezas, String> implements IPiezasDao {

    @Override
    public Piezas find(String codigo) {
        return em.find(Piezas.class, codigo);
    }

    @Override
    public Piezas buscarPorNombre(String nombrePiezas) {
        return em.createQuery("select  p from  Piezas p where p.nombre= :nombre", Piezas.class)
                .setParameter("nombre", nombrePiezas)
                .setMaxResults(1)
                .getResultList()
                .stream()
                .findFirst()
                .orElse(null);

    }

    @Override
    public List<Piezas> listarPiezas() {
        return em.createQuery("select p from Piezas p", Piezas.class).getResultList();
    }

    @Override
    public List<Piezas> listarPieza(String nombre, String codigo) {
        return em.createQuery("select p from Piezas p " +
                                "where p.nombre =:nombre OR p.codigoPieza = :codigoP",
                        Piezas.class)
                .setParameter("nombre", nombre)
                .setParameter("codigoP", codigo)

                .getResultList();


    }
}

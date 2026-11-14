package org.egibide.proyecto3.Dao;

import org.egibide.proyecto3.IDao.IProveedorDao;
import org.egibide.proyecto3.Modelo.Proveedor;

import java.util.List;

public class ProveedorDao extends Dao<Proveedor, String> implements IProveedorDao {
    @Override
    public Proveedor find(String codigo) {
        return em.find(Proveedor.class, codigo);


    }

    @Override
    public List<Proveedor> buscarPorNombre(String nombre) {
        return em.createQuery("select p from Proveedor p where nombre = :nombre", Proveedor.class)
                .setParameter("nombre", nombre).getResultList();
    }

    @Override
    public List<Proveedor> obtenerTodos() {
        return em.createQuery("SELECT proveedor FROM Proveedor proveedor", Proveedor.class).getResultList();
    }

    @Override
    public List<Proveedor> buscarPorDireccion(String direccionPostal) {
        return em.createQuery("SELECT p from Proveedor p where direccionPostal = :direccionP",Proveedor.class)
                .setParameter("direccionP", direccionPostal).getResultList();
    }

    @Override
    public List<Proveedor> buscar(String direccionPostal, String nombre, String codigo) {
        return em.createQuery("SELECT p from Proveedor p " +
                        "where direccionPostal = :direccionP or nombre=:nombre or codigo =:codigo",
                        Proveedor.class)
                .setParameter("direccionP", direccionPostal)
                .setParameter("nombre", nombre)
                .setParameter("codigo", codigo)
                .getResultList();
    }

}

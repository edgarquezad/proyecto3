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
        return List.of();
    }

    @Override
    public List<Proveedor> obtenerTodos() {
        return em.createQuery("SELECT proveedor FROM Proveedor proveedor", Proveedor.class).getResultList();
    }

    @Override
    public List<Proveedor> buscarPorDireccion(String direccion) {
        return List.of();
    }

}

package org.egibide.proyecto3.IDao;

import org.egibide.proyecto3.Modelo.Proveedor;

import java.util.List;

public interface IProveedorDao {
    Proveedor find(String codigo);

    List<Proveedor> buscarPorNombre(String nombre);
    List<Proveedor> obtenerTodos();

    List<Proveedor> buscarPorDireccion(String direccion);
}

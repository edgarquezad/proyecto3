package org.egibide.proyecto3.Metodos.MG;

import org.egibide.proyecto3.Dao.ProveedorDao;
import org.egibide.proyecto3.Modelo.Proveedor;

import java.util.List;

public class ProveedorMt {

    public List<Proveedor> listaProveedores(){
        ProveedorDao proveedorDao = new ProveedorDao();

        return proveedorDao.obtenerTodos();
    }

    public List<Proveedor> buscarProveedor(String buscar){
        ProveedorDao proveedorDao = new ProveedorDao();

        return proveedorDao.buscar(buscar,buscar,buscar);
    }
}

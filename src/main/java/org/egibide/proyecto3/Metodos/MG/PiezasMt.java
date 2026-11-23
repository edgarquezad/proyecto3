package org.egibide.proyecto3.Metodos.MG;

import org.egibide.proyecto3.Dao.PiezasDao;
import org.egibide.proyecto3.Modelo.Piezas;
import org.hibernate.query.sqm.tuple.internal.AnonymousTupleBasicValuedModelPart;

import java.util.List;

public class PiezasMt {
    //Buscar piezas
    public void  guardarPiezas(Piezas piezas) {
        PiezasDao piezasDao = new PiezasDao();
        piezasDao.create(piezas);

    }
    public void editarPiezas(Piezas piezas) {
        PiezasDao piezasDao = new PiezasDao();
        piezasDao.update(piezas);
    }

    public List<Piezas> buscarPiezas(String buscar) {
        PiezasDao piezasDao = new PiezasDao();
        return piezasDao.listarPieza(buscar,buscar);
    };

    public List<Piezas> listarPiezas() {
        PiezasDao piezasDao = new PiezasDao();

        return piezasDao.listarPiezas();
    }

    public void eliminarPiezas(Piezas piezas) {
        PiezasDao piezasDao = new PiezasDao();
        Piezas piezaEliminar = piezasDao.find(piezas.getCodigoPieza());
        piezasDao.delete(piezaEliminar);


    }

    public boolean comprobar(String codigo) {
        PiezasDao piezasDao = new PiezasDao();
        Piezas piezas =piezasDao.find(codigo);
        return piezas != null; //devulve true

    }



}

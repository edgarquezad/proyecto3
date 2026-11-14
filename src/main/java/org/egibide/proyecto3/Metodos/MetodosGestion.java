package org.egibide.proyecto3.Metodos;

import org.egibide.proyecto3.Dao.GestionDao;
import org.egibide.proyecto3.Dao.PiezasDao;
import org.egibide.proyecto3.Dao.ProveedorDao;
import org.egibide.proyecto3.Dao.ProyectoDao;
import org.egibide.proyecto3.Modelo.Gestion;
import org.egibide.proyecto3.Modelo.Piezas;
import org.egibide.proyecto3.Modelo.Proveedor;
import org.egibide.proyecto3.Modelo.Proyecto;

import java.util.Date;
import java.util.Scanner;

public class MetodosGestion {
    public static void agregarGestion(Scanner scanner) {
        GestionDao gestionDao = new GestionDao();
        ProveedorDao proveedorDao = new ProveedorDao();
        PiezasDao piezasDao = new PiezasDao();
        ProyectoDao proyectoDao = new ProyectoDao();


        System.out.println("Fecha de creacion:");
        Date fecha = new Date();

        System.out.println("Cantidad : ");
        int cantidad = Validaciones.validarCantidad(scanner);

        System.out.println("Codigo Proveedor:");
        String codigoProveedor = scanner.nextLine();
        Proveedor proveedor =proveedorDao.find(codigoProveedor);

                System.out.println("Codigo Piezas:");
        String codigoPiezas = scanner.nextLine();
        Piezas piezas = piezasDao.find(codigoPiezas);

        System.out.println("Codigo Proyecto:");
        String codigoProyecto = scanner.nextLine();
        Proyecto proyecto = proyectoDao.find(codigoProyecto);

        Gestion gestion = new Gestion(fecha, cantidad, piezas, proveedor, proyecto);

        gestionDao.create(gestion);


    }
}

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
import java.util.List;
import java.util.Scanner;

public class MetodosGestion {

    public static void altaGestion(Scanner scanner) {
        GestionDao gestionDao = new GestionDao();
        ProveedorDao proveedorDao = new ProveedorDao();
        PiezasDao piezasDao = new PiezasDao();
        ProyectoDao proyectoDao = new ProyectoDao();

        Date fecha = new Date();

        System.out.println("Cantidad : ");
        int cantidad = Validaciones.validarCantidad(scanner);

        System.out.println("Codigo Proveedor:");
        String codigoProveedor = scanner.nextLine();
        Proveedor proveedor = proveedorDao.find(codigoProveedor);

        System.out.println("Codigo Piezas:");
        String codigoPiezas = scanner.nextLine();
        Piezas piezas = piezasDao.find(codigoPiezas);

        System.out.println("Codigo Proyecto:");
        String codigoProyecto = scanner.nextLine();
        Proyecto proyecto = proyectoDao.find(codigoProyecto);

        if (proyecto != null && piezas != null && proveedor != null) {
            Gestion gestion = new Gestion(fecha, cantidad, piezas, proveedor, proyecto);
            gestionDao.create(gestion);
            System.out.println("Gestion agregado correctamente");
        } else {
            if (proveedor == null) {
                System.out.println("Proyecto con codigo " + codigoProveedor + " no encontrado:");
            }
            if (piezas == null) {
                System.out.println("Piezas con codigo " + codigoPiezas + " no encontrado");
            }
            if (proyecto == null) {
                System.out.println("Proyecto con codigo " + codigoProyecto + " no encontrado");
            }
        }

    }

    public static void eliminarGestion(Scanner scanner) {
        GestionDao gestionDao = new GestionDao();
        System.out.println("Id de gestion: ");
        int codigoGestion = scanner.nextInt();

        Gestion gestion = gestionDao.find(codigoGestion);
        if (gestion != null) {
            gestionDao.delete(gestion);
        } else {
            System.out.println("Gestion no encontrado");
        }

    }

    public static void mostrarGestion(Scanner scanner) {
        GestionDao gestionDao = new GestionDao();
        List<Gestion> gestiones = gestionDao.listarGestiones();
        if (!gestiones.isEmpty()) {
            for (Gestion g : gestiones) {
                System.out.println(g);

            }

        } else {
            System.out.println("Gestion no encontrado");
        }
    }
}


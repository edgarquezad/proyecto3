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
            System.out.println("Gestión agregada correctamente");
        } else {
            if (proveedor == null) {
                System.out.println("Proveedor con codigo " + codigoProveedor + " no encontrado:");
            }
            if (piezas == null) {
                System.out.println("Pieza con código... " + codigoPiezas + " no encontradq");
            }
            if (proyecto == null) {
                System.out.println("Proyecto con codigo " + codigoProyecto + " no encontrado");
            }
        }

    }

    public static void eliminarGestion(Scanner scanner) {
        GestionDao gestionDao = new GestionDao();
        int codigoGestion = Validaciones.validarID(scanner);

        Gestion gestion = gestionDao.find(codigoGestion);
        if (gestion != null) {
            gestionDao.delete(gestion);
            System.out.println("\nGestion eliminada correctamente");
        } else {
            System.out.println("\nGestion no encontrado");
        }

    }

    public static void mostrarGestion() {
        GestionDao gestionDao = new GestionDao();
        List<Gestion> gestiones = gestionDao.listarGestiones();
        if (gestiones != null && !gestiones.isEmpty()) {
            for (Gestion g : gestiones) {
                System.out.println(
                        "\nID: " + g.getId() +
                                "\nFecha: " + g.getFecha() +
                                "\nCantidad: " + g.getCantidad() +
                                "\nPieza: " + g.getPiezas().getNombre() +
                                "\nProveedor: " + g.getProveedor().getNombre() +
                                "\nProyecto: " + g.getProyecto().getNombre()
                );
                System.out.println();
            }

        } else {
            System.out.println("Gestion no encontrado");
        }
    }


    public static void buscarGestion(Scanner scanner) {
        GestionDao gestionDao = new GestionDao();
        System.out.println("Id de gestion: ");
        try {
            int codigoGestion = Integer.parseInt(scanner.nextLine());
            Gestion gestion = gestionDao.find(codigoGestion);

            if (gestion != null) {
                System.out.println("Fecha: " + gestion.getFecha() +
                        "\nCantidad: " + gestion.getCantidad() +
                        "\nId: " + gestion.getId() +
                        "\nProvedor: " + gestion.getProveedor().getNombre() +
                        "\nProyecto: " + gestion.getProyecto().getNombre() +
                        "\nPieza: " + gestion.getPiezas().getNombre()

                );

            } else {
                System.out.println("Gestion no encontrada");

            }
        } catch (NumberFormatException e) {
            System.out.println("Introduce un ID válido");
        }

    }

    public static void modificarGestion(Scanner scanner) {
        GestionDao gestionDao = new GestionDao();
        ProyectoDao proyectoDao = new ProyectoDao();
        ProveedorDao proveedorDao = new ProveedorDao();
        PiezasDao piezasDao = new PiezasDao();

        System.out.println("\nGestiones disponibles:");
        for (Gestion g : gestionDao.listarGestiones()) {
            System.out.println("ID: " + g.getId()
            );
        }

        int idGestion = Validaciones.validarID(scanner);

        Gestion gestion = gestionDao.find(idGestion);

        boolean modificarCantidad = false;
        boolean modificarProveedor = false;
        boolean modificarProyecto = false;
        boolean modificarPiezas = false;

        if (gestion != null) {
            System.out.println(
                    "\nFecha: " + gestion.getFecha()
                            + "\nCantidad: " + gestion.getCantidad()
                            + "\nProveedor: " + gestion.getProveedor().getNombre()
                            + "\nPiezas : " + gestion.getPiezas().getNombre()
                            + "\nProyecto: " + gestion.getProyecto().getNombre() + "\n"
            );
            System.out.println();
            System.out.println("\nProveedores disponibles:");
            for (Proveedor p : proveedorDao.obtenerTodos()) {
                System.out.println("Nombre: " + p.getNombre()
                );

            }

            System.out.println("\nModificar proveedor o Enter para continuar:");
            String nombreProveedor = scanner.nextLine();

            if (!nombreProveedor.isEmpty()) {
                Proveedor provedores = proveedorDao.buscarPorNombre(nombreProveedor);

                if (provedores != null) {
                    gestion.setProveedor(provedores);
                    modificarProveedor = true;
                    System.out.println("Se ha modificado el proveedor");
                } else {
                    System.out.println("Proveedor no encontrado");
                }
            }


            System.out.println("\nProyectos disponibles:");
            for (Proyecto p : proyectoDao.obtenerProyectos()) {
                System.out.println("Nombre: " + p.getNombre());
            }

            System.out.println("\nModificar proyecto o Enter para continuar: ");
            String nombreProyecto = scanner.nextLine();

            if (!nombreProyecto.isEmpty()) {
                Proyecto proyecto = proyectoDao.buscarPorNombre(nombreProyecto);

                if (proyecto != null) {
                    gestion.setProyecto(proyecto);
                    modificarProyecto = true;
                    System.out.println("Se ha modificado el proyecto");
                } else {
                    System.out.println("Proyecto no encontrado");
                }
            }

            System.out.println("\nPiezas disponibles:");
            for (Piezas p : piezasDao.listarPiezas()) {
                System.out.println("Nombre pieza: " + p.getNombre()
                );
            }

            System.out.println("\nModificar pieza o Enter para continuar: ");
            String nombrePiezas = scanner.nextLine();

            if (!nombrePiezas.isEmpty()) {
                Piezas piezas = piezasDao.buscarPorNombre(nombrePiezas);

                if (piezas != null) {
                    gestion.setPiezas(piezas);
                    modificarPiezas = true;
                    System.out.println("Se ha modificado la pieza");
                } else {
                    System.out.println("Pieza no encontrada");
                }
            }

            System.out.println("Modificar cantidad o Enter para continuar: ");
            String nuevaCantidad = scanner.nextLine();

            if (!nuevaCantidad.isEmpty()) {
                try {
                    int cantidad = Integer.parseInt(nuevaCantidad);

                    if (cantidad > 0) {
                        gestion.setCantidad(cantidad);
                        modificarCantidad = true;
                        System.out.println("Se ha modificado la cantidad");
                    } else {
                        System.out.println("La cantidad debe ser mayor que cero");
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Cantidad no válida");
                }
            }

            if (modificarCantidad || modificarProveedor || modificarProyecto || modificarPiezas) {
                gestionDao.update(gestion);
                System.out.println("Gestión modificada correctamente");
            } else {
                System.out.println("No se han realizado modificaciones");
            }

        } else {
            System.out.println("Gestión no encontrada");
        }
    }
}


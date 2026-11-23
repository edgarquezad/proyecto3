package org.egibide.proyecto3.Metodos;

import org.egibide.proyecto3.Dao.GestionDao;
import org.egibide.proyecto3.Dao.PiezasDao;
import org.egibide.proyecto3.Modelo.Gestion;
import org.egibide.proyecto3.Modelo.Piezas;
import org.hibernate.tool.schema.internal.exec.ScriptTargetOutputToUrl;

import java.util.List;
import java.util.Scanner;

public class MetodosPiezas {

    public static void agregarPiezas(Scanner scanner) {
        PiezasDao piezasDao = new PiezasDao();

        System.out.println("Codigo de pieza: ");
        String codigoPieza = scanner.nextLine().toLowerCase();
        Piezas piezas = piezasDao.find(codigoPieza);

        if (piezas != null) {
            System.out.println("Pieza: " + piezas.getCodigoPieza() + " ya existe");
        } else {
            System.out.println("Nombre de pieza: ");
            String nombrePieza = scanner.nextLine();

            double precioPieza = Validaciones.validarPrecio(scanner);

            System.out.println("Descripcion: ");
            String descripcionPieza = scanner.nextLine();

            if (!codigoPieza.isEmpty() && !descripcionPieza.isEmpty() && precioPieza > 0 && !nombrePieza.isEmpty()) {
                piezas = new Piezas(codigoPieza, nombrePieza, precioPieza, descripcionPieza);
                piezasDao.create(piezas);
                System.out.println("Pieza agregada correctamente");
            } else {
                if (precioPieza <= 0) {
                    System.out.println("El precio debe ser mayor a cero");
                    System.out.println();
                } else {
                    System.out.println("Todos los campos son necesarios , pieza no guardada");
                    System.out.println();

                }
            }


        }


    }

    public static void eliminarPiezas(Scanner scanner) {
        PiezasDao piezasDao = new PiezasDao();
        GestionDao gestionDao = new GestionDao();

        System.out.print("Introduce codigo de pieza a eliminar: ");
        String codigoPiezas = scanner.nextLine().toLowerCase();

        Piezas piezas = piezasDao.find(codigoPiezas);
        if (piezas != null) {

            if (gestionDao.existeGestionPiezas(codigoPiezas)) {
                System.out.println("No se puede eliminar " + codigoPiezas + " existe una gestion actualmente ");
            } else {
                piezasDao.delete(piezas);
                System.out.println("Pieza eliminada correctamente " + codigoPiezas);
            }
        } else {
            System.out.println("Piezas no encontrada");
        }

    }

    public static void mostrarPiezas() {
        PiezasDao piezasDao = new PiezasDao();

        List<Piezas> listaPiezas = piezasDao.listarPiezas();
        if (listaPiezas == null || listaPiezas.isEmpty()) {
            System.out.println("No existen piezas disponibles");

        } else {
            for (Piezas piezas : listaPiezas) {
                System.out.println(
                        "\nCodigo pieza: " + piezas.getCodigoPieza() +
                                "\nNombre: " + piezas.getNombre() +
                                "\nPrecio: " + piezas.getPrecio() +
                                "\nDescripcion: " + piezas.getDescripcion()
                );
                System.out.println();
                if (piezas.getGestiones().isEmpty()) {
                    System.out.println("No esta asociado a ninguna gestion ");
                }else {
                    for (Gestion gestion : piezas.getGestiones()) {
                        System.out.println("ID Gestión: " + gestion.getId() +
                                " - Cantidad: " + gestion.getCantidad());
                    }

                }

            }
        }
    }

    public static void modificarPiezas(Scanner scanner) {
        PiezasDao piezasDao = new PiezasDao();

        System.out.println("Codigo de pieza a modificar: ");
        String codigoPiezas = scanner.nextLine().toLowerCase();
        Piezas pieza = piezasDao.find(codigoPiezas);
        boolean nombreModificado = false;
        boolean precioModificado = false;
        boolean descripcionModificado = false;


        if (pieza != null) {
            System.out.println("Pieza encontrada " +
                    "\nNombre: " + pieza.getNombre() +
                    "\nCodigoPieza: " + pieza.getCodigoPieza()

            );

            System.out.println("Modificar Nombre o pulsa enter para continuar  ");
            String nuevoNombre = scanner.nextLine();
            if (!nuevoNombre.isEmpty()) {
                pieza.setNombre(nuevoNombre);
                nombreModificado = true;
            }

            System.out.println("Modificar Precio o enter para continuar: ");
            String nuevoPrecio = scanner.nextLine();

            if (!nuevoPrecio.isEmpty()) {
                try {
                    double precio = Double.parseDouble(nuevoPrecio);
                    if (precio > 0) {
                        pieza.setPrecio(precio);
                        precioModificado = true;
                    } else {
                        System.out.println("Precio inválido. Se mantiene el precio anterior.");
                    }
                }catch (NumberFormatException e) {
                    System.out.println("Introduce un precio valido");
                }

            }
            System.out.println("Modificar Descripcion o enter para continuar ");
            String nuevoDescripcion = scanner.nextLine();

            if (!nuevoDescripcion.isEmpty()) {
                pieza.setDescripcion(nuevoDescripcion);
                descripcionModificado = true;
            }
            if (nombreModificado || precioModificado || descripcionModificado) {
                System.out.println("Actualizado correctamente" + " -Nombre: " + pieza.getNombre() + " Precio: " + pieza.getPrecio() + " -Descripcion: " + pieza.getDescripcion());
                piezasDao.update(pieza);
            } else {
                System.out.println("No se ha modificado ningún dato.");
            }


        } else {
            System.out.println("Pieza no encontrada no se puede modificar");
        }
    }

    public static void buscarPiezas(Scanner scanner) {
        PiezasDao piezasDao = new PiezasDao();

        System.out.println("Nombre o codigo de pieza a buscar: ");
        String busqueda = scanner.nextLine().toLowerCase();
        List<Piezas> piezas = piezasDao.listarPieza(busqueda, busqueda);

        if (piezas != null && !piezas.isEmpty()) {
            for (Piezas pieza : piezas) {
                System.out.println("Codigo: " + pieza.getCodigoPieza());
                System.out.println("Nombre: " + pieza.getNombre());
                System.out.println("Precio: " + pieza.getPrecio());
                System.out.println("Descripcion: " + pieza.getDescripcion());
                System.out.println();
            }
        } else {
            System.out.println("No se encontro ninguna pieza con los datos introducidos \n");

        }

    }

}

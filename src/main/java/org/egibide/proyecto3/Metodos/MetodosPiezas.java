package org.egibide.proyecto3.Metodos;

import org.egibide.proyecto3.Dao.PiezasDao;
import org.egibide.proyecto3.Modelo.Piezas;

import java.util.List;
import java.util.Scanner;

import static org.egibide.proyecto3.Modelo.Menus.validarPrecio;

public class MetodosPiezas {
    public static void agregarPiezas(Scanner scanner) {
        PiezasDao piezasDao = new PiezasDao();
        System.out.println("----Agregar piezas----");
        System.out.println("Codigo de piezas");
        String codigoPiezas = scanner.nextLine();
        if (!piezasDao.listarPiezas().isEmpty()) {
            for (Piezas piezas : piezasDao.listarPiezas()) {
                if (piezas.getCodigoPieza().equals(codigoPiezas)) {
                    System.out.println("Codigo de piezas ya existe");
                } else {
                    System.out.println("Nombre: ");
                    String nombrePiezas = scanner.nextLine();

                    double precioPiezas = validarPrecio(scanner);

                    System.out.println("Descripcion: ");
                    String descripcionPiezas = scanner.nextLine();


                    piezas = new Piezas(codigoPiezas, nombrePiezas, precioPiezas, descripcionPiezas);
                    piezasDao.create(piezas);
                    System.out.println("Piezas agregadas correctamente ");

                }
            }

        }

    }

    public static void eliminarPiezas(Scanner scanner) {
        PiezasDao piezasDao = new PiezasDao();

        if (!piezasDao.listarPiezas().isEmpty()) {
            for (Piezas piezas : piezasDao.listarPiezas()) {
                System.out.println("Piezas existentes " +
                        "\nCodigo pieza : " + piezas.getCodigoPieza()
                        + "\nNombre : " + piezas.getNombre()
                );
            }
            System.out.print("Introduce codigo de pieza a eliminar: ");
            String codigoPiezas = scanner.nextLine();

            Piezas piezas = piezasDao.find(codigoPiezas);
            if (piezas != null) {
                piezasDao.delete(piezas);
                System.out.println("Piezas eliminadas correctamente ");
            }else {
                System.out.println("Piezas no encontrada");
            }


        } else {
            System.out.println("No hay piezas disponibles para eliminar ");
        }

    }

    public static void mostrarPiezas(Scanner scanner) {
        PiezasDao piezasDao = new PiezasDao();
        List<Piezas> listaPiezas = piezasDao.listarPiezas();
        if (listaPiezas.isEmpty()) {
            System.out.println("No existen piezas disponibles");
        } else {
            for (Piezas listaPieza : listaPiezas) {
                System.out.println(
                        "Codigo pieza: " + listaPieza.getCodigoPieza() +
                                "\nNombre: " + listaPieza.getNombre() +
                                "\nPrecio: " + listaPieza.getPrecio() +
                                "\nGesiones: " + listaPieza.getGestiones()
                );
            }
        }
    }

    public static void modificarPiezas(Scanner scanner) {
        PiezasDao piezasDao = new PiezasDao();
        System.out.println("Codigo de pieza a modificar: ");
        String codigoPiezas = scanner.nextLine();
        Piezas pieza = piezasDao.find(codigoPiezas);

        if (pieza != null) {
            System.out.println("Pieza encontrada \n" +
                    "Nombre: " + pieza.getNombre());
            System.out.println("Modificar Nombre o pulsa enter para continuar  ");
            String nuevoNombre = scanner.nextLine();
            if (!nuevoNombre.isEmpty()) {
                pieza.setNombre(nuevoNombre);
            }

            System.out.println("Modificar Precio o enter para continuar : ");
            Double nuevoPrecioPiezas = validarPrecio(scanner);
            if (nuevoPrecioPiezas != null) {
                pieza.setPrecio(nuevoPrecioPiezas);

            }


            System.out.println("Modificar Descripcion o enter para continuar ");
            String nuevoDescripcion = scanner.nextLine();
            if (!nuevoDescripcion.isEmpty()) {
                pieza.setDescripcion(nuevoDescripcion);
            }

            piezasDao.update(pieza);
            System.out.println("Piezas actualizadas correctamente");

        } else {
            System.out.println("Pieza no encontrada no se puede modificar");
        }


    }

    public static void buscarPiezas(Scanner scanner) {
        PiezasDao piezasDao = new PiezasDao();

        System.out.println("Nombre o codigo de pieza a buscar: ");
        String busqueda = scanner.nextLine();
        List<Piezas> piezas = piezasDao.listarPieza(busqueda, busqueda);

        if (!piezas.isEmpty()) {
            for (Piezas pieza : piezas) {
                System.out.println(pieza.getNombre());
                System.out.println(pieza.getPrecio());
            }
        } else {
            System.out.println("No se encontro ninguna pieza con los datos introducidos ");
        }


    }

}

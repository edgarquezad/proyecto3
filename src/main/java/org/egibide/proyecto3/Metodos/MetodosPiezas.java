package org.egibide.proyecto3.Metodos;

import org.egibide.proyecto3.Dao.PiezasDao;
import org.egibide.proyecto3.Modelo.Piezas;

import java.util.Scanner;

import static org.egibide.proyecto3.Modelo.Menus.validarEnteros;

public class MetodosPiezas {
    public static void AgregarPiezas(Scanner scanner) {
        PiezasDao piezasDao = new PiezasDao();
        System.out.println("----Agregar piezas----");
        System.out.println("Codigo de piezas");
        String codigoPiezas = scanner.nextLine();
        if(!piezasDao.listarPiezas().isEmpty()){
            for (Piezas piezas : piezasDao.listarPiezas()) {
                if (piezas.getCodigoPieza().equals(codigoPiezas)) {
                    System.out.println("Codigo de piezas ya existe");
                }else {
                    System.out.println("Nombre: ");
                    String nombrePiezas = scanner.nextLine();

                    double precioPiezas = validarEnteros(scanner);

                    System.out.println("Descripcion: ");
                    String descripcionPiezas = scanner.nextLine();


                   piezas = new Piezas(codigoPiezas, nombrePiezas, precioPiezas, descripcionPiezas);



                    piezasDao.create(piezas);
                    System.out.println("Piezas agregadas correctamente ");

                }
            }


        }




    }

    public static void EliminarPiezas(Scanner scanner) {
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
            if (piezas.getCodigoPieza().equals(codigoPiezas)) {
                piezasDao.delete(piezas);
                System.out.println("Piezas eliminadas correctamente");
            } else {
                System.out.println("Piezas no existe");

            }

        } else {
            System.out.println("No hay piezas disponibles para eliminar ");
        }


    }
}

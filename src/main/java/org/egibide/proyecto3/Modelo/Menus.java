package org.egibide.proyecto3.Modelo;

import org.egibide.proyecto3.Metodos.MetodosPiezas;
import org.egibide.proyecto3.Metodos.MetodosProveedor;

import java.util.Scanner;

public class Menus {

    public static void MenuProveedores(Scanner scanner) {
        int opcion;
        do {
            System.out.println("""
                      1-Agregar proveedores
                      2-Eliminar proveedores
                      3-Modificar proveedores
                      4-Buscar proveedores
                      5-mostrar proveedores
                      0-volver Menu
                    \s""");

            opcion = validarOpciones(scanner);
            switch (opcion) {
                case 1:
                    MetodosProveedor.agregarProveedores(scanner);
                    break;
                case 2:
                    MetodosProveedor.eliminarProveedores(scanner);
                    break;
                case 3:
                    MetodosProveedor.ModificarProveedores(scanner);
                    break;
                case 4:
                    break;
                case 5:
                    MetodosProveedor.listarProveedores(scanner);
            }

        } while (opcion != 0);


    }

    public static void MenuGestionPiezas(Scanner scanner) {
        int seleccion;
        do {
            System.out.println("""
                    1-Agregar piezas
                    2-Eliminar piezas
                    3-Modificar piezas
                    4-Buscar piezas
                    5-mostrar piezas
                    0-volver Menu
                    """);
            seleccion = validarOpciones(scanner);
            switch (seleccion) {
                case 1:
                    MetodosPiezas.AgregarPiezas(scanner);
                    break;
                case 2:
                    MetodosPiezas.EliminarPiezas(scanner);



            }


        } while (seleccion != 0);
    }


    public static int validarOpciones(Scanner scanner) {
        int opcion = 0;
        boolean opcionValida = false;
        while (!opcionValida) {
            try {
                System.out.println("Seleccione una opcion: ");
                opcion = Integer.parseInt(scanner.nextLine());
                opcionValida = true;

            } catch (NumberFormatException e) {
                System.out.println("Opcion no valida");
            }


        }
        return opcion;


    }

    public static double validarEnteros(Scanner scanner) {
        double opcion = 0;
        boolean opcionValida = false;
        while (!opcionValida) {
            try {
                System.out.println("Ingrese precio : ");
                opcion = Double.parseDouble(scanner.nextLine());
                opcionValida = true;

            } catch (NumberFormatException e) {
                System.out.println("Formato no valido ... ");

            }


        }
        return  opcion;


    }
}

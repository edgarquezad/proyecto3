package org.egibide.proyecto3.Modelo;

import org.egibide.proyecto3.Metodos.*;

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
            System.out.println("seleccione una opcion:");

            opcion = Validaciones.validarOpciones(scanner);

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
                    MetodosProveedor.buscarProveedores(scanner);
                    break;
                case 5:
                    MetodosProveedor.listarProveedores(scanner);
                    break;
            }

        } while (opcion != 0);

    }

    public static void MenuPiezas(Scanner scanner) {
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
            System.out.println("seleccione una opcion:");

            seleccion = Validaciones.validarOpciones(scanner);

            switch (seleccion) {
                case 1:
                    MetodosPiezas.agregarPiezas(scanner);
                    break;
                case 2:
                    MetodosPiezas.eliminarPiezas(scanner);
                    break;
                case 3:
                    MetodosPiezas.modificarPiezas(scanner);
                    break;
                case 4:
                    MetodosPiezas.buscarPiezas(scanner);
                    break;
                case 5:
                    MetodosPiezas.mostrarPiezas();
                    break;

            }

        } while (seleccion != 0);
    }

    public static void MenuProyectos(Scanner scanner) {
        int opcion;
        do {
            System.out.println("""
                            1-Agregar proyectos
                            2-Eliminar proyectos
                            3-Modificar proyectos
                            4-Buscar proyectos
                            5-mostrar proyectos
                            0-volver Menu
                    """);
            System.out.println("seleccione una opcion:");

            opcion = Validaciones.validarOpciones(scanner);
            switch (opcion) {
                case 1:
                    MetodosProyecto.agregarProyecto(scanner);
                    break;
                case 2:
                    MetodosProyecto.eliminarProyecto(scanner);
                    break;
                case 3:
                    MetodosProyecto.modificarProyecto(scanner);
                    break;
                case 4:
                    MetodosProyecto.buscarProyecto(scanner);
                    break;

            }


        } while (opcion != 0);
    }
    public static void MenuGestion(Scanner scanner) {
        int opcion;
        do {
            System.out.println("""
                            1-Agregar Gestion 
                            2-Eliminar Gestion
                            3-Modificar Gestion
                            4-Buscar Gestion
                            5-mostrar Gestion
                            0-volver Menu
            """);
            System.out.println("seleccione una opcion:");
            opcion = Validaciones.validarOpciones(scanner);
            switch (opcion) {
                case 1:
                    MetodosGestion.altaGestion(scanner);
                    break;
                case 2:
                    MetodosGestion.eliminarGestion(scanner);
                    break;
                case 5:
                    MetodosGestion.mostrarGestion(scanner);
            }
        }while (opcion != 0);

    }

}

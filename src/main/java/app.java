import org.egibide.proyecto3.Metodos.MetodosProveedor;

import java.util.Scanner;

public class app {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println(""" 
                    1-Gestion de proveedores
                    2-Gestion de piezas
                    3-Gestion de proyectos
                    4-Gestion de Suministros
                    0-Salir
                    """);
            opcion = validarOpciones(scanner);


            switch (opcion) {
                case 1:
                    MenuProveedores(scanner);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 0:
                    System.out.println("El programa finaliza");
                default:
                    break;
            }


        } while (opcion != 0);


    }

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
        scanner.close();

    }


    public static int validarOpciones(Scanner scanner) {
        int opcion = 0;
        boolean opcionValida = false;
        while (!opcionValida) {
            try {
                System.out.println("Ingrese una opcion: ");
                opcion = Integer.parseInt(scanner.nextLine());
                opcionValida = true;

            } catch (NumberFormatException e) {
                System.out.println("Opcion no valida");
            }


        }
        return opcion;


    }
}

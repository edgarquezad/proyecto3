import org.egibide.proyecto3.Metodos.Validaciones;
import org.egibide.proyecto3.Modelo.Menus;

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
            System.out.println("Seleccione una opcion: ");
            opcion = Validaciones.validarOpciones(scanner);

            switch (opcion) {
                case 1:
                    Menus.MenuProveedores(scanner);
                    break;
                case 2:
                    Menus.MenuGestionPiezas(scanner);
                    break;
                case 3:
                    Menus.MenuProyectos(scanner);

                case 4:

                case 0:
                    System.out.println("El programa finaliza");
                default:
                    break;
            }


        } while (opcion != 0);


    }
}

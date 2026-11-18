package org.egibide.proyecto3.Metodos;

import org.hibernate.query.IllegalNamedQueryOptionsException;

import java.net.IDN;
import java.util.Scanner;

public class Validaciones {
    public static int validarOpciones(Scanner scanner) {
        int opcion = 0;
        boolean opcionValida = false;
        while (!opcionValida) {
            try {
                opcion = Integer.parseInt(scanner.nextLine());
                opcionValida = true;

            } catch (NumberFormatException e) {
                System.out.println("Opcion no valida");
            }

        }
        return opcion;
    }

    public static Double validarPrecio(Scanner scanner) {
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
        return opcion;
    }
    public static int validarCantidad(Scanner scanner) {
        int opcion = 0;
        boolean opcionValida = false;
        while (!opcionValida) {
            try {
                opcion = Integer.parseInt(scanner.nextLine());
                opcionValida = true;

            } catch (NumberFormatException e) {
                System.out.println("Formato no valido ... ");

            }

        }
        return opcion;
    }

    public static int validarID(Scanner scanner) {
        int id = 0;
        boolean opcionValida = false;
        while (!opcionValida) {
            try {
                System.out.println("\nIntroduce el ID de la gestión:");
                id = Integer.parseInt(scanner.nextLine());
                opcionValida = true;
            }catch (NumberFormatException e) {
                System.out.println("Formato no valido ... solo se admiten enteros");
            }
        }
        return id;

    }
}

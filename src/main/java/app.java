import java.util.Scanner;

public class app {
    public static void main(String[] args) {

        System.out.println(""" 
                1-Gestion de proveedores
                2-Gestion de piezas
                3-Gestion de proyectos
                4-Gestion de Suministros
                0-Salir
                """);

    }
    public static void validarOpciones(Scanner scanner ){
        int opcion;
        boolean opcionValida = false;
        while(!opcionValida){
            try {
                System.out.println("Ingrese una opcion: ");
                opcion = Integer.parseInt(scanner.nextLine());
                opcionValida = true;

            }catch(NumberFormatException e){
                System.out.println("Opcion no valida");
            }


        }

    }


}

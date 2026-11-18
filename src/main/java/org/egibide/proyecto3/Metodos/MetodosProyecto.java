package org.egibide.proyecto3.Metodos;

import org.egibide.proyecto3.Dao.GestionDao;
import org.egibide.proyecto3.Dao.ProyectoDao;
import org.egibide.proyecto3.Modelo.Proyecto;

import java.util.List;
import java.util.Scanner;

public class MetodosProyecto {
    public static void agregarProyecto(Scanner scanner) {
        ProyectoDao proyectoDao = new ProyectoDao();

        System.out.println("Introduce el codigo de Proyecto: ");
        String codigoProyecto = scanner.nextLine().toLowerCase();

        Proyecto proyecto = proyectoDao.find(codigoProyecto);

        if (proyecto != null) {
            System.out.println("El proyecto ya existe");

        } else {
            System.out.println("Nombre de Proyecto: ");
            String nombreProyecto = scanner.nextLine();

            System.out.println("Ciudad de Proyecto: ");
            String ciudadProyecto = scanner.nextLine();

            if (!nombreProyecto.isEmpty() && !ciudadProyecto.isEmpty() && !codigoProyecto.isEmpty()) {
                proyecto = new Proyecto(codigoProyecto, nombreProyecto, ciudadProyecto);
                proyectoDao.create(proyecto);

                System.out.println("Proyecto agregado correctamente");
            } else {
                System.out.println("No se a guardado el proyecto ,Todos los campos son necesarios");
            }


        }


    }

    public static void eliminarProyecto(Scanner scanner) {

        ProyectoDao proyectoDao = new ProyectoDao();
        GestionDao gestionDao = new GestionDao();

        System.out.println("Introduce el codigo de Proyecto: ");
        String codigoProyecto = scanner.nextLine();
        Proyecto proyecto = proyectoDao.find(codigoProyecto);
        if (proyecto != null) {
            if (gestionDao.existeGestionProyecto(codigoProyecto)) {
                System.out.println("No se puede eliminar el proyecto " +
                        proyecto.getCodigoProyecto() +
                        " porque tiene gestiones asociadas.");
            } else {
                proyectoDao.delete(proyecto);
                System.out.println("Proyecto " + proyecto.getCodigoProyecto() + " eliminado correctamente");
            }

        } else {
            System.out.println("Proyecto no existe");
        }
    }

    public static void modificarProyecto(Scanner scanner) {
        ProyectoDao proyectoDao = new ProyectoDao();
        System.out.println("Introduce el codigo de Proyecto: ");
        String codigoProyecto = scanner.nextLine();

        boolean ciudadModificado = false;
        boolean nombreModificado = false;

        Proyecto proyecto = proyectoDao.find(codigoProyecto);
        if (proyecto != null) {

            System.out.println("Nuevo nombre de Proyecto , o enter para continuar ");
            String nuevoNombre = scanner.nextLine();
            if (!nuevoNombre.isEmpty()) {
                proyecto.setNombre(nuevoNombre);
                nombreModificado = true;
            }

            System.out.println("Nueva ciudad de Proyecto , o enter para continuar ");
            String nuevoCiudad = scanner.nextLine();
            if (!nuevoCiudad.isEmpty()) {
                proyecto.setCiudad(nuevoCiudad);
                ciudadModificado = true;
            }
            if (ciudadModificado || nombreModificado) {
                proyectoDao.update(proyecto);
                System.out.println("\nProyecto modificado correctamente");

                System.out.println("\nNombre: " + proyecto.getNombre() +
                        "\nCiudad: " + proyecto.getCiudad()
                );
            } else {
                System.out.println("No se han realizado cambios "
                );
            }

        } else {
            System.out.println("El Proyecto" + codigoProyecto + "  no existe");
        }

    }


    public static void buscarProyecto(Scanner scanner) {
        ProyectoDao proyectoDao = new ProyectoDao();
        System.out.println("Introduce el codigo de Proyecto, nombre de Proyecto o ciudad ");
        String buscarProyecto = scanner.nextLine();
        List<Proyecto> proyectos = proyectoDao.busquedaProyecto(buscarProyecto, buscarProyecto, buscarProyecto);
        if (proyectos != null && !proyectos.isEmpty()) {
            for (Proyecto proyecto : proyectos) {
                System.out.println(
                        "\nNombre Proyecto: " + proyecto.getNombre() +
                                "\nCiudad: " + proyecto.getCiudad() +
                                "\nCodigo proyecto: " + proyecto.getCodigoProyecto()
                );
                System.out.println();

            }
        } else {
            System.out.println("No existe ningun proyecto con los datos introducidos");
        }
    }


    public static void mostrarProyectos() {
        ProyectoDao proyectoDao = new ProyectoDao();


        List<Proyecto> listProyect = proyectoDao.obtenerProyectos();

        if (listProyect != null && !listProyect.isEmpty()) {
            System.out.println("|---Lista de Proyectos ---|");
            for (Proyecto proyecto : listProyect) {
                System.out.println(
                        "\nCodigo Proyecto: " + proyecto.getCodigoProyecto() +
                                "\nNombre: " + proyecto.getNombre() +
                                "\nCiudad: " + proyecto.getCiudad() + "\n"

                );
                System.out.println();
            }
        } else {
            System.out.println("No existen proyectos disponibles");
        }

    }

}

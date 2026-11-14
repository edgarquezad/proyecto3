package org.egibide.proyecto3.Metodos;

import org.egibide.proyecto3.Dao.ProyectoDao;
import org.egibide.proyecto3.Modelo.Proyecto;

import java.util.List;
import java.util.Scanner;

public class MetodosProyecto {
    public static void agregarProyecto(Scanner scanner) {
        ProyectoDao proyectoDao = new ProyectoDao();

        System.out.println("Introduce el codigo de Proyecto: ");
        String codigoProyecto = scanner.nextLine();

        Proyecto proyecto = proyectoDao.find(codigoProyecto);

        if (proyecto != null) {
            System.out.println("El proyecto ya existe");

        } else {
            System.out.println("Nombre de Proyecto: ");
            String nombreProyecto = scanner.nextLine();

            System.out.println("Ciudad de Proyecto: ");
            String ciudadProyecto = scanner.nextLine();

            proyecto = new Proyecto(codigoProyecto, nombreProyecto, ciudadProyecto);
            proyectoDao.create(proyecto);
            System.out.println("Proyecto agregado correctamente");
        }


    }

    public static void eliminarProyecto(Scanner scanner) {
        ProyectoDao proyectoDao = new ProyectoDao();

        System.out.println("Introduce el codigo de Proyecto: ");
        String codigoProyecto = scanner.next();

        Proyecto proyecto = proyectoDao.find(codigoProyecto);
        if (proyecto != null) {
            proyectoDao.delete(proyecto);
            System.out.println("Proyecto eliminado correctamente");

        } else {
            System.out.println("Proyecto no existe");
        }
    }

    public static void modificarProyecto(Scanner scanner) {
        ProyectoDao proyectoDao = new ProyectoDao();
        System.out.println("Introduce el codigo de Proyecto: ");
        String codigoProyecto = scanner.nextLine();

        Proyecto proyecto = proyectoDao.find(codigoProyecto);
        if (proyecto != null) {

            System.out.println("Nuevo nombre de Proyecto , o enter para continuar ");
            String nuevoNombre = scanner.nextLine();
            if (!nuevoNombre.isEmpty()) {
                proyecto.setNombre(nuevoNombre);
            }

            System.out.println("Nuevo ciudad de Proyecto , o enter para continuar ");
            String nuevoCiudad = scanner.nextLine();
            if (!nuevoCiudad.isEmpty()) {
                proyecto.setCiudad(nuevoCiudad);
            }
            proyectoDao.update(proyecto);
            System.out.println("Proyecto actualizado correctamente");

        } else {
            System.out.println("Proyecto no existe");
        }
    }

    public static void buscarProyecto(Scanner scanner) {
        ProyectoDao proyectoDao = new ProyectoDao();
        System.out.println("Introduce el codigo de Proyecto, nombre de Proyecto o ciudad ");
        String buscarProyecto = scanner.nextLine();
        List<Proyecto> proyectos = proyectoDao.busquedaProyecto(buscarProyecto, buscarProyecto, buscarProyecto);
        if (proyectos != null) {
            for (Proyecto proyecto : proyectos) {
                System.out.println("Nombre Proyecto: " + proyecto.getNombre() +
                        "\nCiudad: " + proyecto.getCiudad() +
                        "\nCodigo proyecto: " + proyecto.getCodigoProyecto()
                );

            }
        } else {
            System.out.println("No existe ningun proyecto con los datos introducidos");
        }
    }

}

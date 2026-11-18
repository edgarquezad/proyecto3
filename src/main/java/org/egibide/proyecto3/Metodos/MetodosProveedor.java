package org.egibide.proyecto3.Metodos;

import org.egibide.proyecto3.Dao.GestionDao;
import org.egibide.proyecto3.Dao.ProveedorDao;
import org.egibide.proyecto3.Modelo.Proveedor;

import java.util.List;
import java.util.Scanner;

public class MetodosProveedor {
    public static void agregarProveedores(Scanner scanner) {
        ProveedorDao proveedorDao = new ProveedorDao();

        System.out.println("Ingrese el codigo del proveedor: ");
        String codigo = scanner.nextLine().toLowerCase();

        Proveedor proveedor = proveedorDao.find(codigo);
        if (proveedor != null) {
            System.out.println("Proovedor Existente");
        } else {
            System.out.println("Ingrese el nombre del proveedor: ");
            String nombre = scanner.nextLine();

            System.out.println("Ingrese el apellido del proveedor: ");
            String apellido = scanner.nextLine();

            System.out.println("Introduce la direccion del proveedor: ");
            String direccion = scanner.nextLine();

            if (codigo.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || direccion.isEmpty()) {
                System.out.println("Todos los campos son necesarios");
            }else{
                proveedor = new Proveedor(codigo, nombre, apellido, direccion);

                proveedorDao.create(proveedor);
                System.out.println("Proveedor agregado correctamente.");
            }


        }


    }

    public static void eliminarProveedores(Scanner scanner) {
        ProveedorDao proveedorDao = new ProveedorDao();
        GestionDao gestionDao = new GestionDao();

        System.out.println("Ingrese el codigo del proveedor: ");
        String codigo = scanner.nextLine().toLowerCase();

        Proveedor proveedor = proveedorDao.find(codigo);

        if (proveedor != null) {
            if (gestionDao.existeGestionProveedor(codigo)) {
                System.out.println("No se puede eliminar el proveedor " + proveedor.getCodigo() + " porque tiene gestiones asociadas.");
            } else {
                proveedorDao.delete(proveedor);
                System.out.println("Proveedor " + proveedor.getCodigo() + " eliminado correctamente.");
            }
        } else {
            System.out.println("Proveedor no encontrado");
        }
    }

    public static void modificarProveedores(Scanner scanner) {
        System.out.println("Ingrese el codigo del proveedor: ");
        String codigo = scanner.nextLine().toLowerCase();
        ProveedorDao proveedorDao = new ProveedorDao();
        Proveedor proveedor = proveedorDao.find(codigo);
        boolean modificarNombre = false;
        boolean modificarApellido = false;
        boolean modificarDireccion = false;

        if (proveedor != null) {
            System.out.println("Modificar nombre del proveedor o enter para continuar : ");
            String nombre = scanner.nextLine();
            if (!nombre.isEmpty()) {
                proveedor.setNombre(nombre);
                modificarNombre = true;
            }

            System.out.println("Modificar el apellido del proveedor o enter para continuar : ");
            String nuevoApellido = scanner.nextLine();
            if (!nuevoApellido.isEmpty()) {
                proveedor.setApellido(nuevoApellido);
                modificarApellido = true;
            }

            System.out.println("Modificar la direccion del proveedor o enter para continuar ");
            String direccion = scanner.nextLine();
            if (!direccion.isEmpty()) {
                proveedor.setDireccionPostal(direccion);
                modificarDireccion = true;
            }


            if (modificarNombre) {
                System.out.println("Se ha modificado Nombre correctamente: " + proveedor.getNombre());
            }
            if (modificarApellido) {
                System.out.println("Se ha modificado Apellido correctamente: " + proveedor.getApellido());
            }
            if (modificarDireccion) {
                System.out.println("Se ha modificado Direccion correctamente: " + proveedor.getDireccionPostal());
            }
            if (modificarNombre || modificarApellido || modificarDireccion) {
                proveedorDao.update(proveedor);
                System.out.println("\nProveedor actualizado correctamente.");
            } else {
                System.out.println("No se ha modificado proveedor " +
                        "-Nombre: " + proveedor.getNombre() + " -Apellido: " +
                        proveedor.getApellido() + " -Direccion: " +
                        proveedor.getDireccionPostal());
            }

        } else {
            System.out.println("proveedor no encontrado");
        }

    }

    public static void listarProveedores() {
        System.out.println("|----Listado de proveedores----|");
        ProveedorDao proveedorDao = new ProveedorDao();
        List<Proveedor> proveedores = proveedorDao.obtenerTodos();

        if (proveedores != null && !proveedores.isEmpty()) {
            for (Proveedor proveedor : proveedores) {
                System.out.println("Codigo: " + proveedor.getCodigo());
                System.out.println("Nombre: " + proveedor.getNombre());
                System.out.println("Apellido: " + proveedor.getApellido());
                System.out.println("Direccion: " + proveedor.getDireccionPostal());
                System.out.println();
            }

        } else {
            System.out.println("No existen proveedores");
        }


    }

    public static void buscarProveedores(Scanner scanner) {
        ProveedorDao proveedorDao = new ProveedorDao();
        System.out.println("Ingrese el codigo del proveedor,nombre o direccion postal para buscar: ");
        String busqueda = scanner.nextLine().toLowerCase();

        List<Proveedor> proveedores = proveedorDao.buscar(busqueda, busqueda, busqueda);
        if (proveedores != null && !proveedores.isEmpty()) {
            for (Proveedor proveedor : proveedores) {
                System.out.println(
                        "Codigo: " + proveedor.getCodigo() +
                                "\nNombre: " + proveedor.getNombre() +
                                "\nApellido: " + proveedor.getApellido() +
                                "\nDireccion: " + proveedor.getDireccionPostal()
                );
                System.out.println();

            }
        } else {
            System.out.println("No existen proveedores");
        }

    }

}

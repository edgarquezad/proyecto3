package org.egibide.proyecto3.Metodos;

import org.egibide.proyecto3.Dao.ProveedorDao;
import org.egibide.proyecto3.Modelo.Proveedor;

import java.util.List;
import java.util.Scanner;

public class MetodosProveedor {
    public static void agregarProveedores(Scanner scanner) {
        ProveedorDao proveedorDao = new ProveedorDao();

        System.out.println("Ingrese el codigo del proveedor: ");
        String codigo = scanner.next();

        Proveedor proveedor = proveedorDao.find(codigo);
        if (proveedor != null) {
            System.out.println("Proovedor Existente");
        } else {
            System.out.println("Ingrese el nombre del proveedor: ");
            String nombre = scanner.next();

            System.out.println("Ingrese el apellido del proveedor: ");
            String apellido = scanner.next();

            System.out.println("Ingrese el direccion del proveedor: ");
            String direccion = scanner.next();

            proveedor = new Proveedor(codigo, nombre, apellido, direccion);

            proveedorDao.create(proveedor);
            System.out.println("Proveedor agregado correctamente. . . . . .  fucking proyectos ................1");
        }


    }

    public static void eliminarProveedores(Scanner scanner) {
        ProveedorDao proveedorDao = new ProveedorDao();

        System.out.println("Ingrese el codigo del proveedor: ");
        String codigo = scanner.nextLine();
        Proveedor proveedor = proveedorDao.find(codigo);

        if (proveedor != null) {
            proveedorDao.delete(proveedor);
            System.out.println("provedor eliminado correctamente ");
        } else {
            System.out.println("proveedor no encontrado");
        }

    }

    public static void ModificarProveedores(Scanner scanner) {
        System.out.println("Ingrese el codigo del proveedor: ");
        String codigo = scanner.nextLine();
        ProveedorDao proveedorDao = new ProveedorDao();
        Proveedor proveedor = proveedorDao.find(codigo);

        if (proveedor != null) {
            System.out.println("Modificar nombre del proveedor o enter para continuar : ");
            String nombre = scanner.next();
            if (!nombre.isEmpty()) {
                proveedor.setNombre(nombre);
            }

            System.out.println("Ingrese el apellido del proveedor: ");
            String nuevoApellido = scanner.next();
            if (!nuevoApellido.isEmpty()) {
                proveedor.setApellido(nuevoApellido);
            }

            System.out.println("Ingrese el direccion del proveedor o enter para continuar ");
            String direccion = scanner.next();
            if (!direccion.isEmpty()) {
                proveedor.setDireccionPostal(direccion);
            }

            proveedorDao.update(proveedor);
            System.out.println("Provedor actualizado correctamente ");

        } else {
            System.out.println("proveedor no encontrado");
        }

    }

    public static void listarProveedores(Scanner scanner) {
        System.out.println("Listado de proveedores:");
        ProveedorDao proveedorDao = new ProveedorDao();
        List<Proveedor> proveedores = proveedorDao.obtenerTodos();

        if (proveedores != null) {
            for (Proveedor proveedor : proveedores) {
                System.out.println("Nombre: " + proveedor.getNombre());
                System.out.println("Apellido: " + proveedor.getApellido());
                System.out.println("direccion: " + proveedor.getDireccionPostal());
                System.out.println();
            }

        } else {
            System.out.println("proveedor no encontrado");
        }


    }

    public static void buscarProveedores(Scanner scanner) {
        ProveedorDao proveedorDao = new ProveedorDao();
        System.out.println("Ingrese el codigo del proveedor,nombre o direccion postal para buscar: ");
        String busqueda = scanner.next();

        List<Proveedor> proveedores = proveedorDao.buscar(busqueda,busqueda,busqueda) ;
        if (proveedores != null) {
            for (Proveedor proveedor : proveedores) {
                System.out.println(
                        "Nombre: " + proveedor.getNombre() +
                                "\nApellido: " + proveedor.getApellido() +
                                "\nDireccion: " + proveedor.getDireccionPostal()
                );
                System.out.println();

            }
        }
        System.out.println("Provedor no encotrado");
    }

}

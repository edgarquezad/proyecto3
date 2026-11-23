package org.egibide.proyecto3.Controladores;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.egibide.proyecto3.Metodos.MG.ProveedorMt;
import org.egibide.proyecto3.Modelo.Proveedor;

import java.util.List;

public class VentanaProovedores {

    @FXML
    private TableView<Proveedor> table;

    @FXML
    private TableColumn<Proveedor, String> colCodigoProveedor;
    @FXML
    private TableColumn<Proveedor, String> colNombreProveedor;
    @FXML
    private TableColumn<Proveedor, String> colApellidoProveedor;
    @FXML
    private TableColumn<Proveedor, String> colDireccionPostalProveedor;

    @FXML
    private TextField txtBuscarProveedor;


    private ProveedorMt proveedorMt = new ProveedorMt();


    @FXML
    private void initialize() {
        colCodigoProveedor.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colNombreProveedor.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colApellidoProveedor.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        colDireccionPostalProveedor.setCellValueFactory(new PropertyValueFactory<>("direccionPostal"));
        mostrarProovedor();

    }


    @FXML
    private void mostrarProovedor() {
        List<Proveedor> list = proveedorMt.listaProveedores();
        table.setItems(FXCollections.observableArrayList(list));


    }

}

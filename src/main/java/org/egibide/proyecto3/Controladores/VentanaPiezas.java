package org.egibide.proyecto3.Controladores;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.egibide.proyecto3.Metodos.MG.PiezasMt;
import org.egibide.proyecto3.Modelo.Piezas;

import java.io.IOException;
import java.util.List;

public class VentanaPiezas {

    @FXML
    private TableView<Piezas> tablaPiezas;

    @FXML
    private TableColumn<Piezas, String> colCodigo;

    @FXML
    private TableColumn<Piezas, String> colNombre;

    @FXML
    private TableColumn<Piezas, String> colDescripcion;

    @FXML
    private TableColumn<Piezas, Double> colPrecio;

    @FXML
    private TextField txtBuscar;


    private final PiezasMt piezasMt = new PiezasMt();


    @FXML
    public void initialize() {

        colCodigo.setCellValueFactory(
                new PropertyValueFactory<>("codigoPieza"));

        colNombre.setCellValueFactory(
                new PropertyValueFactory<>("nombre"));

        colDescripcion.setCellValueFactory(
                new PropertyValueFactory<>("descripcion"));

        colPrecio.setCellValueFactory(
                new PropertyValueFactory<>("precio"));

        cargarTablaPiezas();
    }

    @FXML
    private void cargarTablaPiezas() {
        tablaPiezas.getItems().clear();
        List<Piezas> piezas = piezasMt.listarPiezas();

        tablaPiezas.setItems(
                FXCollections.observableArrayList(piezas));

    }
    public void actualizarTablaPiezas() {
        cargarTablaPiezas();

    }

    @FXML
    private void buscarPiezas() {

        String busqueda = txtBuscar.getText().trim();

        List<Piezas> piezas = piezasMt.buscarPiezas(busqueda);

        if (piezas == null || piezas.isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Búsqueda de piezas");
            alert.setHeaderText("trabaja  V-A-G-O ");
            alert.showAndWait();

        } else {
            tablaPiezas.getItems().clear();
            tablaPiezas.setItems(
                    FXCollections.observableArrayList(piezas));
        }

    }

    @FXML
    private void limpiarBusqueda() {
        txtBuscar.clear();
        cargarTablaPiezas();
    }


    @FXML
    private void mostrarFormulario() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/Vistas/Piezas/FormularioPiezas.fxml")
            );

            Parent ventana = loader.load();

            FormularioPiezas controlador = loader.getController();
            controlador.setVentanaPiezas(this);

            Stage formulario = new Stage();
            formulario.setTitle("Agregar pieza");
            formulario.setScene(new Scene(ventana));
            formulario.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    @FXML
    private void editarFormulario() {
        Piezas piezaSeleccionada = tablaPiezas.getSelectionModel().getSelectedItem();
        if (piezaSeleccionada == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Editar pieza");
            alert.setHeaderText("No has seleccionado ninguna pieza");
            alert.setContentText("Seleccione una pieza de la tabla :");
            alert.showAndWait();
            return;
        }
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/Vistas/Piezas/FormularioPiezas.fxml")
            );

            Parent ventana = loader.load();

            FormularioPiezas controlador = loader.getController();

            controlador.setVentanaPiezas(this);
            controlador.setPiezaEditar(piezaSeleccionada);
            controlador.cambiarModoEdicion();

            Stage formulario = new Stage();
            formulario.setTitle("Editar pieza");
            formulario.setScene(new Scene(ventana));
            formulario.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
@FXML
    public void eliminarPieza(ActionEvent actionEvent) {
        Piezas piesaSeleccionada = tablaPiezas.getSelectionModel().getSelectedItem();
        if (piesaSeleccionada == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Eliminar pieza");
            alert.setHeaderText("No seleccionado ninguna pieza");
            alert.setContentText("Seleccione una pieza de la tabla :");
            alert.showAndWait();
            return;
        }
        piezasMt.eliminarPiezas(piesaSeleccionada);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Eliminar pieza");
        alert.setHeaderText("Eliminar pieza");
        alert.setContentText("Pieza eliminado exitosamente");
        alert.showAndWait();
        actualizarTablaPiezas();

    }
}

package org.egibide.proyecto3.Controladores;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.Objects;


public class VentanaPrincipalController {


    // Elementos de la ventana
    @FXML
    private Label lblTitulo;

    @FXML
    private Label lblDescripcion;

    @FXML
    private VBox contenedorContenido;

    @FXML
    private void mostrarInicio() {

        lblTitulo.setText("¡Bienvenido!");
        lblDescripcion.setText("Selecciona un apartado para comenzar a gestionar los datos.");


    }

    @FXML
    private void mostrarVistaPieza() {
        try {

            FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/Vistas/Piezas/VentanaPiezas.fxml")));
            Node ventana =loader.load();
            VentanaPiezas vp = loader.getController();


            contenedorContenido.getChildren().setAll(ventana);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @FXML
    private void mostrarProveedores() {
        try {
            Node ventana = FXMLLoader.load(
                    Objects.requireNonNull(getClass().getResource("/Vistas/VentanaProveedores.fxml"))
            );
            contenedorContenido.getChildren().setAll(ventana);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



}

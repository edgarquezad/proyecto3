package org.egibide.proyecto3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppGrafica extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(
                AppGrafica.class.getResource("/Vistas/VentanaPrincipal.fxml")
        );

        Scene scene = new Scene(fxmlLoader.load());

        stage.setTitle("Gestión de proveedores, piezas y proyectos");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
package org.egibide.proyecto3.Controladores;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.egibide.proyecto3.Metodos.MG.PiezasMt;
import org.egibide.proyecto3.Modelo.Piezas;

public class FormularioPiezas {

    public VBox formulario;
    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtPrecio;
    @FXML
    private TextArea txtDescripcio;


    @FXML
    private Button btnGuardar;

    private VentanaPiezas ventanaPiezas;
    private Piezas piezaEditar;

    public void setVentanaPiezas(VentanaPiezas ventanaPiezas) {
        this.ventanaPiezas = ventanaPiezas;
    }
    public void setPiezaEditar(Piezas pieza) {
       this.piezaEditar = pieza;

        txtCodigo.setText(pieza.getCodigoPieza());
        txtNombre.setText(pieza.getNombre());
        txtDescripcio.setText(pieza.getDescripcion());
        txtPrecio.setText(String.valueOf(pieza.getPrecio()));
    }

    PiezasMt piezasMt = new PiezasMt();

    @FXML
    public void guardarPieza(ActionEvent actionEvent) {

        String codigoPieza = txtCodigo.getText();
        boolean comprobar = piezasMt.comprobar(codigoPieza);
        if (comprobar) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Codigo de pieza existe ");
            alert.showAndWait();
            return;

        }
            String nombre = txtNombre.getText();
            String descripcionPieza = txtDescripcio.getText();

            if (codigoPieza.isEmpty() || nombre.isEmpty()
                    || txtPrecio.getText().isEmpty()
                    || descripcionPieza.isEmpty()) {

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Campos incompletos");
                alert.setHeaderText("Debes rellenar todos los campos");
                alert.showAndWait();
                return;
            }
            try {
                double precioPieza = Double.parseDouble(txtPrecio.getText());
                if (precioPieza <= 0) {
                    throw new NumberFormatException("Precio negativo");
                }
                Piezas piezas = new Piezas(codigoPieza,nombre,precioPieza,descripcionPieza);

                piezasMt.guardarPiezas(piezas);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Registro Exitoso");
                alert.setHeaderText("Pieza Guardada");
                alert.showAndWait();
                //cerrar ventana

                Button btGuardar = (Button) actionEvent.getSource();
                Stage stage = (Stage) btGuardar.getScene().getWindow();
                stage.close();
                ventanaPiezas.actualizarTablaPiezas();


            } catch (NumberFormatException e) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Error");
                alert.setHeaderText("El precio no puede estar vacio ni ser menor que 0");
                alert.showAndWait();
            }


    }

        @FXML
        private void cancelar (ActionEvent event){
            Button btnCancelar = (Button) event.getSource();
            Stage stage = (Stage) btnCancelar.getScene().getWindow();
            stage.close();


        }

    @FXML
    private void editarPieza(ActionEvent event) {

        String codigoPieza = txtCodigo.getText();
        String nombre = txtNombre.getText();
        String descripcionPieza = txtDescripcio.getText();

        if (codigoPieza.isEmpty() || nombre.isEmpty() ||
                txtPrecio.getText().isEmpty() || descripcionPieza.isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Campos incompletos");
            alert.setHeaderText("Debes rellenar todos los campos");
            alert.showAndWait();
            return;
        }

        try {
            double precioPieza = Double.parseDouble(txtPrecio.getText());

            if (precioPieza <= 0) {
                throw new NumberFormatException();
            }

            piezaEditar.setNombre(nombre);
            piezaEditar.setPrecio(precioPieza);
            piezaEditar.setDescripcion(descripcionPieza);
            piezasMt.editarPiezas(piezaEditar);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Edición exitosa");
            alert.setHeaderText("Pieza modificada correctamente");
            alert.showAndWait();

            ventanaPiezas.actualizarTablaPiezas();

            Button btn = (Button) event.getSource();
            Stage stage = (Stage) btn.getScene().getWindow();
            stage.close();

        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText("El precio debe ser un número mayor que 0");
            alert.showAndWait();
        }
    }


    @FXML
    public void guardar(ActionEvent event) {
        if (piezaEditar == null) {
            guardarPieza(event);
        } else {
            editarPieza(event);
        }
    }

    public void cambiarModoEdicion() {
        btnGuardar.setText("Editar");
    }

    }

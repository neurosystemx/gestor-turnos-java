package com.gestorturnos.controller;
import com.gestorturnos.*;



import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.*;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class GestionarTurnosController {

    @FXML private ComboBox<Doctor> comboDoctor;
    @FXML private DatePicker datePickerFecha;


    // columnas + tabla
    @FXML private TableView<Turno> tablaTurnos;
    @FXML private TableColumn<Turno, String> colHora;
    @FXML private TableColumn<Turno, String> colPaciente;
    @FXML private TableColumn<Turno, String> colEstado;


    // listas cargadas desde el main 
    public static ObservableList<Doctor> doctores;
    public static ObservableList<Paciente> pacientes;

    // agenda actual
    private Agenda agendaActual;



    @FXML
    public void initialize() {

        // cargar doctores en el comboBox
        comboDoctor.setItems(doctores);

        // configurar columnas de la tabla
        colHora.setCellValueFactory(cell -> {
            LocalTime hora = cell.getValue().getFecha().toLocalTime();
            return new javafx.beans.property.SimpleStringProperty(hora.toString());
        });

        // to-do verificar uso de lambda permitido?
        // si no tiene paciente, esta disponible por default

        colPaciente.setCellValueFactory(cell -> {
            Turno t = cell.getValue();
            String nombre = (t.getPaciente() == null) ? "Disponible" : t.getPaciente().getNombre();
            return new javafx.beans.property.SimpleStringProperty(nombre);
        });

        // obtener estados (vienen del enum de la clase turno) para ponerlos en la celda
        colEstado.setCellValueFactory(cell ->
                new javafx.beans.property.SimpleStringProperty(cell.getValue().getEstado().name()));
    }

    
    // boton cargar Agenda
    
    @FXML
    private void onCargarAgenda() {

        Doctor doc = comboDoctor.getValue();
        LocalDate fecha = datePickerFecha.getValue();

        if (doc == null || fecha == null) {
            mostrarAlerta("Seleccione doctor y fecha");
            return;
        }

        agendaActual = new Agenda(doc, fecha);

        tablaTurnos.setItems(FXCollections.observableArrayList(agendaActual.getTurnosDelDia()));
    }

    // boton Reservar Turno

    @FXML
    private void onReservarTurno() {

        Turno seleccionado = tablaTurnos.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            mostrarAlerta("Seleccione un turno");
            return;
        }

        if (!seleccionado.estaPendiente()) {
            mostrarAlerta("Este turno no está disponible");
            return;
        }

        // asignar un paciente fijo o el primero
        Paciente p = GestionarTurnosController.pacientes.get(0);
        seleccionado.setPaciente(p);
        seleccionado.setEstado(Turno.EstadoTurno.CONFIRMADO);

        tablaTurnos.refresh();
    }

   
    // boton cancelar Turno
   
    @FXML
    private void onCancelarTurno() {

        Turno seleccionado = tablaTurnos.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            mostrarAlerta("Seleccione un turno");
            return;
        }

        seleccionado.setEstado(Turno.EstadoTurno.CANCELADO);

        tablaTurnos.refresh();
    }

    // boton para volver

    @FXML
    private void onVolver() throws IOException {
        App.setRoot("primary");
    }



    
    // mensaje alerta
    
    private void mostrarAlerta(String msg) {
        Alert alert = new Alert(Alert.AlertType.WARNING, msg);
        alert.show();
    }
}

package com.gestorturnos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

// importar controladores!
import com.gestorturnos.controller.EspecialidadController;

import com.gestorturnos.controller.PacienteController;
import com.gestorturnos.controller.TurnoController;
import com.gestorturnos.Turno.EstadoTurno;
import com.gestorturnos.controller.DoctorController;

public class CargaDatos {

    public void cargarDatos(){


// Carga ArrayList de Especialidades

List<Especialidad> listaEspecialidades = new ArrayList<>();

Especialidad espCardiologia   = new Especialidad("Cardiología");
Especialidad espTraumatologia = new Especialidad("Traumatología");
Especialidad espDermatologia  = new Especialidad("Dermatología");

// agregarlas a la lista
listaEspecialidades.add(espCardiologia);
listaEspecialidades.add(espTraumatologia);
listaEspecialidades.add(espDermatologia);

// mostrar
for (Especialidad e : listaEspecialidades){
    System.out.println(e);
        }


// carga ArrayList de Doctores


List<Doctor> listaDoctores = new ArrayList<>();

Doctor doc1 = new Doctor("Dr. Carlos López",   "pass123", "carlos.lopez@clinica.com",    espCardiologia);
Doctor doc2 = new Doctor("Dra. Miriam Torres", "pass123", "miriam.torres@clinica.com",   espCardiologia);
Doctor doc3 = new Doctor("Dr. Roberto Sánchez","pass123", "roberto.sanchez@clinica.com", espTraumatologia);
Doctor doc4 = new Doctor("Dra. Julia Fernández","pass123","julia.fernandez@clinica.com", espDermatologia);

// agregarlos a la lista
listaDoctores.add(doc1);
listaDoctores.add(doc2);
listaDoctores.add(doc3);
listaDoctores.add(doc4);

// mostrar
for (Doctor d : listaDoctores){
    System.out.println(d);
        }

        

// carga ArrayList de Pacientes

List<Paciente> listaPacientes = new ArrayList<>();

Paciente pac1 = new Paciente("Juan Pérez",   "abc123", "juan@correo.com",   "30111222", "1160001111");
Paciente pac2 = new Paciente("Ana García",   "abc123", "ana@correo.com",    "28999444", "1155552222");
Paciente pac3 = new Paciente("Carlos Ruiz",  "abc123", "carlos@correo.com", "27222111", "1144447777");
Paciente pac4 = new Paciente("Laura Díaz",   "abc123", "laura@correo.com",  "29555111", "1188883333");

// agregarlos a la lista
listaPacientes.add(pac1);
listaPacientes.add(pac2);
listaPacientes.add(pac3);
listaPacientes.add(pac4);


// mostrar
for (Paciente p : listaPacientes){
    System.out.println(p);
        }

    }
}
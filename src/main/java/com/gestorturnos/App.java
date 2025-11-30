package com.gestorturnos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDateTime;

// importar controladores!
import com.gestorturnos.controller.EspecialidadController;

import com.gestorturnos.controller.PacienteController;
import com.gestorturnos.controller.TurnoController;
import com.gestorturnos.Turno.EstadoTurno;
import com.gestorturnos.controller.DoctorController;




/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    

    public static void main(String[] args) {

    //    launch();
        


    // test de turnos y turnoController

    TurnoController turnoController = new TurnoController();

        // Especialidades
        Especialidad espCardiologia = new Especialidad("Cardiología");
        Especialidad espTraumatologia = new Especialidad("Traumatología");
        Especialidad espDermatologia = new Especialidad("Dermatología");

        // Doctores (4 doctores, 2 con misma especialidad)
        Doctor doc1 = new Doctor("Dr. Carlos López", "pass123", "carlos.lopez@clinica.com", espCardiologia);
        Doctor doc2 = new Doctor("Dra. Miriam Torres", "pass123", "miriam.torres@clinica.com", espCardiologia);
        Doctor doc3 = new Doctor("Dr. Roberto Sánchez", "pass123", "roberto.sanchez@clinica.com", espTraumatologia);
        Doctor doc4 = new Doctor("Dra. Julia Fernández", "pass123", "julia.fernandez@clinica.com", espDermatologia);

        // Pacientes
        Paciente pac1 = new Paciente("Juan Pérez", "abc123", "juan@correo.com", "30111222", "1160001111");
        Paciente pac2 = new Paciente("Ana García", "abc123", "ana@correo.com", "28999444", "1155552222");
        Paciente pac3 = new Paciente("Carlos Ruiz", "abc123", "carlos@correo.com", "27222111", "1144447777");
        Paciente pac4 = new Paciente("Laura Díaz", "abc123", "laura@correo.com", "29555111", "1188883333");

        // Fechas de turnos
        LocalDateTime fecha1 = LocalDateTime.of(2025, 12, 1, 10, 30);
        LocalDateTime fecha2 = LocalDateTime.of(2025, 12, 1, 11, 30);

        // Crear turnos
        Turno turno1 = new Turno(100, doc1, pac1, EstadoTurno.PENDIENTE, fecha1);
        Turno turno2 = new Turno(101, doc2, pac2, EstadoTurno.PENDIENTE, fecha2);

        // Agregar turnos
        turnoController.agregarTurno(turno1);
        turnoController.agregarTurno(turno2);

        // Mostrar todos los turnos
        System.out.println("=== Turnos cargados ===");
        for (Turno t : turnoController.getTurnos()) {
            System.out.println(t);
        }

        // Confirmar turno1
        turnoController.confirmarTurno(turno1);
        System.out.println("\n=== Turno 1 confirmado ===");
        System.out.println(turno1);

        // Cancelar turno2
        turnoController.cancelarTurno(turno2);
        System.out.println("\n=== Turno 2 cancelado ===");
        System.out.println(turno2);

        // Borrar turno2
        turnoController.borrarTurno(turno2);
        System.out.println("\n=== Turnos luego de borrar turno 2 ===");
        for (Turno t : turnoController.getTurnos()) {
            System.out.println(t);
        }

        // Turnos por doctor
        System.out.println("\n=== Turnos del Dr. Carlos López ===");
        for (Turno t : turnoController.getTurnosPorDoctor(doc1)) {
            System.out.println(t);
        }

        // Turnos por paciente
        System.out.println("\n=== Turnos del paciente Ana García ===");
        for (Turno t : turnoController.getTurnosPorPaciente(pac2)) {
            System.out.println(t);
        }





























































    // test de Turnos

    /*

    // Especialidades
        Especialidad espCardiologia = new Especialidad("Cardiología");   // compartida
        Especialidad espTraumatologia = new Especialidad("Traumatología");
        Especialidad espDermatologia = new Especialidad("Dermatología");

        // Doctores (4 doctores, 2 con misma especialidad)
        Doctor doc1 = new Doctor("Dr. Carlos López", "pass123", "carlos.lopez@clinica.com", espCardiologia);
        Doctor doc2 = new Doctor("Dra. Miriam Torres", "pass123", "miriam.torres@clinica.com", espCardiologia);
        Doctor doc3 = new Doctor("Dr. Roberto Sánchez", "pass123", "roberto.sanchez@clinica.com", espTraumatologia);
        Doctor doc4 = new Doctor("Dra. Julia Fernández", "pass123", "julia.fernandez@clinica.com", espDermatologia);

        // Pacientes (4 pacientes)
        Paciente pac1 = new Paciente("Juan Pérez", "abc123", "juan@correo.com", "30111222", "1160001111");
        Paciente pac2 = new Paciente("Ana García", "abc123", "ana@correo.com", "28999444", "1155552222");
        Paciente pac3 = new Paciente("Carlos Ruiz", "abc123", "carlos@correo.com", "27222111", "1144447777");
        Paciente pac4 = new Paciente("Laura Díaz", "abc123", "laura@correo.com", "29555111", "1188883333");

        // Fecha de los turnos
        LocalDateTime fechaTurno = LocalDateTime.of(2025, 12, 1, 10, 30);

        // Turno 1 (pendiente)
        Turno turno1 = new Turno(
                100,
                doc1,
                pac1,
                EstadoTurno.PENDIENTE,
                fechaTurno
        );

        System.out.println("=== Turno recién creado ===");
        System.out.println(turno1);

        // Confirmar turno 1
        turno1.setEstado(EstadoTurno.CONFIRMADO);
        System.out.println("\n=== Turno confirmado ===");
        System.out.println(turno1);

        // Marcar como atendido
        turno1.setEstado(EstadoTurno.ATENDIDO);
        System.out.println("\n=== Turno atendido ===");
        System.out.println(turno1);

        // Turno 2 (cancelado)
        LocalDateTime otraFecha = fechaTurno.plusHours(1);
        Turno turno2 = new Turno(
                101,
                doc2,
                pac2,
                EstadoTurno.CANCELADO,
                otraFecha
        );

        System.out.println("\n=== Segundo turno (cancelado) ===");
        System.out.println(turno2);

        // Especialidades disponibles
        System.out.println("\n=== Especialidades ===");
        System.out.println(espCardiologia.getNombre());
        System.out.println(espTraumatologia.getNombre());
        System.out.println(espDermatologia.getNombre());

        // Doctores creados
        System.out.println("\n=== Doctores ===");
        System.out.println(doc1.getNombre() + " → " + doc1.getEspecialidad().getNombre());
        System.out.println(doc2.getNombre() + " → " + doc2.getEspecialidad().getNombre());
        System.out.println(doc3.getNombre() + " → " + doc3.getEspecialidad().getNombre());
        System.out.println(doc4.getNombre() + " → " + doc4.getEspecialidad().getNombre());

        // Pacientes cargados
        System.out.println("\n=== Pacientes ===");
        System.out.println(pac1.getNombre());
        System.out.println(pac2.getNombre());
        System.out.println(pac3.getNombre());
        System.out.println(pac4.getNombre());

        */


































    











    /* SECCION DE TEST !!!!!! */



    // test de doctor + DoctorController

    /*
    
    DoctorController doctorController = new DoctorController();


    System.out.println("\n Comienzo de los tests");

    System.out.println("#####################################");

    System.out.println("   ");


        // crear especialidades para asignar a los doctores
        Especialidad cardio = new Especialidad("cardiologia");
        Especialidad trauma = new Especialidad("traumatología");
        Especialidad derma = new Especialidad("dermatologia");

        System.out.println("\n test 1 - alta de doctor");
        System.out.println("   ");
        
        doctorController.agregarDoctor("Mario", "adad", "mario@mail.com", cardio);
        doctorController.agregarDoctor("Lucia", "hgola1", "lucia@mail.com", trauma);
        doctorController.agregarDoctor("Sofia", "password", "sofia@mail.com", derma);

        System.out.println("\nListado de doctores:");
        doctorController.listarDoctores();

        System.out.println("\n test 2 - correo repetido");
        System.out.println("   ");

        //no debería agregarse (correo repetido de mario)

        doctorController.agregarDoctor("Mario2", "passX", "mario@mail.com", trauma);

        System.out.println("\n listado de doctores (debería ser igual al anterior):");
        doctorController.listarDoctores();

        System.out.println("\n test 3 - buscar por id");
        System.out.println("   ");

        System.out.println("doctor con id 1:");
        System.out.println(doctorController.buscarPorId(1));

        System.out.println("doctor con id 99 (no existe):");
        System.out.println(doctorController.buscarPorId(99)); // debería ser null

        System.out.println("\n test 4 - modificar doctor");

        System.out.println("   ");
        
        System.out.println("modificando doctor con id 2 : Lucia)...");
        boolean modificado = doctorController.modificarDoctor(
                2,
                "Lucia Pérez",              // nuevoNombre
                "lucia.perez@mail.com",     //  nuevoCorreo
                "nuevaPass123",             // nuevoPassword
                cardio                      //   nuevaEspecialidad (antes tenia traumatologia)
        );
        System.out.println("modificado? " + modificado);

        System.out.println("\n listado despues de modificar:");
        doctorController.listarDoctores();

        System.out.println("\n test 5 - borrar doctor");
        System.out.println("   ");

        System.out.println("Eliminando doctor con id 3 (sofia)...");
        boolean eliminado = doctorController.eliminarPorId(3);
        System.out.println("eliminado? " + eliminado);

        System.out.println("\n lista FINAL de doctores:");
        doctorController.listarDoctores();
    
        
        */


   





















































    // test de paciente + PacienteController

/*
    PacienteController pacienteController = new PacienteController();

    System.out.println("\n Comienzo de los tests");

    System.out.println("#####################################");

    System.out.println("   ");
            
    System.out.println(" test 1 - alta pacientes");
    pacienteController.agregarPaciente("Ana", "pass1", "ana@mail.com", "40111222", "1111-1111");
    pacienteController.agregarPaciente("Luis", "pass2", "luis@mail.com", "40222333", "2222-2222");
    pacienteController.agregarPaciente("Marta", "pass3", "marta@mail.com", "40333444", "3333-3333");

    
    System.out.println("\nListado de pacientes:");
    pacienteController.listarPacientes();


    System.out.println("\n test 2 - dni repetido");

    // este no deberia agregarse porque repite el DNI de Ana
    pacienteController.agregarPaciente("Carlos", "pass4", "carlos@mail.com", "40111222", "4444-4444");

    System.out.println("\nListado de pacientes (deberia ser igual al anterior):");
    System.out.println("   ");

    pacienteController.listarPacientes();



    System.out.println("\n test 3 - buscar por id");
    System.out.println("   ");
    System.out.println("paciente con id 1:");
    System.out.println(pacienteController.buscarPorId(1));


    System.out.println("paciente con ID 99 (no existe):");
    System.out.println(pacienteController.buscarPorId(99)); 



    System.out.println("\n test 4 - modifico paciente");
    System.out.println("   ");
    System.out.println("modificar paciente id 2 (luis)...");

        boolean modificado = pacienteController.modificarPaciente(
                2,
                "carlos menem",             // nuevoNombre
                "9999-9999",              // nuevoTelefono
                "carlos.menem@hotmail.com",    // nuevoCorreo
                null                      // nuevoDni (no lo cambia)
        );
    System.out.println("¿Modificado? " + modificado);

    System.out.println("\n Listado después de modificar:");
    pacienteController.listarPacientes();

    System.out.println("eliminar paciente");
    System.out.println("eliminando paciente con id 3 (marta)...");
    boolean eliminado = pacienteController.eliminarPorId(3);
    System.out.println("eliminado? " + eliminado);

    System.out.println("\n listado FINAL de pacientes:");
        pacienteController.listarPacientes();
    }



*/





    





    

























    // test de modificar especialidad de médico
    /*
        
    Especialidad pediatria = new Especialidad("Pediatria");

    Doctor d = new Doctor("roberto", "1234", "robertcarlos@mail.com", pediatria);

    System.out.println(d.getNombre());             // roberto
    System.out.println(d.getEspecialidad());       // especialidad
    System.out.println(d.getEspecialidad().getNombre()); // pediatría

    d.setNombre("Roberto Carlos");
    d.setEspecialidad(new Especialidad("Nanotecnologia"));

    System.out.println(d.getEspecialidad());

    */




    // test de clase Doctor + Especialidad
    /*
    
    Especialidad cardio = new Especialidad("Cardiologia");

    Doctor doctor1 = new Doctor("Mario", "pass123", "mario@mail.com", cardio);
    Doctor doctor2 = new Doctor("Lucía", "abc123", "lucia@mail.com", cardio);

    System.out.println(doctor1);
    System.out.println(doctor2);

    */





    
    // testear clase paciente y paciente controller

    // # comienzo de test

    /* 
    Paciente paciente1 = new Paciente("Ana", "123", "ana@mail.com", "40222333", "1122334455");
    System.out.println(paciente1);
    */    

    /*

    PacienteController pacienteController = new PacienteController();

    System.out.println("crear...:");

    pacienteController.agregarPaciente("Ana", "pass1", "ana@mail.com", "40111222", "111111111");

    pacienteController.agregarPaciente("Luis", "pass2", "luis@mail.com", "40222333", "222222222");

    pacienteController.agregarPaciente("Marta", "pass3", "marta@mail.com", "40333444", "333333333");


    pacienteController.listarPacientes();


    System.out.println("buscar...:");

    System.out.println(pacienteController.buscarPorId(3));

    System.out.println(pacienteController.buscarPorId(99)); 
    

    System.out.println("modificar...:");


    pacienteController.modificarPaciente(
                1,
                "Ana Gómez",         // nuevoNombre
                "1199-9999",         // nuevoTelefono
                "ana.gomez@mail.com",// nuevoCorreo
                null                 // nuevoDni
        );


        pacienteController.listarPacientes();
        
        System.out.println("eliminar...:");

        pacienteController.eliminarPorId(2);


        pacienteController.listarPacientes();
    


    // # fin de test

    */




    // testear especialidad controller

    // comienzo

    /*
    EspecialidadController controller = new EspecialidadController();
    
    controller.agregarEspecialidad("Cardiología");
    controller.agregarEspecialidad("Traumatología");
    controller.agregarEspecialidad("Neurología");

    // listar especialidades
    controller.listarEspecialidades();

    // modificar especialidad

    controller.modificarNombre(2, "Gastroenterología");

    controller.listarEspecialidades();

    // eliminar especialidad

    controller.eliminarPorId(1);

    controller.listarEspecialidades();

    */

    // fin











    // testear clase especialidad
    

    // # comienzo de test
    
    /*
    Especialidad e1 = new Especialidad("Cardiología");
    e1.setNombre("Cardiología");

    Especialidad e2 = new Especialidad("Traumatología");
    e2.setNombre("Traumatología");

    Especialidad e3 = new Especialidad("Neurología");
    e3.setNombre("Neurología");

        
    System.out.println("Id: " + e1.getId() + " - Nombre especialidad: " + e1.getNombre());     // 1

    System.out.println("Id: " + e2.getId() + " - Nombre especialidad: " + e2.getNombre());     // 2

    System.out.println("Id: " + e3.getId() + " - Nombre especialidad: " + e3.getNombre());     // 3

    */
        
    // # fin de test





    }

}
    


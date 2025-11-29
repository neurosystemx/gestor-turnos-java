package com.gestorturnos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

// importar controladores!
import com.gestorturnos.controller.EspecialidadController;

import com.gestorturnos.controller.PacienteController;

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
        




































    











    /* SECCION DE TEST !!!!!! */



    // test de doctor + DoctorController


    

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
    


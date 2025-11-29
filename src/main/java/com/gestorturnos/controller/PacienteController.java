package com.gestorturnos.controller;

import java.util.ArrayList;
import java.util.List;

import com.gestorturnos.Paciente;

public class PacienteController {

    private List<Paciente> pacientes;

    public PacienteController() {
        this.pacientes = new ArrayList<>();
    }

    // creacion paciente

    public Paciente agregarPaciente(String nombre, String password, String correo,
                                    String dni, String telefono) {

        // validacion para NO permitir dni repetido
        if (buscarPorDni(dni) != null) {
            System.out.println("Error: ya existe un paciente con el DNI " + dni);
            return null;
        }

        Paciente p = new Paciente(nombre, password, correo, dni, telefono);
        pacientes.add(p);
        return p;
    }

    // consultar pacientes

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public Paciente buscarPorId(int id) {
        for (Paciente p : pacientes) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public Paciente buscarPorDni(String dni) {
        for (Paciente p : pacientes) {
            if (p.getDni().equalsIgnoreCase(dni)) {
                return p;
            }
        }
        return null;
    }


    // modificar paciente

    // s/valorViejo/valorNuevo/

    // existe -> entra al if y lo modifica. Si no existe (p == null) → va a return false

    public boolean modificarPaciente(int id, String nuevoNombre, String nuevoTelefono, String nuevoCorreo, String nuevoDni) {
        Paciente p = buscarPorId(id);
        if (p != null) {
            if (nuevoNombre != null) p.setNombre(nuevoNombre);
            if (nuevoTelefono != null) p.setTelefono(nuevoTelefono);
            if (nuevoCorreo != null) p.setCorreo(nuevoCorreo);
            if (nuevoDni != null) p.setDni(nuevoDni);
            return true;
        }
        return false;
    }

    // borrar paciente (por id)

    public boolean eliminarPorId(int id) {
        Paciente p = buscarPorId(id);
        if (p != null) {
            return pacientes.remove(p);
        }
        return false;
    }

    // listar pacientes

    public void listarPacientes() {
        for (Paciente p : pacientes) {
            System.out.println(p); //  usa toString()
        }
    }
}

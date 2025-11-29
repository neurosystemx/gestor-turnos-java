package com.gestorturnos.controller;

import java.util.ArrayList;
import java.util.List;

import com.gestorturnos.Doctor;
import com.gestorturnos.Especialidad;


public class DoctorController {

    private List<Doctor> doctores;

    // constructor

    public DoctorController() {
        this.doctores = new ArrayList<>();
    }


    public Doctor agregarDoctor(String nombre, String password, String correo, Especialidad especialidad) {

        // Validación para NO permitir correos repetidos
        if (buscarPorCorreo(correo) != null) {
            System.out.println("Error: ya existe un doctor con el correo " + correo);
            return null;
        }

        Doctor d = new Doctor(nombre, password, correo, especialidad);
        doctores.add(d);
        return d;
    }


    // listar doctores

        public List<Doctor> getDoctores() {
        return doctores;

    }

    // buscar doctor por id

    //nota, id, nombre, password y correo vienen de "Usuario"! 

    public Doctor buscarPorId(int id) {
        for (Doctor d : doctores) {
            if (d.getId() == id) {
                return d;
            }
        }
        return null;
    }

    // buscar doctor por correo

    public Doctor buscarPorCorreo(String correo) {
        for (Doctor d : doctores) {
            if (d.getCorreo().equalsIgnoreCase(correo)) {
                return d;
            }
        }
        return null;
    }

    
    // buscar doctor por nombre

    public Doctor buscarPorNombre(String nombre) {
        for (Doctor d : doctores) {
            if (d.getNombre().equalsIgnoreCase(nombre)) {
                return d;
            }
        }
        return null;
    }


    // modificar doctor


    public boolean modificarDoctor(int id, String nuevoNombre, String nuevoCorreo, String nuevoPassword, Especialidad nuevaEspecialidad) {

        Doctor d = buscarPorId(id);

        // Si no existe el doctor, no se puede modificar

        if (d == null) {
            return false;
        }


        // mnodificar nombre


        if (nuevoNombre != null && !nuevoNombre.isBlank()) {
            d.setNombre(nuevoNombre);
        }

        // Modificar correo (validando duplicado)
        if (nuevoCorreo != null && !nuevoCorreo.isBlank()) {

            Doctor existente = buscarPorCorreo(nuevoCorreo);
            if (existente != null && existente.getId() != id) {
                System.out.println("error: el correo ya esta en uso por otro doctor.");
                return false;
            }

            d.setCorreo(nuevoCorreo);
        }

        // Modificar password
        if (nuevoPassword != null && !nuevoPassword.isBlank()) {
            d.setPassword(nuevoPassword);
        }

        // Cambiar especialidad
        if (nuevaEspecialidad != null) {
            d.setEspecialidad(nuevaEspecialidad);
        }

        return true;
    }


    // eliminar doctor

    public boolean eliminarPorId(int id) {
        Doctor d = buscarPorId(id);
        if (d != null) {
            return doctores.remove(d);
        }
        return false;
    }

    public void listarDoctores() {
        for (Doctor d : doctores) {
            System.out.println(d);
        }
    }
    
        

}

package com.gestorturnos.controller;

import java.util.ArrayList;
import java.util.List;

import com.gestorturnos.Especialidad;


public class EspecialidadController {

    private List<Especialidad> especialidades;
    
        public EspecialidadController() {
        this.especialidades = new ArrayList<>();
    }
    
    // crear especialidad
    public Especialidad agregarEspecialidad(String nombre) {
        Especialidad esp = new Especialidad(nombre);
        especialidades.add(esp);
        return esp;
    }

    // listar especialidades
    public List<Especialidad> getEspecialidades() {
        return especialidades;
    }

    // buscar especialidad usando id
    public Especialidad buscarPorId(int id) {
        for (Especialidad e : especialidades) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }

    // modificar nombre de especialidad
    public boolean modificarNombre(int id, String nuevoNombre) {
        Especialidad e = buscarPorId(id);
        if (e != null) {
            e.setNombre(nuevoNombre);
            return true;
        }
        return false;
    }

       
    // eliminar especialidad usando id
    public boolean eliminarPorId(int id) {
        Especialidad e = buscarPorId(id);
        if (e != null) {
            return especialidades.remove(e);
        }
        return false;
    }

    // mostrar en consola
    public void listarEspecialidades() {
        for (Especialidad e : especialidades) {
            System.out.println(e); // usa toString() de Especialidad
        }
    }

}

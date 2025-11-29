package com.gestorturnos;

public class Especialidad {

    private static int contadorIds = 1;   // autoincremental para los ids. arranca en 1 
    private int id;
    private String nombre;

    // constructor: solo recibe nombre, el ID se genera soloo

    public Especialidad(String nombre) {
        this.id = contadorIds++;   // asigna y luego incrementa
        this.nombre = nombre;
    }

    // getter

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    // setter
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    // para mostrar en listas o tabla

    @Override
    public String toString() {
        return "Especialidad{" + "id=" + id + ", nombre='" + nombre + '\'' + '}';
    }
    
}

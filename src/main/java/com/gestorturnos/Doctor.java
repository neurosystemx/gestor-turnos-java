package com.gestorturnos;



public class Doctor extends Usuario {


    private static int contadorIds = 1; // autoincremental para los ids. arranca en 1

    private Especialidad especialidad;    // relación: un doctor tiene una especialidad

    // constructor

    public Doctor(String nombre, String password, String correo, Especialidad especialidad) {

        // constructor de Usuario
        super(contadorIds++, nombre, password, correo);

        // un doctor tiene una especialidad
        this.especialidad = especialidad;

    }


    // Getter

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    // Setter
    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }


    // para mostrar en listas o tabla

    @Override
    public String toString() {
        return "[Doctor " + id + "] " + nombre + " especialidad: " + (especialidad != null ? especialidad.getNombre() : "sin asignar") + 
                " | correo: " + correo;
    }

}

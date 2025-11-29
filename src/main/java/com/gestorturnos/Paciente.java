package com.gestorturnos;

public class Paciente extends Usuario {

    private String dni;
    private String telefono;
    
    private static int contadorIds = 1; // autoincremental para los ids. arranca en 1

    public Paciente(String nombre, String password, String correo,
                    String dni, String telefono) {

        super(contadorIds++, nombre, password, correo);

        this.dni = dni;
        this.telefono = telefono;
    }

    // Getters
    

    public String getDni() {
        return dni;
    }

    public String getTelefono() {
        return telefono;
    }

    // Setters

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // para mostrar en listas o tabla

    @Override
    public String toString() {
        return "[paciente " + id + "] " + nombre + " | dni: " + dni + " | telefono: " + telefono;
    }
}

package com.gestorturnos;

public abstract class Usuario {


    /*accesiblwe para las subclases paciente y doctor  */

    protected int id;
    protected String nombre;
    protected String password;
    protected String correo;

    // constructor


    public Usuario(int id, String nombre, String password, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.password = password;
        this.correo = correo;
    }

    // Getters

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getPassword() {
        return password;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String mail) {
        this.correo = mail;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
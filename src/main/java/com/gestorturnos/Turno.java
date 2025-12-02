package com.gestorturnos;


import java.time.LocalDateTime;

public class Turno {

    public enum EstadoTurno {PENDIENTE,CONFIRMADO,ATENDIDO,AUSENTE,CANCELADO}

    private static int contadorIds = 1; // autoincremental para los ids. arranca en  1

    private int id;


    private Doctor doctorAsignado;
    private Paciente paciente;
    private EstadoTurno estado;       // PENDIENTE (default), CONFIRMADO, ATENDIDO, AUSENTE, CANCELADO
    private LocalDateTime fecha;         // fecha y hora del turno

    // constructor

    // fix, el constructor no lleva id.
    public Turno(Doctor doctorAsignado,Paciente paciente,EstadoTurno estado,LocalDateTime fecha) {

        this.id = contadorIds++;
        this.doctorAsignado = doctorAsignado;
        this.paciente = paciente;
        this.estado = estado;
        this.fecha = fecha;
    }

    // getters

    public int getId() {
        return id;
    }

    public Doctor getDoctorAsignado() {
        return doctorAsignado;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public EstadoTurno getEstado() {
        return estado;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    // setters

    public void setId(int id) {
        this.id = id;
    }

    public void setDoctorAsignado(Doctor doctorAsignado) {
        this.doctorAsignado = doctorAsignado;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public void setEstado(EstadoTurno estado) {
        this.estado = estado;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }


    // metodos para checkear turnos

    public boolean estaConfirmado() {
        return this.estado == EstadoTurno.CONFIRMADO;
    }

    public boolean estaPendiente() {
        return this.estado == EstadoTurno.PENDIENTE;
    }

    public boolean estaCancelado() {
        return this.estado == EstadoTurno.CANCELADO;
    }


    // para mostrar en listas o tabla

    
    @Override
    public String toString() {
        return "Turno{" + "id=" + id +
                ", doctor=" + (doctorAsignado != null ? doctorAsignado.getNombre() : "n/a") + ", paciente=" + (paciente != null ? paciente.getNombre() : "n/a") +
                ", estado=" + estado + ", fecha=" + fecha +'}';
    }
}

package com.gestorturnos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.gestorturnos.Turno.EstadoTurno;



// La agenda consiste en bloques de media hora desde 9am a 18hs.
// son 18 bloques en todo el dia


public class Agenda {

    // valores constantes para los bloques de tiempo

    public static final LocalTime Hora_inicio = LocalTime.of(9, 0); // arrancan los turnos a las 9am
    public static final LocalTime Hora_fin = LocalTime.of(18, 0); // hora final del dia (NO SE DAN TURNOS PARA LAS 18!)
    public static final int Duracion_minutos  = 30; // bloques para turnos de 30 minutos

    // Atributos

    private static int contadorIds = 1; // autoincremental para Agenda
    private int id;


    private Doctor doctorAsignado;     // doctor al que pertenece esta agenda
    private LocalDate fecha;           // día específico de la agenda
    private List<Turno> turnosDelDia;  // los 18 turnos del día



    // Constructor


    /**
     * Crea una agenda para un doctor en una fecha determinada.
     * Genera automáticamente los turnos fijos de media hora entre 9:00 y 17:30.
     */
    public Agenda(Doctor doctorAsignado, LocalDate fecha) {
        this.id = contadorIds++;
        this.doctorAsignado = doctorAsignado;
        this.fecha = fecha;
        this.turnosDelDia = generarTurnosDelDia();
    }


    // Métodos privados


    /**
     * Genera la lista de turnos del día, con horarios fijos cada 30 minutos.
     * Los turnos se crean con paciente = null y estado PENDIENTE.
     */
    private List<Turno> generarTurnosDelDia() {
        List<Turno> lista = new ArrayList<>();

        LocalTime horaActual = Hora_inicio;

        // genera turnos desde 9:00 hasta antes de las 18:00
        //  Hora_fin = LocalTime.of(18, 0);

        while (horaActual.isBefore(Hora_fin)) {
            LocalDateTime fechaHora = LocalDateTime.of(fecha, horaActual);

            // Constructor real de turno:
            // Turno(Doctor doctorAsignado, Paciente paciente, EstadoTurno estado, LocalDateTime fecha)
            Turno turno = new Turno(
                    doctorAsignado,
                    null,   //  sin paciente hasta que no se elija
                    EstadoTurno.PENDIENTE,     // estado inicial
                    fechaHora
            );

            lista.add(turno);
            horaActual = horaActual.plusMinutes(Duracion_minutos);
        }

        return lista;
    }

    /**
     * Devuelve el Turno que corresponde a una hora específica (por ejemplo 9:00, 9:30, etc.).
     * Si la hora no coincide con ningún slot, devuelve null.
     */
    private Turno buscarTurnoPorHora(LocalTime hora) {
        for (Turno t : turnosDelDia) {
            LocalTime horaTurno = t.getFecha().toLocalTime();
            if (horaTurno.equals(hora)) {
                return t;
            }
        }
        return null;
    }

    // =====================
    // Métodos de "negocio"
    // =====================

    /**
     * Intenta reservar un turno para un paciente en una hora determinada.
     * - Solo permite reservar si:
     *   - la hora pertenece a uno de los slots de la agenda
     *   - el turno no tiene paciente asignado
     *   - el estado está en PENDIENTE
     *
     * @return true si se pudo reservar, false si no.
     */
    public boolean reservarTurno(LocalTime hora, Paciente paciente) {
        Turno turno = buscarTurnoPorHora(hora);
        if (turno == null) {
            return false; // hora inválida para esta agenda
        }

        if (turno.getPaciente() == null && turno.estaPendiente()) {
            turno.setPaciente(paciente);
            turno.setEstado(EstadoTurno.CONFIRMADO);
            return true;
        }

        return false; // ya tenía paciente o no está en estado adecuado
    }

    /**
     * Cancela un turno en una hora dada, si existe y tiene paciente asignado.
     */
    public boolean cancelarTurno(LocalTime hora) {
        Turno turno = buscarTurnoPorHora(hora);
        if (turno == null) {
            return false;
        }

        if (turno.getPaciente() != null) {
            turno.setEstado(EstadoTurno.CANCELADO);
            return true;
        }

        return false;
    }

    /**
     * Devuelve una lista de turnos que no tienen paciente asignado
     * (slots disponibles).
     */
    public List<Turno> obtenerTurnosDisponibles() {
        List<Turno> disponibles = new ArrayList<>();
        for (Turno t : turnosDelDia) {
            if (t.getPaciente() == null && t.estaPendiente()) {
                disponibles.add(t);
            }
        }
        return disponibles;
    }

    // =======
    // Getters
    // =======

    public int getId() {
        return id;
    }

    public Doctor getDoctorAsignado() {
        return doctorAsignado;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public List<Turno> getTurnosDelDia() {
        return turnosDelDia;
    }

    // =======
    // Setters
    // =======

    public void setDoctorAsignado(Doctor doctorAsignado) {
        this.doctorAsignado = doctorAsignado;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setTurnosDelDia(List<Turno> turnosDelDia) {
        this.turnosDelDia = turnosDelDia;
    }






    }







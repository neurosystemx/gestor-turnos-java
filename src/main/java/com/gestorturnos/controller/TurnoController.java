package com.gestorturnos.controller;

import com.gestorturnos.*;
import com.gestorturnos.Turno.EstadoTurno;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TurnoController {

    // lista de turnos
    private List<Turno> turnos = new ArrayList<>();

    //agregar turno
    public void agregarTurno(Turno turno) {
        turnos.add(turno);
    }

    // borrar turno directamente (sin buscar por ID)
    public boolean borrarTurno(Turno turno) {
        return turnos.remove(turno);
    }

    // listar turnos
    public List<Turno> getTurnos() {
        return turnos;
    }


    // listar turnos por doctor (si tiene uno asignado!)

        public List<Turno> getTurnosPorDoctor(Doctor doctor) {
            // instanciar y recorrer con for
        List<Turno> resultado = new ArrayList<>();
        for (Turno t : turnos) {
            if (t.getDoctorAsignado().equals(doctor)) {
                resultado.add(t);
            }
        }
        return resultado;
    }

        //turnos por paciente

    public List<Turno> getTurnosPorPaciente(Paciente paciente) {
        List<Turno> resultado = new ArrayList<>();
        for (Turno t : turnos) {
            if (t.getPaciente() != null && t.getPaciente().equals(paciente)) {
                resultado.add(t);
            }
        }
        return resultado;
    }



    // turno por fecha
    public List<Turno> getTurnosPorFecha(LocalDate fecha) {
        List<Turno> resultado = new ArrayList<>();
        for (Turno t : turnos) {
            if (t.getFecha().toLocalDate().equals(fecha)) {
                resultado.add(t);
            }
        }
        return resultado;
    }


    // manejo de estados del turno

    // cambiar estado → confirmar
    public void confirmarTurno(Turno turno) {
        turno.setEstado(EstadoTurno.CONFIRMADO);
    }

    // cambiar estado → cancelar
    public void cancelarTurno(Turno turno) {
        turno.setEstado(EstadoTurno.CANCELADO);
    }

    // cambiar estado → atendido
    public void marcarAtendido(Turno turno) {
        turno.setEstado(EstadoTurno.ATENDIDO);
    }

    //  cambiar estado → ausente
    public void marcarAusente(Turno turno) {
        turno.setEstado(EstadoTurno.AUSENTE);
    }

}

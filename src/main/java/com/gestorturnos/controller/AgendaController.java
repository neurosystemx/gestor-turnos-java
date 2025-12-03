package com.gestorturnos.controller;

import java.time.LocalDate;
import java.time.LocalTime;

import com.gestorturnos.Agenda;
import com.gestorturnos.Doctor;
import com.gestorturnos.Paciente;
import com.gestorturnos.Turno;

public class AgendaController {















    



/* NO usar 
    public boolean validarReserva(Doctor doctor, Paciente paciente, LocalDate fecha, LocalTime hora) {

    // 1) Mismo doctor + misma fecha + misma hora
    Agenda agendaDelDoctor = getTurnos(doctor, fecha);
    for (Turno t : agendaDelDoctor.getTurnos()) {
        if (t.getFecha().toLocalTime().equals(hora)) {

            // Si NO está pendiente, entonces el slot ya está ocupado
            if (!t.estaPendiente()) {
                return false;
            }

            // Si mismo paciente intenta reservar el mismo turno → NO
            if (t.getPaciente() != null && t.getPaciente().equals(paciente)) {
                return false;
            }
        }
    }

    // 2) Mismo paciente + misma hora en cualquier agenda
    for (Agenda ag : agendas.values()) {

        // solo revisar agendas del MISMO DÍA
        if (!ag.getFecha().equals(fecha)) continue;

        for (Turno t : ag.getTurnos()) {

            if (t.getFecha().toLocalTime().equals(hora)) {

                // Si el paciente tiene turno NO pendiente → NO
                if (t.getPaciente() != null && t.getPaciente().equals(paciente)) {
                    if (!t.estaPendiente()) {
                        return false; // ya tiene un turno firme en ese horario
                    }
                }
            }
        }
    }

    // Pasa todas las validaciones → se puede reservar
    return true;
  
    }

    */


}

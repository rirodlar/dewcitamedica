/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.citasmedicas.service;

import java.util.Date;
import java.util.List;
import pe.com.citasmedicas.model.Cita;
import pe.com.citasmedicas.model.Especialidad;
import pe.com.citasmedicas.model.Horario;
import pe.com.citasmedicas.model.Medico;
import pe.com.citasmedicas.model.Paciente;
import pe.com.citasmedicas.model.Persona;

/**
 *
 * @author rSaenz
 */
public interface CitaService {

    /**
     * Actualiza una cita
     * @param Cita cita
     * @return boolean
     */
    boolean actualizarCita(Cita cita);

    /**
     * Elimina una cita
     * @param Cita cita
     * @return boolean
     */
    boolean eliminarCita(Cita cita);

    /**
     * Obtiene la cita de un horario específico
     * @param Horario horario
     * @return Cita
     */
    Cita getCitaPorHorario(Horario horario);

    /**
     * Obtiene la cita de un horario específico
     * @param Integer horarioId
     * @return Cita
     */
    Cita getCitaPorHorario(Integer horarioId);

    /**
     * Obtiene una cita por su id
     * @param Integer citaId
     * @return Cita
     */
    Cita getCitaPorId(Integer citaId);

    /**
     * Obtiene la cita pendiente de un paciente para una semana, medico y especialidad
     * @param Paciente paciente
     * @param Date fechaInicio
     * @param Date fechaFin
     * @param Medico medico
     * @param Especialidad especialidad
     * @return Cita
     */
    Cita getCitaSemPendiente(Paciente paciente, Date fechaInicio, Date fechaFin, Medico medico, Especialidad especialidad);

    /**
     * Obtiene la cita pendiente de un paciente para una semana, medico y especialidad
     * @param Integer pacienteId
     * @param Date fechaInicio
     * @param Date fechaFin
     * @param Integer medicoId
     * @param Integer especialidadId
     * @return Cita
     */
    Cita getCitaSemPendiente(Integer pacienteId, Date fechaInicio, Date fechaFin, Integer medicoId, Integer especialidadId);

    /**
     * Obtiene todos las citas pendientes de un paciente
     * @param Persona paciente
     * @return List<Cita>
     */
    List<Cita> getCitasPendientes(Persona paciente);

    /**
     * Obtiene todos las citas pendientes de un paciente
     * @param Integer pacienteId
     * @return List<Cita>
     */
    List<Cita> getCitasPendientes(Integer pacienteId);

    /**
     * Obtiene todos las citas de un médico para una fecha específica
     * @param Medico medico
     * @param Date fecha
     * @param boolean validaHora
     * @return List<Cita>
     */
    List<Cita> getCitasPorMedicoFecha(Medico medico, Date fecha, boolean validaHora);

    /**
     * Obtiene todos las citas de un médico para una fecha específica
     * @param Integer medicoId
     * @param Date fecha
     * @param boolean validaHora
     * @return List<Cita>
     */
    List<Cita> getCitasPorMedicoFecha(Integer medicoId, Date fecha, boolean validaHora);

    /**
     * Obtiene todos las citas de un médico para una fecha específica
     * @param Paciente paciente
     * @param Date fecha
     * @param boolean validaHora
     * @return List<Cita>
     */
    List<Cita> getCitasPorPacienteFecha(Paciente paciente, Date fecha, boolean validaHora);

    /**
     * Obtiene todos las citas de un médico para una fecha específica
     * @param Integer paciente
     * @param Date fecha
     * @param boolean validaHora
     * @return List<Cita>
     */
    List<Cita> getCitasPorPacienteFecha(Integer pacienteId, Date fecha, boolean validaHora);

    /**
     * Ingresa una cita
     * @param Paciente paciente
     * @param Horario horario
     * @return boolean
     */
    boolean insertarCita(Paciente paciente, Horario horario) throws Exception;

}

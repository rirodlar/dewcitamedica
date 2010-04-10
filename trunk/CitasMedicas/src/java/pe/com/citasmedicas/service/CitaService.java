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
 * Esta clase contiene los métodos a ser implementados por las clases de servicio
 * @author dew - Grupo 04
 */
public interface CitaService {

    /**
     * Actualiza una cita
     * @param cita
     * @return boolean
     */
    boolean actualizarCita(Cita cita);

    /**
     * Elimina una cita
     * @param cita
     * @return boolean
     */
    boolean eliminarCita(Cita cita);

    /**
     * Obtiene la cita de un horario específico
     * @param horario
     * @return Cita
     */
    Cita getCitaPorHorario(Horario horario);

    /**
     * Obtiene la cita de un horario específico
     * @param horarioId
     * @return Cita
     */
    Cita getCitaPorHorario(Integer horarioId);

    /**
     * Obtiene una cita por su id
     * @param citaId
     * @return Cita
     */
    Cita getCitaPorId(Integer citaId);

    /**
     * Obtiene la cita pendiente de un paciente para una semana, medico y especialidad
     * @param paciente
     * @param fechaInicio
     * @param fechaFin
     * @param medico
     * @param especialidad
     * @return Cita
     */
    Cita getCitaSemPendiente(Paciente paciente, Date fechaInicio, Date fechaFin, Medico medico, Especialidad especialidad);

    /**
     * Obtiene la cita pendiente de un paciente para una semana, medico y especialidad
     * @param pacienteId 
     * @param fechaInicio 
     * @param fechaFin
     * @param medicoId
     * @param especialidadId
     * @return Cita
     */
    Cita getCitaSemPendiente(Integer pacienteId, Date fechaInicio, Date fechaFin, Integer medicoId, Integer especialidadId);

    /**
     * Obtiene todos las citas pendientes de un paciente
     * @param paciente
     * @return List<Cita>
     */
    List<Cita> getCitasPendientes(Persona paciente);

    /**
     * Obtiene todos las citas pendientes de un paciente
     * @param pacienteId
     * @return List<Cita>
     */
    List<Cita> getCitasPendientes(Integer pacienteId);

    /**
     * Obtiene todos las citas de un médico para una fecha específica
     * @param medico 
     * @param fecha
     * @param validaHora
     * @return List<Cita>
     */
    List<Cita> getCitasPorMedicoFecha(Medico medico, Date fecha, boolean validaHora);

    /**
     * Obtiene todos las citas de un médico para una fecha específica
     * @param medicoId
     * @param fecha
     * @param validaHora
     * @return List<Cita>
     */
    List<Cita> getCitasPorMedicoFecha(Integer medicoId, Date fecha, boolean validaHora);

    /**
     * Obtiene todos las citas de un médico para una fecha específica
     * @param paciente
     * @param fecha
     * @param validaHora
     * @return List<Cita>
     */
    List<Cita> getCitasPorPacienteFecha(Paciente paciente, Date fecha, boolean validaHora);

    /**
     * Obtiene todos las citas de un médico para una fecha específica
     * @param pacienteId 
     * @param fecha
     * @param validaHora
     * @return List<Cita>
     */
    List<Cita> getCitasPorPacienteFecha(Integer pacienteId, Date fecha, boolean validaHora);

    /**
     * Ingresa una cita
     * @param paciente
     * @param horario
     * @return boolean
     * @throws Exception
     */
    boolean insertarCita(Paciente paciente, Horario horario) throws Exception;

}

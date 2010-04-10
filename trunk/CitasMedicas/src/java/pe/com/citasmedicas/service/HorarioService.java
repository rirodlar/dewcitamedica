/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.citasmedicas.service;

import java.util.Date;
import java.util.List;
import pe.com.citasmedicas.model.Especialidad;
import pe.com.citasmedicas.model.Horario;
import pe.com.citasmedicas.model.Medico;

/**
 * Esta clase contiene los métodos a ser implementados por las clases de servicio
 * @author dew - Grupo 04
 */
public interface HorarioService {

    /**
     * Actualiza un horario
     * @param horario
     * @return boolean
     */
    boolean actualizarHorario(Horario horario);

    /**
     * Elimina un horario
     * @param horario
     * @return boolean
     */
    boolean eliminarHorario(Horario horario);

    /**
     *
     * @return
     */
    List<Horario> getHorarioAtencion();

    /**
     * Obtiene un horario por su id
     * @param horarioId 
     * @return Horario
     */
    Horario getHorarioPorId(Integer horarioId);

    /**
     * Obtiene todos los horarios de un médico para una especialidad y fecha específica
     * @param especialidad
     * @param medico
     * @param fecha
     * @return List<Horario>
     */
    List<Horario> getHorariosPorEspecMedicoFecha(Especialidad especialidad, Medico medico, Date fecha);

    /**
     * Obtiene todos los horarios de un médico para una especialidad y fecha específica
     * @param especialidadId
     * @param medicoId
     * @param fecha
     * @return List<Horario>
     */
    List<Horario> getHorariosPorEspecMedicoFecha(Integer especialidadId, Integer medicoId, Date fecha);

}

package pe.com.citasmedicas.dao;

import java.util.Date;
import java.util.List;
import pe.com.citasmedicas.model.Especialidad;
import pe.com.citasmedicas.model.Horario;
import pe.com.citasmedicas.model.Medico;

/**
 * Esta clase contiene los métodos a ser implementados por las clases de persistencia
 * @author dew - Grupo 04
 */
public interface HorarioDao {

    /**
     * Actualiza un horario
     * @param horario datos del horario
     * @return boolean Condicion de actualizacion -> true=exito/false=fracaso
     */
    boolean actualizarHorario(Horario horario);

    /**
     * Elimina un horario
     * @param horario datos del horario
     * @return boolean Condicion de actualizacion -> true=exito/false=fracaso
     */
    boolean eliminarHorario(Horario horario);

    /**
     * Obtiene el horario de atencion
     * @return lista de horarios
     */
    List<Horario> getHorarioAtencion();

    /**
     * Obtiene un horario por su id
     * @param horarioId identificador del horario
     * @return Horario datos del horario
     */
    Horario getHorarioPorId(Integer horarioId);

    /**
     * Obtiene todos los horarios de un médico para una especialidad y fecha específica
     * @param especialidad datos de la especialidad
     * @param medico datos del medico
     * @param fecha Fecha del horario
     * @return List<Horario> lista de horarios encontrados
     */
    List<Horario> getHorariosPorEspecMedicoFecha(Especialidad especialidad, Medico medico, Date fecha);

    /**
     * Obtiene todos los horarios de un médico para una especialidad y fecha específica
     * @param especialidadId identificador de la especialidad
     * @param medicoId identificador del medico
     * @param fecha fecha del horario
     * @return List<Horario> lista de horarios encontrados
     */
    List<Horario> getHorariosPorEspecMedicoFecha(Integer especialidadId, Integer medicoId, Date fecha);

}

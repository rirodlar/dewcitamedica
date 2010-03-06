package pe.com.citasmedicas.dao;

import java.util.Date;
import java.util.List;
import pe.com.citasmedicas.model.Especialidad;
import pe.com.citasmedicas.model.Horario;
import pe.com.citasmedicas.model.Medico;

/**
 *
 * @author dew - Grupo 04
 */
public interface HorarioDao {

    /**
     * Actualiza un horario
     * @param Horario horario
     * @return boolean
     */
    boolean actualizarHorario(Horario horario);

    /**
     * Elimina un horario
     * @param Horario horario
     * @return boolean
     */
    boolean eliminarHorario(Horario horario);

    List<Horario> getHorarioAtencion();

    /**
     * Obtiene un horario por su id
     * @param Integer horarioId
     * @return Horario
     */
    Horario getHorarioPorId(Integer horarioId);

    /**
     * Obtiene todos los horarios de un médico para una especialidad y fecha específica
     * @param Especialidad especialidad
     * @param Medico medico
     * @param Date fecha
     * @return List<Horario>
     */
    List<Horario> getHorariosPorEspecMedicoFecha(Especialidad especialidad, Medico medico, Date fecha);

    /**
     * Obtiene todos los horarios de un médico para una especialidad y fecha específica
     * @param Integer especialidadId
     * @param Integer medicoId
     * @param Date fecha
     * @return List<Horario>
     */
    List<Horario> getHorariosPorEspecMedicoFecha(Integer especialidadId, Integer medicoId, Date fecha);

}

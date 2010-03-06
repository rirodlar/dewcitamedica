package pe.com.citasmedicas.dao;

import java.util.List;
import pe.com.citasmedicas.model.Especialidad;
import pe.com.citasmedicas.model.Medico;

/**
 *
 * @author dew - Grupo 04
 */
public interface MedicoDao {

    /**
     * Obtiene un médico por su id
     * @param Integer medicoId
     * @return Medico
     */
    Medico getMedicoPorId(Integer medicoId);

    /**
     * Obtiene todas los médicos de una especialidad específica
     * @param Especialidad especialidad
     * @return List<Medico>
     */
    List<Medico> getMedicosPorEspecialidad(Especialidad especialidad);

    /**
     * Obtiene todas los médicos de una especialidad específica
     * @param Integer especialidadId
     * @return List<Medico>
     */
    List<Medico> getMedicosPorEspecialidad(Integer especialidadId);

}

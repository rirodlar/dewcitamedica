package pe.com.citasmedicas.dao;

import java.util.List;
import pe.com.citasmedicas.model.Especialidad;

/**
 *
 * @author dew - Grupo 04
 */
public interface EspecialidadDao {

    /**
     * Obtiene una especialidad por su id
     * @param Integer especialidadId
     * @return Especialidad
     */
    Especialidad getEspecialidadPorId(Integer especialidadId);

    /**
     * Obtiene todas las especialidades registradas
     * @return List<Especialidad>
     */
    List<Especialidad> getEspecialidades();

}

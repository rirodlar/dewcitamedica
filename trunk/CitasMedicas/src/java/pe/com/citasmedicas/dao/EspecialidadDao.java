package pe.com.citasmedicas.dao;

import java.util.List;
import pe.com.citasmedicas.model.Especialidad;

/**
 * Esta clase contiene los métodos a ser implementados por las clases de persistencia
 * @author dew - Grupo 04
 */
public interface EspecialidadDao {

    /**
     * Obtiene una especialidad por su id
     * @param especialidadId identificador de especialidad
     * @return Especialidad datos de la especialidad
     */
    Especialidad getEspecialidadPorId(Integer especialidadId);

    /**
     * Obtiene todas las especialidades registradas
     * @return List<Especialidad> lista de especialidad
     */
    List<Especialidad> getEspecialidades();

}

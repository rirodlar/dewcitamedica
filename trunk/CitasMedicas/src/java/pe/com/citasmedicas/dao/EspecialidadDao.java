package pe.com.citasmedicas.dao;

import java.util.List;
import pe.com.citasmedicas.model.CargaData;
import pe.com.citasmedicas.model.Especialidad;

/**
 *
 * @author dew - Grupo 04
 */
public class EspecialidadDao {

    /**
     * Obtiene todas las especialidades registradas
     * @return List<Especialidad>
     */
    public List<Especialidad> getEspecialidades() {
        return CargaData.ESPECIALIDADES;
    }

    /**
     * Obtiene una especialidad por su id
     * @param Integer especialidadId
     * @return Especialidad
     */
    public Especialidad getEspecialidadPorId(Integer especialidadId) {
        if (especialidadId == null) {
            return null;
        }
        Especialidad especialidad = null;
        for (Especialidad especialidadAux : getEspecialidades()) {
            if (especialidadAux.getEspecialidadId().intValue() == especialidadId.intValue()) {
                especialidad = especialidadAux;
                break;
            }
        }
        return especialidad;
    }
}

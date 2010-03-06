package pe.com.citasmedicas.service.implement;

import pe.com.citasmedicas.service.*;
import java.util.List;
import pe.com.citasmedicas.dao.EspecialidadDao;
import pe.com.citasmedicas.dao.hibernate.EspecialidadDaoHbn;
import pe.com.citasmedicas.model.Especialidad;

/**
 *
 * @author dew - Grupo 04
 */
public class EspecialidadServiceImpl implements EspecialidadService {

    private EspecialidadDao especialidadDao;

    public EspecialidadServiceImpl() {
        especialidadDao = new EspecialidadDaoHbn();
    }

    /**
     * Obtiene todas las especialidades registradas
     * @return List<Especialidad>
     */
    public List<Especialidad> getEspecialidades() {
        return especialidadDao.getEspecialidades();
    }

    /**
     * Obtiene una especialidad por su id
     * @param Integer especialidadId
     * @return Especialidad
     */
    public Especialidad getEspecialidadPorId(Integer especialidadId) {
        return especialidadDao.getEspecialidadPorId(especialidadId);
    }
}

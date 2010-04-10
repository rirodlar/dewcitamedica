package pe.com.citasmedicas.service.implement;

import pe.com.citasmedicas.service.EspecialidadService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.citasmedicas.dao.EspecialidadDao;
import pe.com.citasmedicas.model.Especialidad;

/**
 * Esta clase contiene los métodos de servicio implementados
 * @author dew - Grupo 04
 */
@Service
public class EspecialidadServiceImpl implements EspecialidadService {

    private EspecialidadDao especialidadDao;

    /**
     * Obtiene todas las especialidades registradas
     * @return List<Especialidad>
     */
    @Override
    public List<Especialidad> getEspecialidades() {
        return especialidadDao.getEspecialidades();
    }

    /**
     * Obtiene una especialidad por su id
     * @return Especialidad
     */
    @Override
    public Especialidad getEspecialidadPorId(Integer especialidadId) {
        return especialidadDao.getEspecialidadPorId(especialidadId);
    }

    /**
     * @param especialidadDao the especialidadDao to set
     */
    @Autowired
    public void setEspecialidadDao(EspecialidadDao especialidadDao) {
        this.especialidadDao = especialidadDao;
    }
}

package pe.com.citasmedicas.service.implement;

import pe.com.citasmedicas.service.MedicoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.citasmedicas.dao.MedicoDao;
import pe.com.citasmedicas.model.Especialidad;
import pe.com.citasmedicas.model.Medico;

/**
 *
 * @author dew - Grupo 04
 */
@Service
public class MedicoServiceImpl implements MedicoService {

    private MedicoDao medicoDao;

    /**
     * Obtiene un médico por su id
     * @param Integer medicoId
     * @return Medico
     */
    public Medico getMedicoPorId(Integer medicoId) {
        return medicoDao.getMedicoPorId(medicoId);
    }

    /**
     * Obtiene todas los médicos de una especialidad específica
     * @param Especialidad especialidad
     * @return List<Medico>
     */
    public List<Medico> getMedicosPorEspecialidad(Especialidad especialidad) {
        return medicoDao.getMedicosPorEspecialidad(especialidad);
    }

    /**
     * Obtiene todas los médicos de una especialidad específica
     * @param Integer especialidadId
     * @return List<Medico>
     */
    public List<Medico> getMedicosPorEspecialidad(Integer especialidadId) {
        return medicoDao.getMedicosPorEspecialidad(especialidadId);
    }

    /**
     * @param medicoDao the medicoDao to set
     */
    @Autowired
    public void setMedicoDao(MedicoDao medicoDao) {
        this.medicoDao = medicoDao;
    }
}

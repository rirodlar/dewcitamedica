package pe.com.citasmedicas.service.implement;

import pe.com.citasmedicas.service.HorarioService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.citasmedicas.dao.HorarioDao;
import pe.com.citasmedicas.model.Especialidad;
import pe.com.citasmedicas.model.Horario;
import pe.com.citasmedicas.model.Medico;

/**
 * Esta clase contiene los métodos de servicio implementados
 * @author dew - Grupo 04
 */
@Service
public class HorarioServiceImpl implements HorarioService {

    private HorarioDao horarioDao;

    /**
     * Obtiene un horario por su id
     * @return Horario
     */
    @Override
    public Horario getHorarioPorId(Integer horarioId) {
        return horarioDao.getHorarioPorId(horarioId);
    }

    /**
     * Obtiene todos los horarios de un médico para una especialidad y fecha específica
     * @return List<Horario>
     */
    @Override
    public List<Horario> getHorariosPorEspecMedicoFecha(Especialidad especialidad, Medico medico, Date fecha) {
        return horarioDao.getHorariosPorEspecMedicoFecha(especialidad, medico, fecha);
    }

    /**
     * Obtiene todos los horarios de un médico para una especialidad y fecha específica
     * @return List<Horario>
     */
    @Override
    public List<Horario> getHorariosPorEspecMedicoFecha(Integer especialidadId, Integer medicoId, Date fecha) {
        return horarioDao.getHorariosPorEspecMedicoFecha(especialidadId, medicoId, fecha);
    }


    @Override
    public List<Horario> getHorarioAtencion() {
        return horarioDao.getHorarioAtencion();
    }

    /**
     * Elimina un horario
     * @return boolean
     */
    @Override
    public boolean eliminarHorario(Horario horario) {
        return horarioDao.eliminarHorario(horario);
    }

    /**
     * Actualiza un horario
     * @return boolean
     */
    @Override
    public boolean actualizarHorario(Horario horario) {
        return horarioDao.actualizarHorario(horario);
    }

    /**
     * @param horarioDao the horarioDao to set
     */
    @Autowired
    public void setHorarioDao(HorarioDao horarioDao) {
        this.horarioDao = horarioDao;
    }

}

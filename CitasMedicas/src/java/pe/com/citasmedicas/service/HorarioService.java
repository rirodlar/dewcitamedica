package pe.com.citasmedicas.service;

import java.util.Date;
import java.util.List;
import pe.com.citasmedicas.dao.HorarioDao;
import pe.com.citasmedicas.model.Especialidad;
import pe.com.citasmedicas.model.Horario;
import pe.com.citasmedicas.model.Medico;

/**
 *
 * @author dew - Grupo 04
 */
public class HorarioService {

    private HorarioDao horarioDao;

    public HorarioService() {
        horarioDao = new HorarioDao();
    }

    /**
     * Obtiene un horario por su id
     * @param Integer horarioId
     * @return Horario
     */
    public Horario getHorarioPorId(Integer horarioId) {
        return horarioDao.getHorarioPorId(horarioId);
    }

    /**
     * Obtiene todos los horarios de un médico para una especialidad y fecha específica
     * @param Especialidad especialidad
     * @param Medico medico
     * @param Date fecha
     * @return List<Horario>
     */
    public List<Horario> getHorariosPorEspecMedicoFecha(Especialidad especialidad, Medico medico, Date fecha) {
        return horarioDao.getHorariosPorEspecMedicoFecha(especialidad, medico, fecha);
    }

    /**
     * Obtiene todos los horarios de un médico para una especialidad y fecha específica
     * @param Integer especialidadId
     * @param Integer medicoId
     * @param Date fecha
     * @return List<Horario>
     */
    public List<Horario> getHorariosPorEspecMedicoFecha(Integer especialidadId, Integer medicoId, Date fecha) {
        return horarioDao.getHorariosPorEspecMedicoFecha(especialidadId, medicoId, fecha);
    }


    public List<Horario> getHorarioAtencion() {
        return horarioDao.getHorarioAtencion();
    }

    /**
     * Elimina un horario
     * @param Horario horario
     * @return boolean
     */
    public boolean eliminarHorario(Horario horario) {
        return horarioDao.eliminarHorario(horario);
    }

    /**
     * Actualiza un horario
     * @param Horario horario
     * @return boolean
     */
    public boolean actualizarHorario(Horario horario) {
        return horarioDao.actualizarHorario(horario);
    }

}

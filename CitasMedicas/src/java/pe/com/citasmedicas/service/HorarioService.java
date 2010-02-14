/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
}

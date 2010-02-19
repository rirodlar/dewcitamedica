package pe.com.citasmedicas.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import pe.com.citasmedicas.model.CargaData;
import pe.com.citasmedicas.model.Especialidad;
import pe.com.citasmedicas.model.Horario;
import pe.com.citasmedicas.model.Medico;

/**
 *
 * @author dew - Grupo 04
 */
public class HorarioDao {

    /**
     * Obtiene un horario por su id
     * @param Integer horarioId
     * @return Horario
     */
    public Horario getHorarioPorId(Integer horarioId) {
        if (horarioId == null) {
            return null;
        }
        Horario horario = null;
        for (Horario horarioAux : CargaData.HORARIOS) {
            if (horarioAux.getHorarioId().intValue() == horarioId.intValue()) {
                horario = horarioAux;
                break;
            }
        }
        return horario;
    }

    /**
     * Obtiene todos los horarios de un médico para una especialidad y fecha específica
     * @param Especialidad especialidad
     * @param Medico medico
     * @param Date fecha
     * @return List<Horario>
     */
    public List<Horario> getHorariosPorEspecMedicoFecha(Especialidad especialidad, Medico medico, Date fecha) {
        if (especialidad == null || medico == null || fecha == null) {
            return new ArrayList<Horario>();
        }
        List<Horario> horarios = new ArrayList<Horario>();
        for (Horario horarioAux : CargaData.HORARIOS) {
            if (horarioAux.getEspecialidad().equals(especialidad) && horarioAux.getMedico().equals(medico)) {
                Calendar calH = new GregorianCalendar();
                calH.setTime(horarioAux.getFechaInicio());
                Calendar calP = new GregorianCalendar();
                calP.setTime(fecha);
                if (calH.get(Calendar.DATE) == calP.get(Calendar.DATE) &&
                    calH.get(Calendar.MONTH) == calP.get(Calendar.MONTH) &&
                    calH.get(Calendar.YEAR) == calP.get(Calendar.YEAR)) {
                    horarios.add(horarioAux);
                }
            }
        }
        return horarios;
    }

    public List<Horario> getHorarioAtencion(){
        List<Horario> horarioAtencion = (List<Horario>)((ArrayList<Horario>)CargaData.HORARIO_ATENCION).clone();
        return horarioAtencion;
    }

    /**
     * Elimina un horario
     * @param Horario horario
     * @return boolean
     */
    public boolean eliminarHorario(Horario horario) {
        if (horario == null) {
            return false;
        }
        CargaData.HORARIOS.remove(horario);
        return true;
    }

    /**
     * Actualiza un horario
     * @param Horario horario
     * @return boolean
     */
    public boolean actualizarHorario(Horario horario) {
        if (horario == null) {
            return false;
        }
        return true;
    }
}

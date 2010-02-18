package pe.com.citasmedicas.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import pe.com.citasmedicas.model.CargaData;
import pe.com.citasmedicas.model.Cita;
import pe.com.citasmedicas.model.Especialidad;
import pe.com.citasmedicas.model.Horario;
import pe.com.citasmedicas.model.Medico;
import pe.com.citasmedicas.model.Paciente;

/**
 *
 * @author dew - Grupo 04
 */
public class CitaDao {

    /**
     * Obtiene una cita por su id
     * @param Integer citaId
     * @return Cita
     */
    public Cita getCitaPorId(Integer citaId) {
        if (citaId == null) {
            return null;
        }
        Cita cita = null;
        for (Cita citaAux : CargaData.CITAS) {
            if (citaAux.getCitaId().intValue() == citaId.intValue()) {
                cita = citaAux;
                break;
            }
        }
        return cita;
    }

    /**
     * Obtiene todos las citas de un médico para una fecha específica
     * @param Medico medico
     * @param Date fecha
     * @return List<Cita>
     */
    public List<Cita> getCitasPorMedicoFecha(Medico medico, Date fecha) {
        if (medico == null || fecha == null) {
            return new ArrayList<Cita>();
        }
        List<Cita> citas = new ArrayList<Cita>();
        for (Cita citaAux : CargaData.CITAS) {
            if (citaAux.getMedico().equals(medico)) {
                Calendar calH = new GregorianCalendar();
                calH.setTime(citaAux.getHorario().getFechaInicio());
                Calendar calP = new GregorianCalendar();
                calP.setTime(fecha);
                if (calH.get(Calendar.DAY_OF_WEEK) == calP.get(Calendar.DAY_OF_WEEK)) {
                    citas.add(citaAux);
                }
            }
        }
        return citas;
    }

    /**
     * Obtiene todos las citas de un médico para una fecha específica
     * @param Medico medico
     * @param Date fecha
     * @return List<Cita>
     */
    public List<Cita> getCitasPorPacienteFecha(Paciente paciente, Date fecha) {
        if (paciente == null || fecha == null) {
            return new ArrayList<Cita>();
        }
        List<Cita> citas = new ArrayList<Cita>();
        for (Cita citaAux : CargaData.CITAS) {
            if (citaAux.getPaciente().equals(paciente)) {
                Calendar calH = new GregorianCalendar();
                calH.setTime(citaAux.getHorario().getFechaInicio());
                Calendar calP = new GregorianCalendar();
                calP.setTime(fecha);
                if (calH.get(Calendar.DAY_OF_WEEK) == calP.get(Calendar.DAY_OF_WEEK)) {
                    citas.add(citaAux);
                }
            }
        }
        return citas;
    }

    /**
     * Obtiene todos las citas de un médico para una fecha específica
     * @param Medico medico
     * @param Date fecha
     * @return List<Cita>
     */
    public List<Cita> getCitasPorRangoFecha(Paciente paciente, Especialidad especialidad, Medico medico, Date fechaInicio, Date fechaFin) {
        if (medico == null || fechaInicio == null || fechaFin == null) {
            return new ArrayList<Cita>();
        }
        List<Cita> citas = new ArrayList<Cita>();
        for (Cita citaAux : CargaData.CITAS) {
            if (citaAux.getPaciente().equals(paciente)) {
                Horario horarioAux = citaAux.getHorario();
                if(horarioAux != null){
                    Especialidad especialidadAux = horarioAux.getEspecialidad();
                    Medico medicoAux = horarioAux.getMedico();
                    if(especialidadAux.equals(especialidad) && medicoAux.equals(medico)){
                        Date fechaAux = horarioAux.getFechaInicio();
                        if(fechaAux.after(fechaInicio) && fechaAux.before(fechaFin))
                           citas.add(citaAux);
                    }
                }
            }
        }
        return citas;
    }

    /**
     * Obtiene la cita de un horario específico
     * @param Horario horario
     * @return Cita
     */
    public Cita getCitaPorHorario(Horario horario) {
        if (horario == null) {
            return null;
        }
        Cita cita = null;
        for (Cita citaAux : CargaData.CITAS) {
            if (citaAux.getHorario().equals(horario)) {
                cita = citaAux;
                break;
            }
        }
        return cita;
    }

    /**
     * Ingresa una cita
     * @param Paciente paciente
     * @param Medico medico
     * @param Horario horario
     * @param String estado
     * @param String diagnostico
     * @return Cita
     */
    public Cita insertarCita(Paciente paciente, Medico medico, Horario horario, String estado, String diagnostico) {
        Cita cita = new Cita();
        cita.setCitaId(1000000 + CargaData.CITAS.size());
        cita.setPaciente(paciente);
        cita.setMedico(medico);
        cita.setHorario(horario);
        cita.setEstado(estado);
        cita.setDiagnostico(diagnostico);
        horario.setCita(cita);
        CargaData.CITAS.add(cita);
        return cita;
    }

     /**
     * Elimina una cita
     * @param Cita cita
     * @return boolean
     */
    public boolean eliminarCita(Cita cita) {
        if(cita == null)
            return false;
        CargaData.CITAS.remove(cita);
        return true;
    }

     /**
     * Actualiza una cita
     * @param Cita cita
     * @return boolean
     */
    public boolean actualizaCita(Cita cita) {
        if(cita == null)
            return false;
        return true;
    }
}

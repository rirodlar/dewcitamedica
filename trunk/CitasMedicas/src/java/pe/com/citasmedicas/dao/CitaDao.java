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
import pe.com.citasmedicas.model.Persona;

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
     * @param boolean validaHora
     * @return List<Cita>
     */
    public List<Cita> getCitasPorMedicoFecha(Medico medico, Date fecha, boolean validaHora) {
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
                if (calH.get(Calendar.DATE) == calP.get(Calendar.DATE) &&
                        calH.get(Calendar.MONTH) == calP.get(Calendar.MONTH) &&
                        calH.get(Calendar.YEAR) == calP.get(Calendar.YEAR)) {
                    if (validaHora) {
                        if (calH.get(Calendar.HOUR_OF_DAY) == calP.get(Calendar.HOUR_OF_DAY) &&
                                calH.get(Calendar.MINUTE) == calP.get(Calendar.MINUTE)) {
                            citas.add(citaAux);
                        }
                    } else {
                        citas.add(citaAux);
                    }
                }
            }
        }
        return citas;
    }

    /**
     * Obtiene todos las citas de un paciente para una fecha específica
     * @param Paciente paciente
     * @param Date fecha
     * @param boolean validaHora
     * @return List<Cita>
     */
    public List<Cita> getCitasPorPacienteFecha(Paciente paciente, Date fecha, boolean validaHora) {
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
                if (calH.get(Calendar.DATE) == calP.get(Calendar.DATE) &&
                        calH.get(Calendar.MONTH) == calP.get(Calendar.MONTH) &&
                        calH.get(Calendar.YEAR) == calP.get(Calendar.YEAR)) {
                    if (validaHora) {
                        if (calH.get(Calendar.HOUR_OF_DAY) == calP.get(Calendar.HOUR_OF_DAY) &&
                                calH.get(Calendar.MINUTE) == calP.get(Calendar.MINUTE)) {
                            citas.add(citaAux);
                        }
                    } else {
                        citas.add(citaAux);
                    }
                }
            }
        }
        return citas;
    }

    /**
     * Obtiene todos las citas pendientes de un paciente
     * @param Persona persona
     * @return List<Cita>
     */
    public List<Cita> getCitasPendientes(Persona persona) {
        if (persona == null) {
            return new ArrayList<Cita>();
        }
        List<Cita> citas = new ArrayList<Cita>();
        Calendar calToday = new GregorianCalendar();
        for (Cita citaAux : CargaData.CITAS) {
            if (citaAux.getPaciente().equals(persona)) {
                if (citaAux.getHorario().getFechaInicio().after(calToday.getTime())) {
                    citas.add(citaAux);
                }
            }
        }
        return citas;
    }

    /**
     * Obtiene todos las citas pendientes de un paciente para una semana, medico y especialidad
     * @param paciente
     * @param fechaIni
     * @param fechaFin
     * @param medicoId
     * @param especialidadId
     * @return Cita en la semana (solo puede haber una coincidencia para los parametros ingresados)
     */
    public Cita getCitaSemPendiente(Paciente paciente, Date fechaIni, Date fechaFin, Integer medicoId, Integer especialidadId) {
        
        Cita cita = null;

        for (Cita citaAux : CargaData.CITAS) {
            if (citaAux.getPaciente().equals(paciente) && citaAux.getMedico().getPersonaId() == medicoId
                && citaAux.getHorario().getEspecialidad().getEspecialidadId() == especialidadId) {

                //Si el horario se encuentra en la fecha de semana seleccionada y esta pendiente
                if (citaAux.getHorario().getFechaInicio().getTime() >= fechaIni.getTime()
                    && citaAux.getHorario().getFechaFin().getTime() <= fechaFin.getTime()
                    && citaAux.getEstado().equalsIgnoreCase("PENDIENTE")) {
                    cita = citaAux;
                    break;
                }
            }
        }
        return cita;
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
        if (cita == null) {
            return false;
        }
        CargaData.CITAS.remove(cita);
        return true;
    }

    /**
     * Actualiza una cita
     * @param Cita cita
     * @return boolean
     */
    public boolean actualizarCita(Cita cita) {
        if (cita == null) {
            return false;
        }
        return true;
    }
}

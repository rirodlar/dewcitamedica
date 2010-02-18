package pe.com.citasmedicas.service;

import java.util.Date;
import java.util.List;
import pe.com.citasmedicas.dao.CitaDao;
import pe.com.citasmedicas.model.Cita;
import pe.com.citasmedicas.model.Horario;
import pe.com.citasmedicas.model.Medico;
import pe.com.citasmedicas.model.Paciente;
import pe.com.citasmedicas.model.Persona;

/**
 *
 * @author dew - Grupo 04
 */
public class CitaService {

    private CitaDao citaDao;

    public CitaService() {
        citaDao = new CitaDao();
    }

    /**
     * Obtiene una cita por su id
     * @param Integer citaId
     * @return Cita
     */
    public Cita getCitaPorId(Integer citaId) {
        return citaDao.getCitaPorId(citaId);
    }

    /**
     * Obtiene todos las citas de un médico para una fecha específica
     * @param Medico medico
     * @param Date fecha
     * @return List<Cita>
     */
    public List<Cita> getCitasPorMedicoFecha(Medico medico, Date fecha) {
        return citaDao.getCitasPorMedicoFecha(medico, fecha);
    }
    
    /**
     * Obtiene la cita de un horario específico
     * @param Horario horario
     * @return Cita
     */
    public Cita getCitaPorHorario(Horario horario) {
        return citaDao.getCitaPorHorario(horario);
    }

    /**
     * Obtiene todos las citas pendientes de un paciente
     * @param Persona persona
     * @return List<Cita>
     */
    public List<Cita> getCitasPendientes(Persona persona) {
        return citaDao.getCitasPendientes(persona);
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
    public Cita insertarCita(Paciente paciente, Medico medico, Horario horario, String estado, String diagnostico) throws Exception{
        // Se valida que no exista una cita en dicho horario
        Cita cita = citaDao.getCitaPorHorario(horario);
        if(cita != null){
            throw new Exception("Ya existe una cita para ese horario.");
        }
        return citaDao.insertarCita(paciente, medico, horario, estado, diagnostico);
    }

     /**
     * Elimina una cita
     * @param Cita cita
     * @return boolean
     */
    public boolean eliminarCita(Cita cita) {
        return citaDao.eliminarCita(cita);
    }

     /**
     * Actualiza una cita
     * @param Cita cita
     * @return boolean
     */
    public boolean actualizaCita(Cita cita) {
        return citaDao.actualizaCita(cita);
    }
}

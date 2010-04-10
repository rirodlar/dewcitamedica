package pe.com.citasmedicas.service.implement;

import pe.com.citasmedicas.service.CitaService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.citasmedicas.dao.CitaDao;
import pe.com.citasmedicas.model.Cita;
import pe.com.citasmedicas.model.Especialidad;
import pe.com.citasmedicas.model.Horario;
import pe.com.citasmedicas.model.Medico;
import pe.com.citasmedicas.model.Paciente;
import pe.com.citasmedicas.model.Persona;

/**
 * Esta clase contiene los métodos de servicio implementados
 * @author dew - Grupo 04
 */
@Service
public class CitaServiceImpl implements CitaService {

    private CitaDao citaDao;

    /**
     * Obtiene una cita por su id
     * @return Cita
     */
    @Override
    public Cita getCitaPorId(Integer citaId) {
        return citaDao.getCitaPorId(citaId);
    }

    /**
     * Obtiene todos las citas de un médico para una fecha específica
     * @return List<Cita>
     */
    @Override
    public List<Cita> getCitasPorMedicoFecha(Medico medico, Date fecha, boolean validaHora) {
        return citaDao.getCitasPorMedicoFecha(medico, fecha, validaHora);
    }

    /**
     * Obtiene todos las citas de un médico para una fecha específica
     * @return List<Cita>
     */
    @Override
    public List<Cita> getCitasPorMedicoFecha(Integer medicoId, Date fecha, boolean validaHora) {
        return citaDao.getCitasPorMedicoFecha(medicoId, fecha, validaHora);
    }

    /**
     * Obtiene todos las citas de un médico para una fecha específica
     * @return List<Cita>
     */
    @Override
    public List<Cita> getCitasPorPacienteFecha(Paciente paciente, Date fecha, boolean validaHora) {
        return citaDao.getCitasPorPacienteFecha(paciente, fecha, validaHora);
    }

    /**
     * Obtiene todos las citas de un médico para una fecha específica
     * @return List<Cita>
     */
    @Override
    public List<Cita> getCitasPorPacienteFecha(Integer pacienteId, Date fecha, boolean validaHora) {
        return citaDao.getCitasPorPacienteFecha(pacienteId, fecha, validaHora);
    }

    /**
     * Obtiene la cita de un horario específico
     * @return Cita
     */
    @Override
    public Cita getCitaPorHorario(Horario horario) {
        return citaDao.getCitaPorHorario(horario);
    }

    /**
     * Obtiene la cita de un horario específico
     * @return Cita
     */
    @Override
    public Cita getCitaPorHorario(Integer horarioId) {
        return citaDao.getCitaPorHorario(horarioId);
    }

    /**
     * Obtiene todos las citas pendientes de un paciente
     * @return List<Cita>
     */
    @Override
    public List<Cita> getCitasPendientes(Persona paciente) {
        return citaDao.getCitasPendientes(paciente);
    }

    /**
     * Obtiene todos las citas pendientes de un paciente
     * @return List<Cita>
     */
    @Override
    public List<Cita> getCitasPendientes(Integer pacienteId) {
        return citaDao.getCitasPendientes(pacienteId);
    }

    /**
     * Obtiene la cita pendiente de un paciente para una semana, medico y especialidad
     * @return Cita
     */
    @Override
    public Cita getCitaSemPendiente(Paciente paciente, Date fechaInicio, Date fechaFin, Medico medico, Especialidad especialidad) {
        return citaDao.getCitaSemPendiente(paciente, fechaInicio, fechaFin, medico, especialidad);
    }

    /**
     * Obtiene la cita pendiente de un paciente para una semana, medico y especialidad
     * @return Cita
     */
    @Override
    public Cita getCitaSemPendiente(Integer pacienteId, Date fechaInicio, Date fechaFin, Integer medicoId, Integer especialidadId) {
        return citaDao.getCitaSemPendiente(pacienteId, fechaInicio, fechaFin, medicoId, especialidadId);
    }

    /**
     * Ingresa una cita
     * @return boolean
     */
    @Override
    public boolean insertarCita(Paciente paciente, Horario horario) throws Exception{
        // Se valida que no exista una cita en dicho horario
        Cita cita = citaDao.getCitaPorHorario(horario);
        if(cita != null){
            throw new Exception("Ya existe una cita para ese horario.");
        }
        return citaDao.insertarCita(paciente, horario);
    }

     /**
     * Elimina una cita
     * @return boolean
     */
    @Override
    public boolean eliminarCita(Cita cita) {
        return citaDao.eliminarCita(cita);
    }

     /**
     * Actualiza una cita
     * @return boolean
     */
    @Override
    public boolean actualizarCita(Cita cita) {
        return citaDao.actualizarCita(cita);
    }

    /**
     * @param citaDao the citaDao to set
     */
    @Autowired
    public void setCitaDao(CitaDao citaDao) {
        this.citaDao = citaDao;
    }
}

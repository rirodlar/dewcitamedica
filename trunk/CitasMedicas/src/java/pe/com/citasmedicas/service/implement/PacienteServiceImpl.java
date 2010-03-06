package pe.com.citasmedicas.service.implement;

import pe.com.citasmedicas.dao.PacienteDao;
import pe.com.citasmedicas.service.*;
import pe.com.citasmedicas.dao.hibernate.PacienteDaoHbn;
import pe.com.citasmedicas.model.Paciente;

/**
 *
 * @author dew - Grupo 04
 */
public class PacienteServiceImpl implements PacienteService {

    private PacienteDao pacienteDao;

    public PacienteServiceImpl() {
        pacienteDao = new PacienteDaoHbn();
    }

    /**
     * Obtiene un Paciente por su Id
     * @param Integer pacienteId
     * @return Paciente
     */
    public Paciente getPacientePorId(Integer pacienteId) {
        return pacienteDao.getPacientePorId(pacienteId);
    }
}

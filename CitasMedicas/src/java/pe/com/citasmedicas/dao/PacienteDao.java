package pe.com.citasmedicas.dao;

import pe.com.citasmedicas.model.Paciente;

/**
 *
 * @author dew - Grupo 04
 */
public interface PacienteDao {

    /**
     * Obtiene un Paciente por su Id
     * @param Integer pacienteId
     * @return Paciente
     */
    Paciente getPacientePorId(Integer pacienteId);

}

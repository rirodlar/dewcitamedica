package pe.com.citasmedicas.dao;

import pe.com.citasmedicas.model.CargaData;
import pe.com.citasmedicas.model.Paciente;

/**
 *
 * @author dew - Grupo 04
 */
public class PacienteDao {

     /**
     * Obtiene un Paciente por su Id
     * @param Integer pacienteId
     * @return Paciente
     */
    public Paciente getPacientePorId(Integer pacienteId) {
        if (pacienteId == null) {
            return null;
        }
        Paciente paciente = null;
        for (Paciente pacienteAux : CargaData.PACIENTES) {
            if (pacienteAux.getPersonaId().intValue() == pacienteId.intValue()) {
                paciente = pacienteAux;
                break;
            }
        }
        return paciente;
    }
}

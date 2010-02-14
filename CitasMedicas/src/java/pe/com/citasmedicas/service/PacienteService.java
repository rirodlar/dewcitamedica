/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.citasmedicas.service;

import pe.com.citasmedicas.dao.PacienteDao;
import pe.com.citasmedicas.model.Paciente;

/**
 *
 * @author dew - Grupo 04
 */
public class PacienteService {

    private PacienteDao pacienteDao;

    public PacienteService() {
        pacienteDao = new PacienteDao();
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

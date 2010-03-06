/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.citasmedicas.service;

import pe.com.citasmedicas.model.Paciente;

/**
 *
 * @author rSaenz
 */
public interface PacienteService {

    /**
     * Obtiene un Paciente por su Id
     * @param Integer pacienteId
     * @return Paciente
     */
    Paciente getPacientePorId(Integer pacienteId);

}

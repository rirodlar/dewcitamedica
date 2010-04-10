/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.citasmedicas.service;

import pe.com.citasmedicas.model.Paciente;

/**
 * Esta clase contiene los métodos a ser implementados por las clases de servicio
 * @author dew - Grupo 04
 */
public interface PacienteService {

    /**
     * Obtiene un Paciente por su Id
     * @param pacienteId
     * @return Paciente
     */
    Paciente getPacientePorId(Integer pacienteId);

}

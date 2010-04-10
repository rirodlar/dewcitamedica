/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.citasmedicas.service;

import java.util.List;
import pe.com.citasmedicas.model.Especialidad;
import pe.com.citasmedicas.model.Medico;

/**
 * Esta clase contiene los métodos a ser implementados por las clases de servicio
 * @author dew - Grupo 04
 */
public interface MedicoService {

    /**
     * Obtiene un médico por su id
     * @param medicoId
     * @return Medico
     */
    Medico getMedicoPorId(Integer medicoId);

    /**
     * Obtiene todas los médicos de una especialidad específica
     * @param especialidad
     * @return List<Medico>
     */
    List<Medico> getMedicosPorEspecialidad(Especialidad especialidad);

    /**
     * Obtiene todas los médicos de una especialidad específica
     * @param especialidadId
     * @return List<Medico>
     */
    List<Medico> getMedicosPorEspecialidad(Integer especialidadId);

}

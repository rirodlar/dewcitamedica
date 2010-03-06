/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.citasmedicas.service;

import java.util.List;
import pe.com.citasmedicas.model.Especialidad;
import pe.com.citasmedicas.model.Medico;

/**
 *
 * @author rSaenz
 */
public interface MedicoService {

    /**
     * Obtiene un médico por su id
     * @param Integer medicoId
     * @return Medico
     */
    Medico getMedicoPorId(Integer medicoId);

    /**
     * Obtiene todas los médicos de una especialidad específica
     * @param Especialidad especialidad
     * @return List<Medico>
     */
    List<Medico> getMedicosPorEspecialidad(Especialidad especialidad);

    /**
     * Obtiene todas los médicos de una especialidad específica
     * @param Integer especialidadId
     * @return List<Medico>
     */
    List<Medico> getMedicosPorEspecialidad(Integer especialidadId);

}

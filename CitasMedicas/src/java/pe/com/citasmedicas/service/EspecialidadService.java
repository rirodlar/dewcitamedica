/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.citasmedicas.service;

import java.util.List;
import pe.com.citasmedicas.model.Especialidad;

/**
 *
 * @author rSaenz
 */
public interface EspecialidadService {

    /**
     * Obtiene una especialidad por su id
     * @param Integer especialidadId
     * @return Especialidad
     */
    Especialidad getEspecialidadPorId(Integer especialidadId);

    /**
     * Obtiene todas las especialidades registradas
     * @return List<Especialidad>
     */
    List<Especialidad> getEspecialidades();

}

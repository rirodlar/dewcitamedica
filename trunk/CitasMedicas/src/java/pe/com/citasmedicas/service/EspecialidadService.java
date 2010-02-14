/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.citasmedicas.service;

import pe.com.citasmedicas.dao.EspecialidadDao;

/**
 *
 * @author dew - Grupo 04
 */
public class EspecialidadService {

    private EspecialidadDao especialidadDao;

    public EspecialidadService(){
        especialidadDao = new EspecialidadDao();
    }
}

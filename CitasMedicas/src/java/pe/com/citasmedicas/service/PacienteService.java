/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.citasmedicas.service;

import pe.com.citasmedicas.dao.PacienteDao;

/**
 *
 * @author dew - Grupo 04
 */
public class PacienteService {

    private PacienteDao pacienteDao;

    public PacienteService(){
        pacienteDao = new PacienteDao();
    }
}

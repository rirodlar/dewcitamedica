/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.citasmedicas.service;

import pe.com.citasmedicas.dao.CitaDao;

/**
 *
 * @author dew - Grupo 04
 */
public class CitaService {

    private CitaDao citaDao;

    public CitaService(){
        citaDao = new CitaDao();
    }
}

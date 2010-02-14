/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.citasmedicas.service;

import pe.com.citasmedicas.dao.MedicoDao;

/**
 *
 * @author dew - Grupo 04
 */
public class MedicoService {

    private MedicoDao medicoDao;

    public MedicoService(){
        medicoDao = new MedicoDao();
    }
}

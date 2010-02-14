/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.citasmedicas.service;

import pe.com.citasmedicas.dao.HorarioDao;

/**
 *
 * @author dew - Grupo 04
 */
public class HorarioService {

    private HorarioDao horarioDao;

    public HorarioService(){
        horarioDao = new HorarioDao();
    }
}

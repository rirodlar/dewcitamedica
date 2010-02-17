/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.citasmedicas.service;

import pe.com.citasmedicas.dao.UsuarioDao;
import pe.com.citasmedicas.model.Usuario;

/**
 *
 * @author dew - Grupo 04
 */
public class UsuarioService {

    private UsuarioDao usuarioDao;

    public UsuarioService(){
        usuarioDao = new UsuarioDao();
    }

     /**
     * Obtiene un usuario por su username
     * @param String username
     * @return Usuario
     */
    public Usuario getUsuarioPorUsername(String username) {
        return usuarioDao.getUsuarioPorUsername(username);
    }
}

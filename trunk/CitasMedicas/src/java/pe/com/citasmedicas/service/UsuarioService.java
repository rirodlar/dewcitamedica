/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.citasmedicas.service;

import pe.com.citasmedicas.model.Usuario;

/**
 *
 * @author rSaenz
 */
public interface UsuarioService {

    /**
     * Obtiene un usuario por su username
     * @param String username
     * @return Usuario
     */
    Usuario getUsuarioPorUsername(String username);

}

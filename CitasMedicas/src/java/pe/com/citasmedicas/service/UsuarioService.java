/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.citasmedicas.service;

import pe.com.citasmedicas.model.Usuario;

/**
 * Esta clase contiene los métodos a ser implementados por las clases de servicio
 * @author dew - Grupo 04
 */
public interface UsuarioService {

    /**
     * Obtiene un usuario por su username
     * @param username
     * @return Usuario
     */
    Usuario getUsuarioPorUsername(String username);

}

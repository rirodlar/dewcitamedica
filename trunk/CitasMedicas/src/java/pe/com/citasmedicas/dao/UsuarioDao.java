/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.citasmedicas.dao;

import pe.com.citasmedicas.model.CargaData;
import pe.com.citasmedicas.model.Usuario;

/**
 *
 * @author dew - Grupo 04
 */
public class UsuarioDao {

    /**
     * Obtiene un usuario por su username
     * @param String username
     * @return Usuario
     */
    public Usuario getUsuarioPorUsername(String username) {
        if (username == null) {
            return null;
        }
        Usuario usuario = null;
        for (Usuario usuarioAux : CargaData.USUARIOS) {
            if (usuarioAux.getUsername().equals(username)) {
                usuario = usuarioAux;
                break;
            }
        }
        return usuario;
    }
}

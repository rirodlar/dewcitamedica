package pe.com.citasmedicas.dao;

import pe.com.citasmedicas.model.Usuario;

/**
 *
 * @author dew - Grupo 04
 */
public interface UsuarioDao {

    /**
     * Obtiene un usuario por su username
     * @param String username
     * @return Usuario
     */
    Usuario getUsuarioPorUsername(String username);

}

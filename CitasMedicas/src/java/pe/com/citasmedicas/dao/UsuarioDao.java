package pe.com.citasmedicas.dao;

import pe.com.citasmedicas.model.Usuario;

/**
 * Esta clase contiene los métodos a ser implementados por las clases de persistencia
 * @author dew - Grupo 04
 */
public interface UsuarioDao {

    /**
     * Obtiene un usuario por su username
     * @param username nombre de usuario
     * @return Usuario datos del usuario
     */
    Usuario getUsuarioPorUsername(String username);

}

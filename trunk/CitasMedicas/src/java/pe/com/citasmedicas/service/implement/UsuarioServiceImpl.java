package pe.com.citasmedicas.service.implement;

import pe.com.citasmedicas.dao.UsuarioDao;
import pe.com.citasmedicas.service.*;
import pe.com.citasmedicas.dao.hibernate.UsuarioDaoHbn;
import pe.com.citasmedicas.model.Usuario;

/**
 *
 * @author dew - Grupo 04
 */
public class UsuarioServiceImpl implements UsuarioService {

    private UsuarioDao usuarioDao;

    public UsuarioServiceImpl(){
        usuarioDao = new UsuarioDaoHbn();
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

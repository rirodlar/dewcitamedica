package pe.com.citasmedicas.service.implement;

import pe.com.citasmedicas.dao.UsuarioDao;
import pe.com.citasmedicas.service.UsuarioService;
import pe.com.citasmedicas.model.Usuario;

/**
 *
 * @author dew - Grupo 04
 */
public class UsuarioServiceImpl implements UsuarioService {

    private UsuarioDao usuarioDao;

     /**
     * Obtiene un usuario por su username
     * @param String username
     * @return Usuario
     */
    public Usuario getUsuarioPorUsername(String username) {
        return usuarioDao.getUsuarioPorUsername(username);
    }

    /**
     * @param usuarioDao the usuarioDao to set
     */
    public void setUsuarioDao(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }
}

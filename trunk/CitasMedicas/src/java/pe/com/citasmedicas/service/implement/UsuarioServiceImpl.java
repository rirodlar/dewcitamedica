package pe.com.citasmedicas.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.citasmedicas.dao.UsuarioDao;
import pe.com.citasmedicas.service.UsuarioService;
import pe.com.citasmedicas.model.Usuario;

/**
 * Esta clase contiene los métodos de servicio implementados
 * @author dew - Grupo 04
 */
@Service
public class UsuarioServiceImpl implements UsuarioService {

    private UsuarioDao usuarioDao;

     /**
     * Obtiene un usuario por su username
     * @return Usuario
     */
    @Override
    public Usuario getUsuarioPorUsername(String username) {
        return usuarioDao.getUsuarioPorUsername(username);
    }

    /**
     * @param usuarioDao the usuarioDao to set
     */
    @Autowired
    public void setUsuarioDao(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }
}

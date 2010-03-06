package pe.com.citasmedicas.dao;

import pe.com.citasmedicas.dao.hibernate.UsuarioDaoHbn;
import org.hibernate.HibernateException;
import org.junit.Assert;
import org.junit.Test;
import pe.com.citasmedicas.model.Usuario;

/**
 *
 * @author dew - Grupo 04
 */
public class UsuarioDaoTest {

    @Test
    public void hibernateTest() {
        try {
            UsuarioDao usuarioDao = new UsuarioDaoHbn();
            Usuario usuario = usuarioDao.getUsuarioPorUsername("anaTalavera");
            Assert.assertEquals(usuario.getPassword(), "web");
            Assert.assertEquals(usuario.getPersona().getApellidoPaterno(), "TALAVERA");
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
}

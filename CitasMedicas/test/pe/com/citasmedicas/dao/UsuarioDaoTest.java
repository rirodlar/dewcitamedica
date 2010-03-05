package pe.com.citasmedicas.dao;

import org.hibernate.HibernateException;
import org.junit.Assert;
import org.junit.Test;
import pe.com.citasmedicas.model.Persona;
import pe.com.citasmedicas.model.Usuario;

/**
 *
 * @author dew - Grupo 04
 */
public class UsuarioDaoTest {

    @Test
    public void hibernateTest() {
        try {
            UsuarioDao usuarioDao = new UsuarioDao();
            Usuario usuario = usuarioDao.getUsuarioPorUsername("anaTalavera");
            Assert.assertEquals(usuario.getPassword(), "web");

            Persona persona = usuario.getPersona();
            if(persona != null) {
                Assert.assertEquals(persona.getApellidoPaterno(), "TALAVERA");
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
}

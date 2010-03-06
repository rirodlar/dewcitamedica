package pe.com.citasmedicas.dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.junit.Assert;
import org.junit.Test;
import pe.com.citasmedicas.dao.hibernate.EspecialidadDaoHbn;
import pe.com.citasmedicas.model.Especialidad;

/**
 *
 * @author dew - Grupo 04
 */
public class EspecialidadDaoTest {

    @Test
    public void hibernateTest() {
        try {
            EspecialidadDao especialidadDao = new EspecialidadDaoHbn();
            List<Especialidad> especialidades = especialidadDao.getEspecialidades();
            Assert.assertEquals(especialidades.size(), 3);

            Especialidad especialidad = especialidadDao.getEspecialidadPorId(new Integer(1000002));
            Assert.assertEquals(especialidad.getNombre(), "GASTROENTEROLOGIA");
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

}

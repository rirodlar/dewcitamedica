package pe.com.citasmedicas.dao;

import pe.com.citasmedicas.dao.hibernate.MedicoDaoHbn;
import pe.com.citasmedicas.dao.hibernate.EspecialidadDaoHbn;
import java.util.List;
import org.hibernate.HibernateException;
import org.junit.Assert;
import org.junit.Test;
import pe.com.citasmedicas.model.Especialidad;
import pe.com.citasmedicas.model.Medico;

/**
 *
 * @author dew - Grupo 04
 */
public class MedicoDaoTest {

    @Test
    public void hibernateTest() {
        try {
            EspecialidadDao especialidadDao = new EspecialidadDaoHbn();
            Especialidad especialidad = especialidadDao.getEspecialidadPorId(new Integer(1000002));

            MedicoDao medicoDao = new MedicoDaoHbn();
            List<Medico> medicos = medicoDao.getMedicosPorEspecialidad(especialidad);
            Assert.assertEquals(medicos.size(), 2);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
}

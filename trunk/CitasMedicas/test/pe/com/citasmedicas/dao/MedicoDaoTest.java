/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.citasmedicas.dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.junit.Assert;
import org.junit.Test;
import pe.com.citasmedicas.model.Especialidad;
import pe.com.citasmedicas.model.Medico;

/**
 *
 * @author rSaenz
 */
public class MedicoDaoTest {

    @Test
    public void hibernateTest() {
        try {
            EspecialidadDao especialidadDao = new EspecialidadDao();
            Especialidad especialidad = especialidadDao.getEspecialidadPorId(new Integer(1000002));

            MedicoDao medicoDao = new MedicoDao();
            List<Medico> medicos = medicoDao.getMedicosPorEspecialidad(especialidad);
            Assert.assertEquals(medicos.size(), 2);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
}
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
public class EspecialidadDaoTest {

    @Test
    public void hibernateTest() {
        try {
            String v = org.hibernate.cfg.annotations.Version.VERSION;
            //System.out.println("--->>> " + v);
            EspecialidadDao especialidadDao = new EspecialidadDao();
            List<Especialidad> especialidades = especialidadDao.getEspecialidades();
            Assert.assertEquals(especialidades.size(), 3);

            Especialidad especialidad = especialidadDao.getEspecialidadPorId(new Integer(1000002));
            Assert.assertEquals(especialidad.getNombre(), "GASTROENTEROLOGIA");
/*
            List<Medico> medicos = especialidad.getMedicos();
            if(medicos != null) {
                System.out.println("----->>>>> *** E *** <<<<<-----");
                Assert.assertEquals(medicos.size(), 2);
            }*/
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

}

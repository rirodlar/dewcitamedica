package pe.com.citasmedicas.dao;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import org.hibernate.HibernateException;
import org.junit.Assert;
import org.junit.Test;
import pe.com.citasmedicas.model.Horario;

/**
 *
 * @author dew - Grupo 04
 */
public class HoraioDaoTest {

    @Test
    public void hibernateTest() {
        try {
            HorarioDao horarioDao = new HorarioDao();

            Horario horario = horarioDao.getHorarioPorId(new Integer(1000004));
            Assert.assertEquals(horario.getHorarioId().intValue(), 1000004);
            Assert.assertEquals(horario.getEspecialidad().getNombre(), "CARDIOLOGIA");
            Assert.assertEquals(horario.getMedico().getApellidoPaterno(), "CASANA");

            Calendar cal = new GregorianCalendar(2010, 3, 21);
            List<Horario> horarios = horarioDao.getHorariosPorEspecMedicoFecha(new Integer(1000000), new Integer(1000000), cal.getTime());
            Assert.assertEquals(horarios.size(), 4);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
}

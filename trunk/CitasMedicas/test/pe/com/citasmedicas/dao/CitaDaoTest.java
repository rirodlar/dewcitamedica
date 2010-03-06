package pe.com.citasmedicas.dao;

import pe.com.citasmedicas.dao.hibernate.PacienteDaoHbn;
import pe.com.citasmedicas.dao.hibernate.HorarioDaoHbn;
import pe.com.citasmedicas.dao.hibernate.CitaDaoHbn;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.hibernate.HibernateException;
import pe.com.citasmedicas.model.Cita;
import pe.com.citasmedicas.model.Horario;
import pe.com.citasmedicas.model.Paciente;

/**
 *
 * @author dew - Grupo 04
 */
public class CitaDaoTest {

    @Test
    public void hibernateTest() {
        try {
            CitaDao citaDao = new CitaDaoHbn();
            Cita cita = citaDao.getCitaPorHorario(new Integer(1000034));
            Assert.assertEquals(cita.getCitaId().intValue(), 1000001);
            Assert.assertEquals(cita.getMedico().getApellidoPaterno(), "SALAZAR");
            Assert.assertEquals(cita.getPaciente().getApellidoPaterno(), "TALAVERA");

            List<Cita> citas = citaDao.getCitasPendientes(new Integer(1000010));
            Assert.assertEquals(citas.size(), 2);

            Calendar cal = new GregorianCalendar(2010, 3, 24, 15, 0);
            citas = citaDao.getCitasPorPacienteFecha(new Integer(1000010), cal.getTime(), false);
            Assert.assertEquals(citas.size(), 1);

            cal = new GregorianCalendar(2010, 3, 24, 10, 0);
            citas = citaDao.getCitasPorPacienteFecha(new Integer(1000010), cal.getTime(), true);
            Assert.assertEquals(citas.size(), 1);

            cal = new GregorianCalendar(2010, 3, 20, 15, 0);
            citas = citaDao.getCitasPorMedicoFecha(new Integer(1000005), cal.getTime(), false);
            Assert.assertEquals(citas.size(), 1);

            cal = new GregorianCalendar(2010, 3, 20, 16, 0);
            citas = citaDao.getCitasPorMedicoFecha(new Integer(1000005), cal.getTime(), true);
            Assert.assertEquals(citas.size(), 1);

            HorarioDao horarioDao = new HorarioDaoHbn();
            PacienteDaoHbn pacienteDao = new PacienteDaoHbn();
            Horario horario = horarioDao.getHorarioPorId(new Integer(1000030));
            Paciente paciente = pacienteDao.getPacientePorId(new Integer(1000009));
            boolean insert = citaDao.insertarCita(paciente, horario);
            Assert.assertTrue(insert);

            cita = citaDao.getCitaPorId(new Integer(1000000));
            boolean delete = citaDao.eliminarCita(cita);
            Assert.assertTrue(delete);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
}

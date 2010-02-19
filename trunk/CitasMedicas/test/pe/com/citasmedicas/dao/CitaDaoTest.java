package pe.com.citasmedicas.dao;

import java.util.Calendar;
import java.util.GregorianCalendar;
import org.junit.Assert;
import org.junit.Test;
import pe.com.citasmedicas.model.CargaData;
import pe.com.citasmedicas.model.Cita;

/**
 *
 * @author dew - Grupo 04
 */
public class CitaDaoTest {

    @Test
    public void testCitaDao() {
        CargaData.inicializar();

        CitaDao citaDao = new CitaDao();
        PacienteDao pacienteDao = new PacienteDao();
        MedicoDao medicoDao = new MedicoDao();
        HorarioDao horarioDao = new HorarioDao();
        Calendar cal = null;

        Cita cita = citaDao.getCitaPorId(new Integer(1000002));
        Assert.assertEquals(cita.getEstado(), "RESERVADO");
        Assert.assertEquals(cita.getHorario().getHorarioId().intValue(), 1000054);
        Assert.assertEquals(cita.getMedico().getPersonaId().intValue(), 1000005);
        Assert.assertEquals(cita.getPaciente().getPersonaId().intValue(), 1000010);

        cal = new GregorianCalendar(2010, 2, 27);
        Assert.assertEquals((citaDao.getCitasPorMedicoFecha(medicoDao.getMedicoPorId(new Integer(1000005)),
                cal.getTime(), false)).size(), 1);

        cita = citaDao.getCitaPorHorario(horarioDao.getHorarioPorId(new Integer(1000004)));
        Assert.assertEquals(cita.getCitaId().intValue(), 1000001);
        Assert.assertEquals(cita.getEstado(), "RESERVADO");
        Assert.assertEquals(cita.getHorario().getHorarioId().intValue(), 1000004);
        Assert.assertEquals(cita.getMedico().getPersonaId().intValue(), 1000000);
        Assert.assertEquals(cita.getPaciente().getPersonaId().intValue(), 1000008);

        cita = citaDao.insertarCita(pacienteDao.getPacientePorId(new Integer(1000009)),
                medicoDao.getMedicoPorId(new Integer(1000005)),
                horarioDao.getHorarioPorId(new Integer(1000055)),
                "RESERVADO", null);
        Assert.assertEquals((citaDao.getCitasPorMedicoFecha(medicoDao.getMedicoPorId(new Integer(1000005)),
                cal.getTime(), false)).size(), 2);
        Assert.assertEquals(CargaData.CITAS.size(), 5);

        citaDao.eliminarCita(cita);
        Assert.assertEquals(CargaData.CITAS.size(), 4);
    }
}

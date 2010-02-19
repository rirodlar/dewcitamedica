package pe.com.citasmedicas.dao;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import pe.com.citasmedicas.model.CargaData;
import pe.com.citasmedicas.model.Especialidad;
import pe.com.citasmedicas.model.Horario;
import pe.com.citasmedicas.model.Medico;

/**
 *
 * @author dew - Grupo 04
 */
public class HorarioDaoTest {

    @Test
    public void testHorarioDao(){
        CargaData.inicializar();

        HorarioDao horarioDao = new HorarioDao();
        Horario horario = horarioDao.getHorarioPorId(new Integer(1000001));
        Assert.assertEquals(horario.getEspecialidad().getNombre(), "Cardiología");
        Assert.assertEquals(horario.getMedico().getPersonaId().intValue(), 1000000);
        Calendar cal = new GregorianCalendar(2010, 2, 22, 9, 30);
        Assert.assertEquals(horario.getFechaInicio().getTime(), cal.getTimeInMillis());
        cal = new GregorianCalendar(2010, 2, 22, 10, 0);
        Assert.assertEquals(horario.getFechaFin().getTime(), cal.getTimeInMillis());

        EspecialidadDao especialidadDao = new EspecialidadDao();
        Especialidad especialidad = especialidadDao.getEspecialidadPorId(new Integer(1000000));
        MedicoDao medicoDao = new MedicoDao();
        Medico medico = medicoDao.getMedicoPorId(new Integer(1000002));
        cal = new GregorianCalendar(2010, 2, 27);
        List<Horario> horarios = horarioDao.getHorariosPorEspecMedicoFecha(especialidad, medico, cal.getTime());
        Assert.assertEquals(horarios.size(), 4);

        cal = new GregorianCalendar(2010, 2, 23);
        medico = medicoDao.getMedicoPorId(new Integer(1000001));
        horarios = horarioDao.getHorariosPorEspecMedicoFecha(especialidad, medico, cal.getTime());
        Assert.assertEquals(horarios.size(), 4);
    }
}

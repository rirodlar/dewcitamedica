package pe.com.citasmedicas.dao;

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
    public void testCitaDao(){
        CargaData.inicializar();

        CitaDao citaDao = new CitaDao();
        Cita cita = citaDao.getCitaPorId(new Integer(1000002));
        Assert.assertEquals(cita.getEstado(), "RESERVADO");
        Assert.assertEquals(cita.getHorario().getHorarioId().intValue(), 1000054);
        Assert.assertEquals(cita.getMedico().getPersonaId().intValue(), 1000005);
        Assert.assertEquals(cita.getPaciente().getPersonaId().intValue(), 1000010);

        HorarioDao horarioDao = new HorarioDao();
        cita = citaDao.getCitaPorHorario(horarioDao.getHorarioPorId(new Integer(1000004)));
        Assert.assertEquals(cita.getCitaId().intValue(), 1000001);
        Assert.assertEquals(cita.getEstado(), "RESERVADO");
        Assert.assertEquals(cita.getHorario().getHorarioId().intValue(), 1000004);
        Assert.assertEquals(cita.getMedico().getPersonaId().intValue(), 1000000);
        Assert.assertEquals(cita.getPaciente().getPersonaId().intValue(), 1000008);
    }
}

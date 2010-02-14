package pe.com.citasmedicas.service;

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
public class CitaServiceTest {

    @Test
    public void testCitaDao(){
        CargaData.inicializar();

        CitaService citaService = new CitaService();
        PacienteService pacienteService = new PacienteService();
        MedicoService medicoService = new MedicoService();
        HorarioService horarioService = new HorarioService();
        Calendar cal = null;

        Cita cita = citaService.getCitaPorId(new Integer(1000002));
        Assert.assertEquals(cita.getEstado(), "RESERVADO");
        Assert.assertEquals(cita.getHorario().getHorarioId().intValue(), 1000054);
        Assert.assertEquals(cita.getMedico().getPersonaId().intValue(), 1000005);
        Assert.assertEquals(cita.getPaciente().getPersonaId().intValue(), 1000010);

        cal = new GregorianCalendar(2010, 2, 27);
        Assert.assertEquals((citaService.getCitasPorMedicoFecha(medicoService.getMedicoPorId(new Integer(1000005)),
                cal.getTime())).size(), 1);

        cita = citaService.getCitaPorHorario(horarioService.getHorarioPorId(new Integer(1000004)));
        Assert.assertEquals(cita.getCitaId().intValue(), 1000001);
        Assert.assertEquals(cita.getEstado(), "RESERVADO");
        Assert.assertEquals(cita.getHorario().getHorarioId().intValue(), 1000004);
        Assert.assertEquals(cita.getMedico().getPersonaId().intValue(), 1000000);
        Assert.assertEquals(cita.getPaciente().getPersonaId().intValue(), 1000008);

        try{
            cita = citaService.insertarCita(pacienteService.getPacientePorId(new Integer(1000009)),
                    medicoService.getMedicoPorId(new Integer(1000005)),
                    horarioService.getHorarioPorId(new Integer(1000055)),
                    "RESERVADO", null);
            Assert.assertEquals(cita.getCitaId().intValue(), 1000004);
            Assert.assertEquals((citaService.getCitasPorMedicoFecha(medicoService.getMedicoPorId(new Integer(1000005)),
                cal.getTime())).size(), 2);
        }catch(Exception ex){
            ex.printStackTrace();
        }

    }
}

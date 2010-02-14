package pe.com.citasmedicas.dao;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import pe.com.citasmedicas.model.CargaData;
import pe.com.citasmedicas.model.Especialidad;
import pe.com.citasmedicas.model.Medico;

/**
 *
 * @author dew - Grupo 04
 */
public class MedicoDaoTest {

    @Test
    public void testMedicoDao(){
        CargaData.inicializar();

        MedicoDao medicoDao = new MedicoDao();
        Medico medico = medicoDao.getMedicoPorId(new Integer(1000003));
        Assert.assertEquals(medico.getNombre(), "José");
        Assert.assertEquals(medico.getApellidoPaterno(), "Caravedo");
        Assert.assertEquals(medico.getApellidoMaterno(), "Baigorria");
        Calendar cal = new GregorianCalendar(1973, 10, 10);
        Assert.assertEquals(medico.getFechaNacimiento(), cal.getTime());
        Assert.assertEquals(medico.getNroColegiatura(), "22658");
        Assert.assertEquals(medico.getNroDocumento(), "62354085");
        Assert.assertEquals(medico.getEspecialidades().size(), 1);

        EspecialidadDao especialidadDao = new EspecialidadDao();
        Especialidad especialidad = especialidadDao.getEspecialidadPorId(new Integer(1000001));
        List<Medico> medicos = medicoDao.getMedicosPorEspecialidad(especialidad);
        Assert.assertEquals(medicos.size(), 2);
    }
}

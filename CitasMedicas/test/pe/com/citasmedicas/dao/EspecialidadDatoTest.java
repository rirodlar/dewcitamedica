package pe.com.citasmedicas.dao;

import org.junit.Assert;
import org.junit.Test;
import pe.com.citasmedicas.model.CargaData;
import pe.com.citasmedicas.model.Especialidad;

/**
 *
 * @author dew - Grupo 04
 */
public class EspecialidadDatoTest {

    @Test
    public void testEspecialidadDao(){
        CargaData.inicializar();

        EspecialidadDao especialidadDao = new EspecialidadDao();
        Especialidad especialidad = especialidadDao.getEspecialidadPorId(new Integer(1000001));
        Assert.assertEquals(especialidad.getNombre(), "Hematología");
    }
}

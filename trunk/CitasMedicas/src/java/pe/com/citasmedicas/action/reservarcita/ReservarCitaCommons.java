package pe.com.citasmedicas.action.reservarcita;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.time.DateFormatUtils;
import pe.com.citasmedicas.model.Cita;
import pe.com.citasmedicas.model.Persona;
import pe.com.citasmedicas.service.implement.CitaServiceImpl;

/**
 *
 * @author dew - Grupo 04
 */
public class ReservarCitaCommons {

    public static List<String> cargarCitasPendientes(Persona paciente) {
        CitaServiceImpl citaService = new CitaServiceImpl();
        List<String> citasPendientes = new ArrayList<String>();
        //
        if (paciente != null) {
            List<Cita> citas = citaService.getCitasPendientes(paciente);
            for (Cita cita : citas) {
                String citaPendiente = "";
                citaPendiente = DateFormatUtils.format(cita.getHorario().getFechaInicio(), "EEEE dd 'de' MMMM 'del' yyyy, k:mm 'hrs.'")
                                + " : " + cita.getHorario().getEspecialidad().getNombre() + " - " + cita.getHorario().getMedico().getNombreCompleto();
                citasPendientes.add(citaPendiente);
            }
        }
        return citasPendientes;
    }

    public static void buscarHorarioSemana(){

    }
}

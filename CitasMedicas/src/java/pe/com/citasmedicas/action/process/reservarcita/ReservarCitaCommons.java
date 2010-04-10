package pe.com.citasmedicas.action.process.reservarcita;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.time.DateFormatUtils;
import pe.com.citasmedicas.model.Cita;
import pe.com.citasmedicas.model.Persona;
import pe.com.citasmedicas.service.CitaService;

/**
 * Esta clase contiene los métodos utilizados por la funcionalidad comun a las acciones de Reserva de Citas
 * @author dew - Grupo 04
 */
public class ReservarCitaCommons {

    public static List<String> cargarCitasPendientes(CitaService citaService, Persona paciente) {
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
}

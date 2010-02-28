package pe.com.citasmedicas.action.reservarcita;

import com.opensymphony.xwork2.validator.annotations.Validation;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.struts2.config.Namespace;
import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletDispatcherResult;
import pe.com.citasmedicas.action.BaseAction;
import pe.com.citasmedicas.model.Especialidad;
import pe.com.citasmedicas.model.Medico;
import pe.com.citasmedicas.model.Usuario;
import pe.com.citasmedicas.service.EspecialidadService;
import pe.com.citasmedicas.service.MedicoService;

/**
 *
 * @author dew - Grupo 04
 */
@Namespace("/reserva")
@Results({
    @Result(name="success", value="/prc/reservar_cita.jsp", type=ServletDispatcherResult.class),
    @Result(name="error", value="/errorPage.jsp", type=ServletDispatcherResult.class)
})
public class IniciarReservaAction extends BaseAction{

    @Override
    public String execute(){
        try{
            // Servicios
            EspecialidadService especialidadService = new EspecialidadService();
            MedicoService medicoService = new MedicoService();

            // Variables
            HttpSession sesion = request.getSession();
            List<String> cabeceraSemana = new ArrayList<String>();
            List<Especialidad> especialidades = null;
            Integer especialidadId = null;
            List<Medico> medicos = null;
            Integer medicoId = null;
            String fechaSemana = "";

            // Se recuperan todas las especialidades
            especialidades = especialidadService.getEspecialidades();
            if (especialidades == null) {
                especialidades = new ArrayList<Especialidad>();
            }
            //
            if (especialidades.size() > 0) {
                especialidadId = especialidades.get(0).getEspecialidadId();
            }
            if (especialidadId != null) {
                // Se recuperan todos los médicos de la especialidad seleccionada
                medicos = medicoService.getMedicosPorEspecialidad(especialidades.get(0));
                if (medicos == null) {
                    medicos = new ArrayList<Medico>();
                }
                if (medicos.size() > 0) {
                    medicoId = medicos.get(0).getPersonaId();
                }
            }

            if (fechaSemana == null || fechaSemana.equalsIgnoreCase("")) {
                fechaSemana = DateFormatUtils.format(Calendar.getInstance(), "dd/MM/yyyy");
            }

            // Se inicializa la cabecera de los horarios
            cabeceraSemana.add("Lunes");
            cabeceraSemana.add("Martes");
            cabeceraSemana.add("Miércoles");
            cabeceraSemana.add("Jueves");
            cabeceraSemana.add("Viernes");
            cabeceraSemana.add("Sábado");
            cabeceraSemana.add("Domingo");
            sesion.setAttribute("cabeceraSemana", cabeceraSemana);
            sesion.setAttribute("especialidades", especialidades);
            sesion.setAttribute("especialidadId", especialidadId);
            sesion.setAttribute("medicos", medicos);
            sesion.setAttribute("medicoId", medicoId);
            sesion.setAttribute("errorMsg", "");
            sesion.setAttribute("fechaSemana", fechaSemana);
            sesion.setAttribute("citasPendientes", 
                    ReservarCitaCommons.cargarCitasPendientes(((Usuario) sesion.getAttribute("usuario")).getPersona()));
            return SUCCESS;
        }catch(Exception ex){
            ex.printStackTrace();
            return ERROR;
        }
    }
}

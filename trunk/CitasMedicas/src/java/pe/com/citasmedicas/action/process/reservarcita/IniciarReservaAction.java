package pe.com.citasmedicas.action.process.reservarcita;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.struts2.config.Namespace;
import org.apache.struts2.config.ParentPackage;
import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletDispatcherResult;
import pe.com.citasmedicas.action.BaseAction;
import pe.com.citasmedicas.exception.SeguridadException;
import pe.com.citasmedicas.model.Especialidad;
import pe.com.citasmedicas.model.Medico;
import pe.com.citasmedicas.model.Usuario;
import pe.com.citasmedicas.service.CitaService;
import pe.com.citasmedicas.service.EspecialidadService;
import pe.com.citasmedicas.service.MedicoService;

/**
 * Esta clase contiene los métodos utilizados por la funcionalidad Iniciar Reserva
 * @author dew - Grupo 04
 */
@Namespace(value="/reserva")
@ParentPackage(value="citaMedica")
@Results({
    @Result(name="success", value="/prc/reservar_cita.jsp", type=ServletDispatcherResult.class)
})
public class IniciarReservaAction extends BaseAction{

    private EspecialidadService especialidadService;
    private MedicoService medicoService;
    private CitaService citaService;

    /**
     * Método encargado de ejecutar la acción solicitada
     * @return resultado de la accion
     */
    @Override
    public String execute(){
        try{
            validarAutenticacion(request);
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
                medicos = medicoService.getMedicosPorEspecialidad(especialidadId);
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
                    ReservarCitaCommons.cargarCitasPendientes(citaService, ((Usuario) sesion.getAttribute("usuario")).getPersona()));
            return SUCCESS;
        }catch(SeguridadException se){
            return LOGIN;
        }catch(Exception ex){
            ex.printStackTrace();
            return ERROR;
        }
    }

    /**
     * Establecer el servicio que maneja las especialidades
     * @param especialidadService servicio a establecer
     */
    public void setEspecialidadService(EspecialidadService especialidadService) {
        this.especialidadService = especialidadService;
    }

    /**
     * Establecer el servicio que maneja los medicos
     * @param medicoService servicio a establecer
     */
    public void setMedicoService(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    /**
     * Establecer el servicio que maneja las citas
     * @param citaService servicio a establecer
     */
    public void setCitaService(CitaService citaService) {
        this.citaService = citaService;
    }
}

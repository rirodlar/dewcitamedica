package pe.com.citasmedicas.action.reservarcita;

import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.Validation;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.struts2.config.Namespace;
import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletDispatcherResult;
import pe.com.citasmedicas.action.BaseAction;
import pe.com.citasmedicas.model.Cita;
import pe.com.citasmedicas.model.Horario;
import pe.com.citasmedicas.model.Paciente;
import pe.com.citasmedicas.model.Usuario;
import pe.com.citasmedicas.service.CitaService;
import pe.com.citasmedicas.service.HorarioService;
import pe.com.citasmedicas.service.PacienteService;

/**
 *
 * @author dew - Grupo 04
 */
@Namespace("/reserva")
@Results({
    @Result(name="success", value="/prc/reservar_cita.jsp", type=ServletDispatcherResult.class),
    @Result(name="input", value="/prc/reservar_cita.jsp", type=ServletDispatcherResult.class),
    @Result(name="error", value="/errorPage.jsp", type=ServletDispatcherResult.class)
})
@Validation()
public class ReservarCitaAction extends BaseAction{

    private Integer rbtCita;

    @Override
    public String execute() throws Exception {
        try {
            // Servicios
            HorarioService horarioService = new HorarioService();
            CitaService citaService = new CitaService();
            PacienteService pacienteService = new PacienteService();

            // Variables
            HttpSession sesion = request.getSession();
            Usuario usuario = null;
            Paciente paciente = null;
            Horario horario = null;
            Cita citaPendiente = null;
            String errorMsg = "";

            usuario = (Usuario) sesion.getAttribute("usuario");
            pacienteService = new PacienteService();
            paciente = pacienteService.getPacientePorId(usuario.getPersona().getPersonaId());

            //Si no es paciente
            if (paciente == null) {
                sesion.setAttribute("errorMsg", "Ud. no esta registrado como paciente.");
                return INPUT;
            }

            horario = horarioService.getHorarioPorId(rbtCita);

            //Obtener dia inicio y fin de la semana
            Calendar cal = new GregorianCalendar();
            cal.setTimeInMillis(horario.getFechaInicio().getTime());
            cal = DateUtils.truncate(cal, Calendar.DATE);

            if (cal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
                cal.add(Calendar.DATE, -1 * (cal.get(Calendar.DAY_OF_WEEK) - 2));
            } else {
                cal.add(Calendar.DATE, -6);
            }
            Date fecIni = cal.getTime();
            cal.add(Calendar.DATE, 7);
            Date fecFin = cal.getTime();

            //Obtener la cita del paciente para la semana seleccionada
            citaPendiente = citaService.getCitaSemPendiente(paciente, fecIni, fecFin, horario.getMedico(), horario.getEspecialidad());

            // Si el horario seleccionado es igual a la cita pendiente, entonces se terminar el proceso
            if (citaPendiente != null && citaPendiente.getHorario().equals(horario)) {
                return null;
            }
            // Se verifica que no exista una cita para el horario seleccionado
            if (horario.getCita() == null) {
                // Se verifica que el paciente no poseea ninguna cita pendiente
                // para la fecha seleccionada
                List<Cita> citas = citaService.getCitasPorPacienteFecha(paciente, horario.getFechaInicio(), true);
                if (citas.size() == 0) {
                    // Se verifica que la fecha seleccionada tenga un lapso de dos
                    // días de diferencia con la fecha actual
                    Calendar today = DateUtils.truncate(Calendar.getInstance(), Calendar.DATE);
                    today.add(Calendar.DATE, 2);

                    if (horario.getFechaInicio().getTime() > today.getTimeInMillis()) {
                        if (citaService.insertarCita(paciente, horario)) {
                            // Se verifica que el paciente no posea ninguna cita pendiente durante
                            // la semana para la especialidad y el medico seleccionado
                            if (citaPendiente != null) {
                                citaService.eliminarCita(citaPendiente);
                                errorMsg = "Se ha eliminado la cita del " +
                                        DateFormatUtils.format(citaPendiente.getHorario().getFechaInicio(), "EEEE dd 'de' MMMM 'del' yyyy, k:mm 'hrs.'") + "<br />";
                            }
                            errorMsg += "La cita ha sido grabada correctamente.";
                            sesion.setAttribute("citasPendientes",
                                    ReservarCitaCommons.cargarCitasPendientes(((Usuario) sesion.getAttribute("usuario")).getPersona()));

                            sesion.setAttribute("errorMsg", errorMsg);
                            return SUCCESS;
                        } else {
                            sesion.setAttribute("errorMsg", "No se ha podido grabar la cita. Por favor, vuelva a intentarlo más tarde.");
                            return INPUT;
                        }
                    } else {
                        sesion.setAttribute("errorMsg", "El plazo mínimo para reservar es de dos (2) días.");
                        return INPUT;
                    }
                } else {
                    sesion.setAttribute("errorMsg", "Usted ya posee una cita para la fecha y hora seleccionada.");
                    return INPUT;
                }
            } else {
                sesion.setAttribute("errorMsg", "El horario seleccionado no está disponible.");
                return INPUT;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("errorMsg", ex.getMessage());
            return ERROR;
        }
    }

    /**
     * @return the rbtCita
     */
    public Integer getRbtCita() {
        return rbtCita;
    }

    /**
     * @param rbtCita the rbtCita to set
     */
    @RequiredFieldValidator(message = "Por favor, seleccione un médico.")
    public void setRbtCita(Integer rbtCita) {
        this.rbtCita = rbtCita;
    }
}

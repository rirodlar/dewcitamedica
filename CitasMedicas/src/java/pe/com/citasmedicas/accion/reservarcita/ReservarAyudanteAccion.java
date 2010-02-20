/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.citasmedicas.accion.reservarcita;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;
import pe.com.citasmedicas.accion.AyudanteAccion;
import pe.com.citasmedicas.model.Cita;
import pe.com.citasmedicas.model.Horario;
import pe.com.citasmedicas.model.Paciente;
import pe.com.citasmedicas.model.Usuario;
import pe.com.citasmedicas.service.CitaService;
import pe.com.citasmedicas.service.HorarioService;
import pe.com.citasmedicas.service.PacienteService;

/**
 *
 * @author rSaenz
 */
public class ReservarAyudanteAccion implements AyudanteAccion {

    @Override
    public String procesar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
                return null;
            }

            // Se obtiene el horario seleccionado en el jsp
            String sHorarioId = request.getParameter("rbtCita");

            if (StringUtils.isEmpty(sHorarioId)) {
                sesion.setAttribute("errorMsg", "Por favor, seleccione un horario.");
                return null;
            }

            Integer horarioId = null;
            try {
                horarioId = new Integer(Integer.parseInt(sHorarioId));
            } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println("sHorarioId: " + sHorarioId);
                sesion.setAttribute("errorMsg", "El horario no existe.");
                return null;
            }

            horario = horarioService.getHorarioPorId(horarioId);

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
                        Cita nuevaCita = citaService.insertarCita(paciente, horario.getMedico(), horario, "PENDIENTE", null);
                        if (nuevaCita != null) {
                            // Se verifica que el paciente no posea ninguna cita pendiente durante
                            // la semana para la especialidad y el medico seleccionado
                            if (citaPendiente != null) {
                                citaService.eliminarCita(citaPendiente);
                                errorMsg = "Se ha eliminado la cita del " +
                                        DateFormatUtils.format(citaPendiente.getHorario().getFechaInicio(), "EEEE dd 'de' MMMM 'del' yyyy, k:mm 'hrs.'") + "<br />";
                            }

                            horario.setCita(nuevaCita);
                            horarioService.actualizarHorario(horario);
                            errorMsg += "La cita ha sido grabada correctamente.";
                            sesion.setAttribute("errorMsg", errorMsg);
                            return null;
                        } else {
                            sesion.setAttribute("errorMsg", "No se ha podido grabar la cita. Por favor, vuelva a intentarlo más tarde.");
                            return null;
                        }
                    } else {
                        sesion.setAttribute("errorMsg", "El plazo mínimo para reservar es de dos (2) días.");
                        return null;
                    }
                } else {
                    sesion.setAttribute("errorMsg", "Usted ya posee una cita para la fecha y hora seleccionada.");
                    return null;
                }
            } else {
                sesion.setAttribute("errorMsg", "El horario seleccionado no está disponible.");
                return null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return AyudanteAccion.ERROR;
        }
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.citasmedicas.accion.reservarcita;

import java.io.IOException;
import java.util.Calendar;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.com.citasmedicas.accion.AyudanteAccion;
import pe.com.citasmedicas.commons.ValidationUtil;
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
            Integer especialidadId = null;
            Usuario usuario = null;
            Paciente paciente = null;
            Integer medicoId = null;
            String fechaSemana = "";
            String errorMsg = "";
            Cita citaPendiente = null;

            //
            usuario = (Usuario) sesion.getAttribute("usuario");
            pacienteService = new PacienteService();
            paciente = pacienteService.getPacientePorId(usuario.getPersona().getPersonaId());

            fechaSemana = request.getParameter("txtSemana");
            especialidadId = Integer.parseInt(request.getParameter("cboEspecialidad"));
            medicoId = Integer.parseInt(request.getParameter("cboMedico"));

            //Si no es paciente
            if (paciente == null) {
                request.setAttribute("errorMsg", "Ud. no esta registrado como paciente.");
                return null;
            }

            // Se obtiene el horario seleccionado en el jsp
            String sHorarioId = request.getParameter("rbtCita");

            if (sHorarioId == null || sHorarioId.equalsIgnoreCase("")) {
                request.setAttribute("errorMsg", "Por favor, seleccione un horario.");
                return null;
            }

            Integer horarioId = null;
            try {
                horarioId = new Integer(Integer.parseInt(sHorarioId));
            } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println("sHorarioId: " + sHorarioId);
                request.setAttribute("errorMsg", "El horario no existe.");
                return null;
            }

            //Obtener la cita del paciente para la semana seleccionada
            List<Cita> citasPendientesPaciente = citaService.getCitasPendientes(paciente, ValidationUtil.parseDate(fechaSemana), medicoId, especialidadId);
            for (Cita cita : citasPendientesPaciente) {
                citaPendiente = cita;
                break;
            }

            Horario horario = horarioService.getHorarioPorId(horarioId);
            // Si el horario seleccionado es igual a la cita pendiente, entonces se terminar el proceso
            if (citaPendiente != null && citaPendiente.getHorario().equals(horario)) {
                return null;
            }
            // Se verifica que no exista una cita para el horario seleccionado
            if (horario.getCita() == null) {
                // Se verifica que el paciente no posea ninguna cita pendiente durante
                // la semana para la especialidad y el medico seleccionado
                if (citaPendiente != null) {
                    citaService.eliminarCita(citaPendiente);
                    Formatter formatter = new Formatter(Locale.getDefault());
                    formatter.format("%1$tA %1$td de %1$tB del %1$tY, %1$tH:%1$tM hrs.", citaPendiente.getHorario().getHoraInicio());
                    errorMsg = "Se ha eliminado la cita del " + formatter.toString();
                }
                // Se verifica que el paciente no poseea ninguna cita pendiente
                // para la fecha seleccionada
                List<Cita> citas = citaService.getCitasPorPacienteFecha(paciente, horario.getFechaInicio(), true);
                if (citas.size() == 0) {
                    // Se verifica que la fecha seleccionada tenga un lapso de dos
                    // días de diferencia con la fecha actual
                    Calendar today = Calendar.getInstance();
                    if (horario.getFechaInicio().getTime() - today.getTimeInMillis() >= 172800000) {
                        Cita nuevaCita = citaService.insertarCita(paciente, horario.getMedico(), horario, "PENDIENTE", null);
                        if (nuevaCita != null) {
                            horario.setCita(nuevaCita);
                            horarioService.actualizarHorario(horario);
                            errorMsg += "<br />La cita ha sido grabada correctamente.";
                            request.setAttribute("errorMsg", errorMsg);
                            return null;
                        } else {
                            request.setAttribute("errorMsg", "No se ha podido grabar la cita. Por favor, vuelva a intentarlo más tarde.");
                            return null;
                        }
                    } else {
                        request.setAttribute("errorMsg", "El plazo mínimo para reservar es de dos (2) días.");
                        return null;
                    }
                } else {
                    request.setAttribute("errorMsg", "Usted ya posee una cita para la fecha y hora seleccionada.");
                    return null;
                }
            } else {
                request.setAttribute("errorMsg", "El horario seleccionado no está disponible.");
                return null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return AyudanteAccion.ERROR;
        }
    }
}

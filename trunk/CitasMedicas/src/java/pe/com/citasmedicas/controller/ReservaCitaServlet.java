package pe.com.citasmedicas.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.com.citasmedicas.commons.SYGFormatter;
import pe.com.citasmedicas.model.Cita;
import pe.com.citasmedicas.model.Especialidad;
import pe.com.citasmedicas.model.Horario;
import pe.com.citasmedicas.model.Medico;
import pe.com.citasmedicas.model.Paciente;
import pe.com.citasmedicas.model.Persona;
import pe.com.citasmedicas.model.Usuario;
import pe.com.citasmedicas.service.CitaService;
import pe.com.citasmedicas.service.EspecialidadService;
import pe.com.citasmedicas.service.HorarioService;
import pe.com.citasmedicas.service.MedicoService;
import pe.com.citasmedicas.service.PacienteService;

/**
 *
 * @author rSaenz
 */
public class ReservaCitaServlet extends HttpServlet {

    //
    HttpSession sesion = null;
    //
    EspecialidadService especialidadService = null;
    MedicoService medicoService = null;
    HorarioService horarioService = null;
    CitaService citaService = null;
    //
    List<Especialidad> especialidades = null;
    List<Medico> medicos = null;
    Integer especialidadId = null;
    Integer medicoId = null;
    String errorMsg = null;
    String fechaSemana = null;
    //
    List<String> citasPendientes = null;
    List<String> cabeceraSemana = null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doIt(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doIt(request, response);
    }

    private void doIt(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Se verifica la sesión
        sesion = request.getSession();

        if (sesion.getAttribute("usuario") == null) {
            System.out.println("la sesión ha caducado");
            response.sendRedirect(request.getContextPath() + "/loguin.jsp");
            return;
        }
        //
        especialidadService = new EspecialidadService();
        medicoService = new MedicoService();
        horarioService = new HorarioService();
        citaService = new CitaService();
        errorMsg = null;
        //
        String accion = request.getParameter("__ACTION");
        if (accion == null || accion.equalsIgnoreCase("")) {
            accion = "iniciar";
        }
        System.out.println("Accion: " + accion);
        if (accion.equals("iniciar")) {
            iniciar(request, response);
        } else if (accion.equals("cboEspecialidad_onchange")) {
            cargaMedico(request, response);
        } else if (accion.equals("btnVerHorario_onclick")) {
            cargaHorario(request, response);
        } else if (accion.equals("btnReservar_onclick")) {
            reservar(request, response);
        }

        sesion.setAttribute("especialidades", especialidades);
        sesion.setAttribute("especialidadId", especialidadId);
        sesion.setAttribute("medicos", medicos);
        sesion.setAttribute("medicoId", medicoId);
        sesion.setAttribute("errorMsg", errorMsg);
        sesion.setAttribute("fechaSemana", fechaSemana);
        response.sendRedirect(request.getContextPath() + "/prc/reservar_cita.jsp");
    }

    private void iniciar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Se recuperan todas las especialidades
        especialidades = especialidadService.getEspecialidades();
        if (especialidades == null) {
            especialidades = new ArrayList<Especialidad>();
        }
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

        if (fechaSemana == null || fechaSemana.equalsIgnoreCase(""))
            fechaSemana = SYGFormatter.formatDate(new Date());
        //
        cargarCitasPendientes();
        
        // Se inicializa la cabecera de los horarios
        cabeceraSemana = new ArrayList<String>();
        cabeceraSemana.add("Lunes");
        cabeceraSemana.add("Martes");
        cabeceraSemana.add("Miércoles");
        cabeceraSemana.add("Jueves");
        cabeceraSemana.add("Viernes");
        cabeceraSemana.add("Sábado");
        cabeceraSemana.add("Domingo");
        sesion.setAttribute("cabeceraSemana", cabeceraSemana);
    }

    private void cargaMedico(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        especialidades = (List<Especialidad>) sesion.getAttribute("especialidades");
        especialidadId = Integer.parseInt(request.getParameter("cboEspecialidad"));
        // Se recuperan todos los médicos de la especialidad seleccionada
        Especialidad especialidad = especialidadService.getEspecialidadPorId(especialidadId);
        if (especialidad != null) {
            medicos = medicoService.getMedicosPorEspecialidad(especialidad);
            if (medicos == null) {
                medicos = new ArrayList<Medico>();
            }
            if (medicos.size() > 0) {
                medicoId = medicos.get(0).getPersonaId();
            }
        }
        fechaSemana = request.getParameter("txtSemana");
    }

    private void cargaHorario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //
        List<Horario> horarioLunes = null;
        List<Horario> horarioMartes = null;
        List<Horario> horarioMiercoles = null;
        List<Horario> horarioJueves = null;
        List<Horario> horarioViernes = null;
        List<Horario> horarioSabado = null;
        List<Horario> horarioDomingo = null;
        //
        horarioService = new HorarioService();
        //
        especialidadId = Integer.parseInt(request.getParameter("cboEspecialidad"));
        medicoId = Integer.parseInt(request.getParameter("cboMedico"));

        Especialidad especialidad = especialidadService.getEspecialidadPorId(especialidadId);
        Medico medico = medicoService.getMedicoPorId(medicoId);

        Calendar cal = new GregorianCalendar();
        String fecha = request.getParameter("txtSemana"); // obtener fecha desde el jsp
        cal.set(Calendar.YEAR, Integer.parseInt(fecha.substring(6)));
        cal.set(Calendar.MONTH, Integer.parseInt(fecha.substring(3, 5)) - 1);
        cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(fecha.substring(0, 2)));

        if (cal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
            cal.add(Calendar.DATE, -1 * (cal.get(Calendar.DAY_OF_WEEK) - 2));
        } else {
            cal.add(Calendar.DATE, -6);
        }

        // Se inicializa la cabecera de la semana
        cabeceraSemana = new ArrayList<String>();
        // Se recuperan los horarios para el día lunes
        horarioLunes = horarioService.getHorariosPorEspecMedicoFecha(especialidad, medico, cal.getTime());
        // Se establece la cabecera del día lunes
        Formatter formatter = new Formatter(Locale.getDefault());
        formatter.format("%1$ta %1$td/%1$tm", cal);
        cabeceraSemana.add(formatter.toString());
        // Se recuperan los horarios para el día martes
        cal.add(Calendar.DATE, 1);
        horarioMartes = horarioService.getHorariosPorEspecMedicoFecha(especialidad, medico, cal.getTime());
        // Se establece la cabecera del día martes
        formatter = new Formatter(Locale.getDefault());
        formatter.format("%1$ta %1$td/%1$tm", cal);
        cabeceraSemana.add(formatter.toString());
        // Se recuperan los horarios para el día miércoles
        cal.add(Calendar.DATE, 1);
        horarioMiercoles = horarioService.getHorariosPorEspecMedicoFecha(especialidad, medico, cal.getTime());
        // Se establece la cabecera del día miércoles
        formatter = new Formatter(Locale.getDefault());
        formatter.format("%1$ta %1$td/%1$tm", cal);
        cabeceraSemana.add(formatter.toString());
        // Se recuperan los horarios para el día jueves
        cal.add(Calendar.DATE, 1);
        horarioJueves = horarioService.getHorariosPorEspecMedicoFecha(especialidad, medico, cal.getTime());
        // Se establece la cabecera del día jueves
        formatter = new Formatter(Locale.getDefault());
        formatter.format("%1$ta %1$td/%1$tm", cal);
        cabeceraSemana.add(formatter.toString());
        // Se recuperan los horarios para el día viernes
        cal.add(Calendar.DATE, 1);
        horarioViernes = horarioService.getHorariosPorEspecMedicoFecha(especialidad, medico, cal.getTime());
        // Se establece la cabecera del día viernes
        formatter = new Formatter(Locale.getDefault());
        formatter.format("%1$ta %1$td/%1$tm", cal);
        cabeceraSemana.add(formatter.toString());
        // Se recuperan los horarios para el día sábado
        cal.add(Calendar.DATE, 1);
        horarioSabado = horarioService.getHorariosPorEspecMedicoFecha(especialidad, medico, cal.getTime());
        // Se establece la cabecera del día sábado
        formatter = new Formatter(Locale.getDefault());
        formatter.format("%1$ta %1$td/%1$tm", cal);
        cabeceraSemana.add(formatter.toString());
        // Se recuperan los horarios para el día domingo
        cal.add(Calendar.DATE, 1);
        horarioDomingo = horarioService.getHorariosPorEspecMedicoFecha(especialidad, medico, cal.getTime());
        // Se establece la cabecera del día domingo
        formatter = new Formatter(Locale.getDefault());
        formatter.format("%1$ta %1$td/%1$tm", cal);
        cabeceraSemana.add(formatter.toString());

        // Se construye el filtro
        String filtro = "Filtro: Especialidad = " + especialidad.getNombre() +
                "; Medico = " + medico.getNombreCompleto() +
                "; Semana = Del ";
        cal.add(Calendar.DATE, -6);
        formatter = new Formatter(Locale.getDefault());
        formatter.format("%1$td/%1$tm/%1$tY", cal);
        filtro += formatter.toString();
        cal.add(Calendar.DATE, 6);
        formatter = new Formatter(Locale.getDefault());
        formatter.format("%1$td/%1$tm/%1$tY", cal);
        filtro += " al " + formatter.toString();

        // Se recuperan los horarios de atención
        // Primero se recupera el horario de atención del instituto
        List<Horario> horarioAtencion = horarioService.getHorarioAtencion();
        // Se crea un arreglo con los candidatos a eliminar
        List<Horario> horarioEliminar = new ArrayList<Horario>();
        // Se verifica si existe atención para algún día de la semana
        for (Horario atencion : horarioAtencion) {
            boolean existe = false;
            existe = existeHorario(atencion, horarioLunes);
            if (!existe) {
                existe = existeHorario(atencion, horarioMartes);
            }
            if (!existe) {
                existe = existeHorario(atencion, horarioMiercoles);
            }
            if (!existe) {
                existe = existeHorario(atencion, horarioJueves);
            }
            if (!existe) {
                existe = existeHorario(atencion, horarioViernes);
            }
            if (!existe) {
                existe = existeHorario(atencion, horarioSabado);
            }
            if (!existe) {
                existe = existeHorario(atencion, horarioDomingo);
            }
            if (!existe) {
                horarioEliminar.add(atencion);
            }
        }
        // Se eliminan los horarios sin atención
        for (Horario h : horarioEliminar) {
            horarioAtencion.remove(h);
        }

        sesion.setAttribute("horarioAtencion", horarioAtencion);
        sesion.setAttribute("horarioLunes", horarioLunes);
        sesion.setAttribute("horarioMartes", horarioMartes);
        sesion.setAttribute("horarioMiercoles", horarioMiercoles);
        sesion.setAttribute("horarioJueves", horarioJueves);
        sesion.setAttribute("horarioViernes", horarioViernes);
        sesion.setAttribute("horarioSabado", horarioSabado);
        sesion.setAttribute("horarioDomingo", horarioDomingo);
        sesion.setAttribute("cabeceraSemana", cabeceraSemana);
        sesion.setAttribute("filtro", filtro);

        fechaSemana = request.getParameter("txtSemana");
    }

    private void reservar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        fechaSemana = request.getParameter("txtSemana");
        
        // Se obtiene el horario seleccionado en el jsp
        String sHorarioId = request.getParameter("radio");

        if (sHorarioId == null || sHorarioId.equalsIgnoreCase("")) {
            errorMsg = "Por favor, seleccione un horario.";
            return;
        }

        Integer horarioId = null;
        try {
            horarioId = new Integer(Integer.parseInt(sHorarioId));
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("sHorarioId: " + sHorarioId);
            errorMsg = "El horario no existe.";
            return;
        }

        Cita citaPendiente = (Cita) sesion.getAttribute("citaPendiente");

        try {
            Horario horario = horarioService.getHorarioPorId(horarioId);
            // Si el horario seleccionado es igual a la cita pendiente, entonces se terminar el proceso
            if(citaPendiente != null && citaPendiente.getHorario().equals(horario)){
                return;
            }
            // Se verifica que no exista una cita para el horario seleccionado
            if (horario.getCita() == null) {
                // Se verifica que el paciente no poseea ninguna cita pendiente durante
                // la semana para la especialidad y el medico seleccionado
                if (citaPendiente != null) {
                    citaService.eliminarCita(citaPendiente);
                    Formatter formatter = new Formatter(Locale.getDefault());
                    formatter.format("%1$tA %1$td de %1$tB del %1$tY, %1$tH:%1$tM hrs.", citaPendiente.getHorario().getHoraInicio());
                    errorMsg = "Se ha eliminado la cita del " + formatter.toString();
                }
                // Se verifica que el paciente no poseea ninguna cita pendiente
                // para la fecha seleccionada
                List<Cita> citas = citaService.getCitasPorPacienteFecha(null, horario.getFechaInicio(), true);
                if (citas.size() == 0) {
                    // Se verifica que la fecha seleccionada tenga un lapso de dos
                    // días de diferencia con la fecha actual
                    Calendar today = Calendar.getInstance();
                    if (horario.getFechaInicio().getTime() - today.getTimeInMillis() >= 172800000) {
                        Usuario usuario = (Usuario) sesion.getAttribute("usuario");
                        PacienteService pacienteService = new PacienteService();
                        Paciente paciente = pacienteService.getPacientePorId(usuario.getPersona().getPersonaId());
                        Cita nuevaCita = citaService.insertarCita(paciente, horario.getMedico(), horario, "PENDIENTE", null);
                        if (nuevaCita != null) {
                            cargarCitasPendientes();
                            horario.setCita(nuevaCita);
                            horarioService.actualizarHorario(horario);
                            errorMsg = "La cita ha sido grabada correctamente.";
                            return;
                        }
                        else{
                            errorMsg = "No se ha podido grabar la cita. Por favor, vuelva a intentarlo más tarde.";
                            return;
                        }
                    } else {
                        errorMsg = "El plazo mínimo para reservar es de dos (2) días.";
                        return;
                    }
                } else {
                    errorMsg = "Usted ya posee una cita para la fecha y hora seleccionada.";
                    return;
                }
            } else {
                errorMsg = "El horario seleccionado no está disponible.";
                return;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            errorMsg = "Se produjo un error inesperado.";
            return;
        }
        /*
        1.- si la citaActual es nula: paso 2 / caso contrario: paso 5
        2.- si el horario no posee ninguna cita: paso 3 / caso contrario: salir con error
        3.- el paciente no poseea ninguna cita pendiente durante la semana
        con el mismo medico y la misma especialidad: paso 4 / caso contrario: salir con error
        4.- la fecha actual es menor a dos días de la fecha de la cita: grabar y salir
        / caso contrario: salir con error
        5.- si la cita actual pertenece al mismo horario -> salir
        6.- si la cita actual no pertenece al mismo horario -> eliminar cita e ir al paso 2
         */
    }

    private boolean existeHorario(Horario atencion, List<Horario> horarios) {
        boolean existe = false;
        for (Horario domingo : horarios) {
            if (domingo.getHoraInicio() == atencion.getHoraInicio() &&
                    domingo.getMinutoInicio() == atencion.getMinutoInicio()) {
                existe = true;
                break;
            }
        }
        return existe;
    }

    private void cargarCitasPendientes() {
        citasPendientes = new ArrayList<String>();
        Usuario usuario = (Usuario) sesion.getAttribute("usuario");
        Persona paciente = null;
        if (usuario != null) {
            paciente = usuario.getPersona();
        }
        if (paciente != null) {
            List<Cita> citas = citaService.getCitasPendientes(paciente);
            for (Cita cita : citas) {
                String citaPendiente = "";
                Formatter formatter = new Formatter(Locale.getDefault());
                formatter.format("%1$tA %1$td de %1$tB del %1$tY, %1$tH:%1$tM hrs.", cita.getHorario().getFechaInicio());
                citaPendiente = formatter.toString() + " : " + cita.getHorario().getEspecialidad().getNombre() + " - " + cita.getHorario().getMedico().getNombreCompleto();
                citasPendientes.add(citaPendiente);
            }
        }
        sesion.setAttribute("citasPendientes", citasPendientes);
    }
}

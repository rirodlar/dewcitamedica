/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.citasmedicas.accion.reservarcita;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Formatter;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang.time.DateFormatUtils;
import pe.com.citasmedicas.accion.AyudanteAccion;
import pe.com.citasmedicas.model.Especialidad;
import pe.com.citasmedicas.model.Horario;
import pe.com.citasmedicas.model.Medico;
import pe.com.citasmedicas.service.EspecialidadService;
import pe.com.citasmedicas.service.HorarioService;
import pe.com.citasmedicas.service.MedicoService;

/**
 *
 * @author rSaenz
 */
public class BuscarHorarioAyudanteAccion implements AyudanteAccion {

    @Override
    public String procesar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Servicios
            HorarioService horarioService = new HorarioService();
            EspecialidadService especialidadService = new EspecialidadService();
            MedicoService medicoService = new MedicoService();

            //Variables
            HttpSession sesion = request.getSession();
            List<String> cabeceraSemana = new ArrayList<String>();
            Integer especialidadId = Integer.parseInt(request.getParameter("cboEspecialidad"));
            Integer medicoId = Integer.parseInt(request.getParameter("cboMedico"));
            String fechaSemana = request.getParameter("txtSemana");
            String filtro = "";
            Especialidad especialidad = null;
            Medico medico = null;
            List<Horario> horarioLunes = null;
            List<Horario> horarioMartes = null;
            List<Horario> horarioMiercoles = null;
            List<Horario> horarioJueves = null;
            List<Horario> horarioViernes = null;
            List<Horario> horarioSabado = null;
            List<Horario> horarioDomingo = null;
            //
            especialidad = especialidadService.getEspecialidadPorId(especialidadId);
            medico = medicoService.getMedicoPorId(medicoId);

            Calendar cal = new GregorianCalendar();
            cal.set(Calendar.YEAR, Integer.parseInt(fechaSemana.substring(6)));
            cal.set(Calendar.MONTH, Integer.parseInt(fechaSemana.substring(3, 5)) - 1);
            cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(fechaSemana.substring(0, 2)));

            if (cal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
                cal.add(Calendar.DATE, -1 * (cal.get(Calendar.DAY_OF_WEEK) - 2));
            } else {
                cal.add(Calendar.DATE, -6);
            }

            // Se recuperan los horarios para el día lunes
            horarioLunes = horarioService.getHorariosPorEspecMedicoFecha(especialidad, medico, cal.getTime());
            // Se establece la cabecera del día lunes
            cabeceraSemana.add(DateFormatUtils.format(cal.getTime(), "EEE dd/MM"));
            // Se recuperan los horarios para el día martes
            cal.add(Calendar.DATE, 1);
            horarioMartes = horarioService.getHorariosPorEspecMedicoFecha(especialidad, medico, cal.getTime());
            // Se establece la cabecera del día martes
            cabeceraSemana.add(DateFormatUtils.format(cal.getTime(), "EEE dd/MM"));
            // Se recuperan los horarios para el día miércoles
            cal.add(Calendar.DATE, 1);
            horarioMiercoles = horarioService.getHorariosPorEspecMedicoFecha(especialidad, medico, cal.getTime());
            // Se establece la cabecera del día miércoles
            cabeceraSemana.add(DateFormatUtils.format(cal.getTime(), "EEE dd/MM"));
            // Se recuperan los horarios para el día jueves
            cal.add(Calendar.DATE, 1);
            horarioJueves = horarioService.getHorariosPorEspecMedicoFecha(especialidad, medico, cal.getTime());
            // Se establece la cabecera del día jueves
            cabeceraSemana.add(DateFormatUtils.format(cal.getTime(), "EEE dd/MM"));
            // Se recuperan los horarios para el día viernes
            cal.add(Calendar.DATE, 1);
            horarioViernes = horarioService.getHorariosPorEspecMedicoFecha(especialidad, medico, cal.getTime());
            // Se establece la cabecera del día viernes
            cabeceraSemana.add(DateFormatUtils.format(cal.getTime(), "EEE dd/MM"));
            // Se recuperan los horarios para el día sábado
            cal.add(Calendar.DATE, 1);
            horarioSabado = horarioService.getHorariosPorEspecMedicoFecha(especialidad, medico, cal.getTime());
            // Se establece la cabecera del día sábado
            cabeceraSemana.add(DateFormatUtils.format(cal.getTime(), "EEE dd/MM"));
            // Se recuperan los horarios para el día domingo
            cal.add(Calendar.DATE, 1);
            horarioDomingo = horarioService.getHorariosPorEspecMedicoFecha(especialidad, medico, cal.getTime());
            // Se establece la cabecera del día domingo
            cabeceraSemana.add(DateFormatUtils.format(cal.getTime(), "EEE dd/MM"));

            // Se construye el filtro
            filtro = "Filtro: Especialidad = " + especialidad.getNombre() +
                    "; Medico = " + medico.getNombreCompleto() +
                    "; Semana = Del ";
            cal.add(Calendar.DATE, -6);
            Formatter formatter = new Formatter(Locale.getDefault());
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
            sesion.setAttribute("especialidadId", especialidadId);
            sesion.setAttribute("medicoId", medicoId);
            sesion.setAttribute("fechaSemana", fechaSemana);
            sesion.setAttribute("filtro", filtro);
            sesion.setAttribute("errorMsg", "");
            return null;
        } catch (Exception ex) {
            ex.printStackTrace();
            return AyudanteAccion.ERROR;
        }
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
}

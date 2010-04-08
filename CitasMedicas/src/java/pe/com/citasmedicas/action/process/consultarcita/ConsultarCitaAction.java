package pe.com.citasmedicas.action.process.consultarcita;

import com.opensymphony.xwork2.conversion.annotations.Conversion;
import com.opensymphony.xwork2.conversion.annotations.TypeConversion;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
import pe.com.citasmedicas.service.MedicoService;
import pe.com.citasmedicas.model.Horario;
import pe.com.citasmedicas.model.Medico;
import pe.com.citasmedicas.model.Usuario;
import pe.com.citasmedicas.service.CitaService;
import pe.com.citasmedicas.service.HorarioService;

/**
 * Esta clase contiene los métodos utilizados por la funcionalidad Consultar Cita
 * @author dew - Grupo 04
 */
@Namespace(value = "/consulta")
@ParentPackage(value = "citaMedica")
@Results({
    @Result(name = "success", value = "/prc/consulta.jsp", type = ServletDispatcherResult.class)
})
@Conversion()
public class ConsultarCitaAction extends BaseAction {

    private Date txtSemana;
    private HorarioService horarioService;
    private CitaService citaService;
    private MedicoService medicoService;

    /**
     * Método encargado de ejecutar la acción solicitada
     * @return resultado de la accion
     */
    @Override
    public String execute() {
        try {
            validarAutenticacion(request);
            // Variables
            HttpSession sesion = request.getSession();
            Usuario usuario = null;
            Medico medico = null;

            List<String> cabeceraSemana = new ArrayList<String>();
            String errorMsg = "";
            List<Horario> horarioLunes = null;
            List<Horario> horarioMartes = null;
            List<Horario> horarioMiercoles = null;
            List<Horario> horarioJueves = null;
            List<Horario> horarioViernes = null;
            List<Horario> horarioSabado = null;
            List<Horario> horarioDomingo = null;

            usuario = (Usuario) sesion.getAttribute("usuario");
            medico = medicoService.getMedicoPorId(usuario.getPersona().getPersonaId());

            //Recuperar horarios (cabecera y contenido)
            Calendar cal = new GregorianCalendar();

            if (txtSemana == null) {
                txtSemana = new Date();
            }

            cal.setTime(txtSemana);
            if (cal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
                cal.add(Calendar.DATE, -1 * (cal.get(Calendar.DAY_OF_WEEK) - 2));
            } else {
                cal.add(Calendar.DATE, -6);
            }
            // Se recuperan los horarios para el día lunes
            horarioLunes = horarioService.getHorariosPorEspecMedicoFecha(-1, medico.getPersonaId(), cal.getTime());
            // Se establece la cabecera del día lunes
            cabeceraSemana.add(DateFormatUtils.format(cal.getTime(), "EEE dd/MM"));
            // Se recuperan los horarios para el día martes
            cal.add(Calendar.DATE, 1);
            horarioMartes = horarioService.getHorariosPorEspecMedicoFecha(-1, medico.getPersonaId(), cal.getTime());
            // Se establece la cabecera del día martes
            cabeceraSemana.add(DateFormatUtils.format(cal.getTime(), "EEE dd/MM"));
            // Se recuperan los horarios para el día miércoles
            cal.add(Calendar.DATE, 1);
            horarioMiercoles = horarioService.getHorariosPorEspecMedicoFecha(-1, medico.getPersonaId(), cal.getTime());
            // Se establece la cabecera del día miércoles
            cabeceraSemana.add(DateFormatUtils.format(cal.getTime(), "EEE dd/MM"));
            // Se recuperan los horarios para el día jueves
            cal.add(Calendar.DATE, 1);
            horarioJueves = horarioService.getHorariosPorEspecMedicoFecha(-1, medico.getPersonaId(), cal.getTime());
            // Se establece la cabecera del día jueves
            cabeceraSemana.add(DateFormatUtils.format(cal.getTime(), "EEE dd/MM"));
            // Se recuperan los horarios para el día viernes
            cal.add(Calendar.DATE, 1);
            horarioViernes = horarioService.getHorariosPorEspecMedicoFecha(-1, medico.getPersonaId(), cal.getTime());
            // Se establece la cabecera del día viernes
            cabeceraSemana.add(DateFormatUtils.format(cal.getTime(), "EEE dd/MM"));
            // Se recuperan los horarios para el día sábado
            cal.add(Calendar.DATE, 1);
            horarioSabado = horarioService.getHorariosPorEspecMedicoFecha(-1, medico.getPersonaId(), cal.getTime());
            // Se establece la cabecera del día sábado
            cabeceraSemana.add(DateFormatUtils.format(cal.getTime(), "EEE dd/MM"));
            // Se recuperan los horarios para el día domingo
            cal.add(Calendar.DATE, 1);
            horarioDomingo = horarioService.getHorariosPorEspecMedicoFecha(-1, medico.getPersonaId(), cal.getTime());
            // Se establece la cabecera del día domingo
            cabeceraSemana.add(DateFormatUtils.format(cal.getTime(), "EEE dd/MM"));

            // Se recuperan los horarios de atención
            // Primero se recupera el horario de atención del instituto
            List<Horario> horarioAtencion = horarioService.getHorarioAtencion();
            // Se crea un arreglo con los candidatos a eliminar
            List<Horario> horarioEliminar = new ArrayList<Horario>();
            // Se verifica si existe atención para algún día de la semana
            for (Horario atencion : horarioAtencion) {
                if (!existeHorario(atencion, horarioLunes) &&
                        !existeHorario(atencion, horarioMartes) &&
                        !existeHorario(atencion, horarioMiercoles) &&
                        !existeHorario(atencion, horarioJueves) &&
                        !existeHorario(atencion, horarioViernes) &&
                        !existeHorario(atencion, horarioSabado) &&
                        !existeHorario(atencion, horarioDomingo)) {
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
            sesion.setAttribute("fechaSemana", DateFormatUtils.format(txtSemana, "dd/MM/yyyy"));
            sesion.setAttribute("errorMsg", errorMsg);

            return SUCCESS;
        } catch (SeguridadException se) {
            return LOGIN;
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("errorMsg", ex.getMessage());
            return ERROR;
        }
    }

    private boolean existeHorario(Horario atencion, List<Horario> horarios) {
        boolean existe = false;
        for (Horario horario : horarios) {
            if (horario.getHoraInicio() == atencion.getHoraInicio() &&
                    horario.getMinutoInicio() == atencion.getMinutoInicio()) {
                existe = true;
                break;
            }
        }
        return existe;
    }

    /**
     * @return the txtSemana
     */
    @TypeConversion(converter = "pe.com.citasmedicas.action.converter.DateConverter")
    public Date getTxtSemana() {
        return txtSemana;
    }

    /**
     * @param txtSemana the txtSemana to set
     */
    @TypeConversion(converter = "pe.com.citasmedicas.action.converter.DateConverter")
    //@RequiredFieldValidator(message = "Por favor, ingrese una fecha.")
    public void setTxtSemana(Date txtSemana) {
        this.txtSemana = txtSemana;
    }

    /**
     * Obtiene el servicio que maneja los médicos
     * @return servicio
     */
    public MedicoService getMedicoService() {
        return medicoService;
    }

    /**
     * Establece el servicio que maneja los médicos
     * @param medicoService servicio
     */
    public void setMedicoService(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    /**
     * Obtiene el servicio que maneja las citas
     * @return servicio
     */
    public CitaService getCitaService() {
        return citaService;
    }

    /**
     * Establece el servicio que maneja las citas
     * @param citaService servicio
     */
    public void setCitaService(CitaService citaService) {
        this.citaService = citaService;
    }

    /**
     * Obtiene el servicio que maneja los horarios
     * @return servicio
     */
    public HorarioService getHorarioService() {
        return horarioService;
    }

    /**
     * Establece el servicio que maneja los horarios
     * @param horarioService servicio
     */
    public void setHorarioService(HorarioService horarioService) {
        this.horarioService = horarioService;
    }
}

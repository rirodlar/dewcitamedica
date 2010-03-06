package pe.com.citasmedicas.action.reservarcita;

import com.opensymphony.xwork2.conversion.annotations.Conversion;
import com.opensymphony.xwork2.conversion.annotations.TypeConversion;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.Validation;
import org.apache.struts2.config.Result;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.struts2.config.Namespace;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletDispatcherResult;
import pe.com.citasmedicas.action.BaseAction;
import pe.com.citasmedicas.model.Especialidad;
import pe.com.citasmedicas.model.Horario;
import pe.com.citasmedicas.model.Medico;
import pe.com.citasmedicas.service.implement.EspecialidadServiceImpl;
import pe.com.citasmedicas.service.implement.HorarioServiceImpl;
import pe.com.citasmedicas.service.implement.MedicoServiceImpl;

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
@Conversion()
@Validation()
public class BuscarHorarioAction extends BaseAction {

    private Integer cboEspecialidad;
    private Integer cboMedico;
    private Date txtSemana;

    @Override
    public String execute() {
        try {
            // Servicios
            HorarioServiceImpl horarioService = new HorarioServiceImpl();
            EspecialidadServiceImpl especialidadService = new EspecialidadServiceImpl();
            MedicoServiceImpl medicoService = new MedicoServiceImpl();

            //Variables
            HttpSession sesion = request.getSession();
            List<String> cabeceraSemana = new ArrayList<String>();
            String filtro = "";
            String errorMsg = "";
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
            especialidad = especialidadService.getEspecialidadPorId(this.cboEspecialidad);
            medico = medicoService.getMedicoPorId(this.cboMedico);

            Calendar cal = new GregorianCalendar();
            cal.setTime(txtSemana);
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
            filtro += DateFormatUtils.format(cal.getTime(), "dd/MM/yyyy");
            cal.add(Calendar.DATE, 6);
            filtro += " al " + DateFormatUtils.format(cal.getTime(), "dd/MM/yyyy");

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
                    !existeHorario(atencion, horarioDomingo)){
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
            sesion.setAttribute("especialidadId", cboEspecialidad);
            sesion.setAttribute("medicoId", cboMedico);
            sesion.setAttribute("fechaSemana", DateFormatUtils.format(txtSemana, "dd/MM/yyyy"));
            sesion.setAttribute("filtro", filtro);
            sesion.setAttribute("errorMsg", errorMsg);
            return SUCCESS;
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
     * @return the cboEspecialidad
     */
    public Integer getCboEspecialidad() {
        return cboEspecialidad;
    }

    /**
     * @param cboEspecialidad the cboEspecialidad to set
     */
    @RequiredFieldValidator(message = "Por favor, seleccione una especialidad.")
    public void setCboEspecialidad(Integer cboEspecialidad) {
        this.cboEspecialidad = cboEspecialidad;
    }

    /**
     * @return the cboMedico
     */
    public Integer getCboMedico() {
        return cboMedico;
    }

    /**
     * @param cboMedico the cboMedico to set
     */
    @RequiredFieldValidator(message = "Por favor, seleccione un médico.")
    public void setCboMedico(Integer cboMedico) {
        this.cboMedico = cboMedico;
    }

    /**
     * @return the txtSemana
     */
    @TypeConversion(converter="pe.com.citasmedicas.action.converter.DateConverter")
    public Date getTxtSemana() {
        return txtSemana;
    }

    /**
     * @param txtSemana the txtSemana to set
     */
    @TypeConversion(converter="pe.com.citasmedicas.action.converter.DateConverter")
    @RequiredFieldValidator(message = "Por favor, ingrese una fecha.")
    public void setTxtSemana(Date txtSemana) {
        this.txtSemana = txtSemana;
    }

}

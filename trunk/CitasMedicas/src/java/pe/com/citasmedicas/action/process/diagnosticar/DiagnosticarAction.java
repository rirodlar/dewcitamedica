package pe.com.citasmedicas.action.process.diagnosticar;

import com.opensymphony.xwork2.conversion.annotations.TypeConversion;
import com.opensymphony.xwork2.conversion.annotations.Conversion;
import java.util.Date;
import javax.servlet.http.HttpSession;
import org.apache.struts2.config.Namespace;
import org.apache.struts2.config.ParentPackage;
import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletDispatcherResult;
import pe.com.citasmedicas.action.BaseAction;
import pe.com.citasmedicas.model.Cita;
import pe.com.citasmedicas.service.CitaService;

/**
 * Esta clase contiene los métodos utilizados por la funcionalidad Diagnosticar cita
 * @author dew - Grupo 04
 */
@Namespace(value = "/diagnostico")
@ParentPackage(value = "citaMedica")
@Results({
    @Result(name = "success", value = "/prc/diagnostico.jsp", type = ServletDispatcherResult.class),
    @Result(name = "input", value = "/prc/diagnostico.jsp", type = ServletDispatcherResult.class)
})
@Conversion()
public class DiagnosticarAction extends BaseAction {

    private CitaService citaService;
    private Double txtPeso;
    private Integer txtEstatura;
    private String txtSintomas;
    private String txtDiagnostico;
    private String txtReceta;
    private String txtAnalisis;
    private String txtObservaciones;
    private Date txtProximaCita;

    /**
     * Método encargado de ejecutar la acción solicitada
     * @return resultado de la accion
     */
    @Override
    @SuppressWarnings("static-access")
    public String execute() {
        try {
            validarAutenticacion(request);
            // Variables
            HttpSession sesion = request.getSession();
            Cita cita = null;

            cita = (Cita) sesion.getAttribute("cita");
            cita.getPaciente().setPeso(txtPeso);
            cita.getPaciente().setEstatura(txtEstatura);
            cita.setSintoma(txtSintomas);
            cita.setDiagnostico(txtDiagnostico);
            cita.setReceta(txtReceta);
            cita.setAnalisis(txtAnalisis);
            cita.setObservaciones(txtObservaciones);
            cita.setFechaProximaCita(txtProximaCita);
            cita.setEstado(Cita.ESTADO_ATENDIDO);

            if (citaService.actualizarCita(cita)) {
                return SUCCESS;
            } else {
                request.setAttribute("errorMsg", "No se pudo actualizar cita");
                return ERROR;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("errorMsg", ex.getMessage());
            return ERROR;
        }
    }

    /**
     * Obtiene el servicio que maneja las citas
     * @return citaService
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
     * Obtiene la descripción ingresada del análisis a realizar por diagnóstico
     * @return txtAnalisis
     */
    public String getTxtAnalisis() {
        return txtAnalisis;
    }

    /**
     * Establece la descripción del análisis a realizar por diagnóstico
     * @param txtAnalisis descripción del análisis
     */
    public void setTxtAnalisis(String txtAnalisis) {
        this.txtAnalisis = txtAnalisis;
    }

    /**
     * Obtiene la descripción ingresada del diagnóstico de la cita
     * @return txtDiagnostico descripción del diagnóstico
     */
    public String getTxtDiagnostico() {
        return txtDiagnostico;
    }

    /**
     * Establece la descripción del diagnóstico de la cita
     * @param txtDiagnostico descripción del diagnóstico
     */
    public void setTxtDiagnostico(String txtDiagnostico) {
        this.txtDiagnostico = txtDiagnostico;
    }

    /**
     * Obtiene la descripción ingresada de la estatura del paciente
     * @return txtEstatura descripcion de la estatura del paciente
     */
    public Integer getTxtEstatura() {
        return txtEstatura;
    }

    /**
     * Establece la descripción de la estatura del paciente
     * @param txtEstatura descripcion de la estatura del paciente
     */
    public void setTxtEstatura(Integer txtEstatura) {
        this.txtEstatura = txtEstatura;
    }

    /**
     * Obtiene la descripción ingresada de las observaciones del diagnóstico
     * @return txtObservaciones descripción de las observaciones del diagnóstico
     */
    public String getTxtObservaciones() {
        return txtObservaciones;
    }

    /**
     * Establece la descripción de las observaciones del diagnóstico
     * @param txtObservaciones descripción de las observaciones del diagnóstico
     */
    public void setTxtObservaciones(String txtObservaciones) {
        this.txtObservaciones = txtObservaciones;
    }

    /**
     * Obtiene la descripción ingresada del peso del paciente
     * @return txtPeso descripción del peso del paciente
     */
    public Double getTxtPeso() {
        return txtPeso;
    }

    /**
     * Establece la descripción del peso del paciente
     * @param txtPeso descripción del peso del paciente
     */
    public void setTxtPeso(Double txtPeso) {
        this.txtPeso = txtPeso;
    }

    /**
     * Obtiene la descripción ingresada de la fecha de la proxima cita
     * @return the txtProximaCita fecha de la proxima cita
     */
    @TypeConversion(converter = "pe.com.citasmedicas.action.converter.DateConverter")
    public Date getTxtProximaCita() {
        return txtProximaCita;
    }

    /**
     * Establece la descripción de la fecha de la proxima cita
     * @param txtProximaCita fecha de la proxima cita
     */
    @TypeConversion(converter = "pe.com.citasmedicas.action.converter.DateConverter")
    //@RequiredFieldValidator(message = "Por favor, ingrese una fecha.")
    public void setTxtProximaCita(Date txtProximaCita) {
        this.txtProximaCita = txtProximaCita;
    }

    /**
     * Obtiene la descripción ingresada de la receta del diagnóstico
     * @return txtReceta receta del diagnóstico
     */
    public String getTxtReceta() {
        return txtReceta;
    }

    /**
     * Establece la descripción de la receta del diagnóstico
     * @param txtReceta receta del diagnóstico
     */
    public void setTxtReceta(String txtReceta) {
        this.txtReceta = txtReceta;
    }

    /**
     * Obtiene la descripción ingresada de los síntomas del diagnóstico
     * @return txtSintomas síntomas del diagnóstico
     */
    public String getTxtSintomas() {
        return txtSintomas;
    }

    /**
     * Establece la descripción de los síntomas del diagnóstico
     * @param txtSintomas síntomas del diagnóstico
     */
    public void setTxtSintomas(String txtSintomas) {
        this.txtSintomas = txtSintomas;
    }
}

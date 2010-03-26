package pe.com.citasmedicas.action.process.diagnosticar;

import com.opensymphony.xwork2.conversion.annotations.TypeConversion;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
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
 *
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

    @Override
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

    public CitaService getCitaService() {
        return citaService;
    }

    public void setCitaService(CitaService citaService) {
        this.citaService = citaService;
    }

    public String getTxtAnalisis() {
        return txtAnalisis;
    }

    public void setTxtAnalisis(String txtAnalisis) {
        this.txtAnalisis = txtAnalisis;
    }

    public String getTxtDiagnostico() {
        return txtDiagnostico;
    }

    public void setTxtDiagnostico(String txtDiagnostico) {
        this.txtDiagnostico = txtDiagnostico;
    }

    public Integer getTxtEstatura() {
        return txtEstatura;
    }

    public void setTxtEstatura(Integer txtEstatura) {
        this.txtEstatura = txtEstatura;
    }

    public String getTxtObservaciones() {
        return txtObservaciones;
    }

    public void setTxtObservaciones(String txtObservaciones) {
        this.txtObservaciones = txtObservaciones;
    }

    public Double getTxtPeso() {
        return txtPeso;
    }

    public void setTxtPeso(Double txtPeso) {
        this.txtPeso = txtPeso;
    }

    /**
     * @return the txtSemana
     */
    @TypeConversion(converter = "pe.com.citasmedicas.action.converter.DateConverter")
    public Date getTxtProximaCita() {
        return txtProximaCita;
    }

    /**
     * @param txtSemana the txtSemana to set
     */
    @TypeConversion(converter = "pe.com.citasmedicas.action.converter.DateConverter")
    //@RequiredFieldValidator(message = "Por favor, ingrese una fecha.")
    public void setTxtProximaCita(Date txtProximaCita) {
        this.txtProximaCita = txtProximaCita;
    }

    public String getTxtReceta() {
        return txtReceta;
    }

    public void setTxtReceta(String txtReceta) {
        this.txtReceta = txtReceta;
    }

    public String getTxtSintomas() {
        return txtSintomas;
    }

    public void setTxtSintomas(String txtSintomas) {
        this.txtSintomas = txtSintomas;
    }
}

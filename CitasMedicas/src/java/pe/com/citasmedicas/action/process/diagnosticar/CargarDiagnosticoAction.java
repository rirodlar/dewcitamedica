package pe.com.citasmedicas.action.process.diagnosticar;

import com.opensymphony.xwork2.conversion.annotations.Conversion;
import com.opensymphony.xwork2.conversion.annotations.TypeConversion;
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
    @Result(name = "success", value = "/prc/diagnostico.jsp", type = ServletDispatcherResult.class)
})
@Conversion()
public class CargarDiagnosticoAction extends BaseAction {
    
    private CitaService citaService;
    private Integer txtCitaSelect;

    @Override
    public String execute() {
        try {
            Cita cita = null;

            validarAutenticacion(request);
            // Variables
            HttpSession sesion = request.getSession();

            //Obtener cita seleccionada
            cita = citaService.getCitaPorId(txtCitaSelect);

            sesion.setAttribute("cita", cita);

            return SUCCESS;
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

    public Integer getTxtCitaSelect() {
        return txtCitaSelect;
    }
    
    public void setTxtCitaSelect(Integer txtCitaSelect) {
        this.txtCitaSelect = txtCitaSelect;
    }
    
}

package pe.com.citasmedicas.action.process.diagnosticar;

import com.opensymphony.xwork2.conversion.annotations.Conversion;
import java.util.Calendar;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.struts2.config.Namespace;
import org.apache.struts2.config.ParentPackage;
import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletDispatcherResult;
import pe.com.citasmedicas.action.BaseAction;
import pe.com.citasmedicas.model.Cita;
import pe.com.citasmedicas.service.CitaService;
/**
 * Esta clase contiene los métodos utilizados por la funcionalidad Cargar Diagnóstico
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

    /**
     * Método encargado de ejecutar la acción solicitada
     * @return resultado de la accion
     */
    @Override
    public String execute() {
        try {
            Cita cita = null;
            String horaCita = new String();

            validarAutenticacion(request);
            // Variables
            HttpSession sesion = request.getSession();

            horaCita = DateFormatUtils.format(Calendar.getInstance(), "HH:mm");
            //Obtener cita seleccionada
            cita = citaService.getCitaPorId(txtCitaSelect);

            sesion.setAttribute("cita", cita);
            sesion.setAttribute("horaCita", horaCita);

            return SUCCESS;
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("errorMsg", ex.getMessage());
            return ERROR;
        }
    }

    /**
     * Obtiene el servicio que maneja las Citas
     * @return citaService servicio
     */
    public CitaService getCitaService() {
        return citaService;
    }

    /**
     * Establece el servicio que maneja las citas
     * @param citaService
     */
    public void setCitaService(CitaService citaService) {
        this.citaService = citaService;
    }

    /**
     * Obtiene la cita seleccionada
     * @return txtCitaSelect Id de la cita
     */
    public Integer getTxtCitaSelect() {
        return txtCitaSelect;
    }
    
    /**
     * Establece la cita seleccionada
     * @param txtCitaSelect Id de la cita
     */
    public void setTxtCitaSelect(Integer txtCitaSelect) {
        this.txtCitaSelect = txtCitaSelect;
    }
    
}

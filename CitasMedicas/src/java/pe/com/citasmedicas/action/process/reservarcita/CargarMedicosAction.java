package pe.com.citasmedicas.action.process.reservarcita;

import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.struts2.config.Namespace;
import org.apache.struts2.config.ParentPackage;
import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletDispatcherResult;
import pe.com.citasmedicas.action.BaseAction;
import pe.com.citasmedicas.exception.SeguridadException;
import pe.com.citasmedicas.model.Medico;
import pe.com.citasmedicas.service.MedicoService;

/**
 * Esta clase contiene los métodos utilizados por la funcionalidad Cargar Medicos en Reserva
 * @author dew - Grupo 04
 */
@Namespace(value="/reserva")
@ParentPackage(value="citaMedica")
@Results({
    @Result(name="success", value="/prc/reservar_cita.jsp", type=ServletDispatcherResult.class),
    @Result(name="input", value="/prc/reservar_cita.jsp", type=ServletDispatcherResult.class)
})
public class CargarMedicosAction extends BaseAction{

    private Integer cboEspecialidad;
    private String txtSemana;

    private MedicoService medicoService;

    /**
     * Método encargado de ejecutar la acción solicitada
     * @return resultado de la accion
     */
    @Override
    public String execute() throws Exception {
        try{
            validarAutenticacion(request);
            // Variables
            HttpSession sesion = request.getSession();
            
            List<Medico> medicos = null;

            int medicoId = 0;

            // Se recuperan todos los médicos de la especialidad seleccionada
            if (cboEspecialidad != null) {
                medicos = medicoService.getMedicosPorEspecialidad(cboEspecialidad);
                if (medicos == null) {
                    medicos = new ArrayList<Medico>();
                }
                if (medicos.size() > 0) {
                    medicoId = medicos.get(0).getPersonaId();
                }
            }
            sesion.setAttribute("especialidadId", cboEspecialidad);
            sesion.setAttribute("medicos", medicos);
            sesion.setAttribute("medicoId", medicoId);
            sesion.setAttribute("fechaSemana", txtSemana);
            return SUCCESS;
        }catch(SeguridadException se){
            return LOGIN;
        }catch(Exception ex){
            ex.printStackTrace();
            request.setAttribute("errorMsg", ex.getMessage());
            return ERROR;
        }
    }

    /**
     * Obtiene la fecha de la semana y la convierte a Date
     * @return the txtSemana
     */
    public String getTxtSemana() {
        return txtSemana;
    }

    /**
     * Establece la fecha de la semana
     * @param txtSemana the txtSemana to set
     */
    public void setTxtSemana(String txtSemana) {
        this.txtSemana = txtSemana;
    }

    /**
     * Obtiene el id de la especialidad del medico
     * @return cboEspecialidad id de especialidad
     */
    public Integer getCboEspecialidad() {
        return cboEspecialidad;
    }

    /**
     * Establece la especialidad medico
     * @param cboEspecialidad Id de la especialidad
     */
    @RequiredFieldValidator(message = "Por favor, seleccione una especialidad.")
    public void setCboEspecialidad(Integer cboEspecialidad) {
        this.cboEspecialidad = cboEspecialidad;
    }

    /**
     * Establece el servicio que maneja los medicos
     * @param medicoService servicio a establecer
     */
    public void setMedicoService(MedicoService medicoService) {
        this.medicoService = medicoService;
    }


}

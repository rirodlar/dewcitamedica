/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.citasmedicas.action;

import com.opensymphony.xwork2.ActionSupport;
import javax.servlet.http.HttpSession;
import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletActionRedirectResult;
import org.apache.struts2.dispatcher.ServletDispatcherResult;
import org.apache.struts2.dispatcher.ServletRedirectResult;
import pe.com.citasmedicas.model.Medico;
import pe.com.citasmedicas.model.Usuario;

/**
 *
 * @author dew - Grupo 04
 */
@Results({
    @Result(name="reservar", value="reserva/iniciarReserva", type=ServletActionRedirectResult.class),
    @Result(name="consultar", value="/prc/consulta.jsp", type=ServletRedirectResult.class),
    @Result(name="login", value="/login.jsp", type = ServletDispatcherResult.class)
})
public class HomeAction extends BaseAction{

    private String accion;

    @Override
    public String execute() throws Exception {
        if(accion.equals("login"))
            return "login";
        else {
            HttpSession session = request.getSession(true);
            Usuario usuario = (Usuario) session.getAttribute("usuario");
            //Validar rol
            if (usuario.getPersona() instanceof Medico){
                System.out.println("medico");
                return "consultar";
            }else{
                System.out.println("paciente");
            return "reservar";
    }
        }
    }

    /**
     * @return the accion
     */
    public String getAccion() {
        return accion;
    }

    /**
     * @param accion the accion to set
     */
    public void setAccion(String accion) {
        this.accion = accion;
    }
}

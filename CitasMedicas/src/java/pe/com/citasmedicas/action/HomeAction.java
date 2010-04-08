/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.citasmedicas.action;

import javax.servlet.http.HttpSession;
import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletActionRedirectResult;
import org.apache.struts2.dispatcher.ServletDispatcherResult;
import pe.com.citasmedicas.model.Medico;
import pe.com.citasmedicas.model.Usuario;

/**
 * Esta clase contiene los métodos utilizados la pantalla Home
 * @author dew - Grupo 04
 */
@Results({
    @Result(name = "reservar", value = "reserva/iniciarReserva", type = ServletActionRedirectResult.class),
    @Result(name = "consultar", value = "consulta/consultarCita", type = ServletActionRedirectResult.class),
    @Result(name = "login", value = "/login.jsp", type = ServletDispatcherResult.class)
})
public class HomeAction extends BaseAction {

    private String accion;

    /**
     * Método encargado de ejecutar la acción solicitada
     * @return
     * @throws Exception
     */
    @Override
    public String execute() throws Exception {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return "login";
        }
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario == null) {
            return "login";
        }
        //Validar rol
        if (usuario.getPersona() instanceof Medico) {
            System.out.println("medico");
            return "consultar";
        } else {
            System.out.println("paciente");
            return "reservar";
        }
    }

    /**
     * Obtiene la acción solicitada
     * @return the accion
     */
    public String getAccion() {
        return accion;
    }

    /**
     * Retorna la acción solicitada
     * @param accion the accion to set
     */
    public void setAccion(String accion) {
        this.accion = accion;
    }
}

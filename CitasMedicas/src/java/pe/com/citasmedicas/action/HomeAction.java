/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.citasmedicas.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletActionRedirectResult;
import org.apache.struts2.dispatcher.ServletRedirectResult;

/**
 *
 * @author dew - Grupo 04
 */
@Results({
    @Result(name="login", value="/login.jsp", type=ServletRedirectResult.class),
    @Result(name="reservar", value="reserva/iniciarReserva", type=ServletActionRedirectResult.class)
})
public class HomeAction extends ActionSupport{

    private String accion;

    @Override
    public String execute() throws Exception {
        if(accion.equals("login"))
            return "login";
        else
            return "reservar";
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

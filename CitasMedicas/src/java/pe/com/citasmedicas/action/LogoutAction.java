package pe.com.citasmedicas.action;

import org.apache.struts2.config.Result;

/**
 * Esta clase contiene los métodos utilizados la pantalla Logout
 * @author dew - Grupo 04
 */
@Result(name="success", value="/logout.jsp")
public class LogoutAction extends BaseAction {

    /**
     * Método encargado de ejecutar la acción solicitada
     * @return resultado de la accion
     * @throws Exception
     */
    @Override
    public String execute() throws Exception {
        request.getSession().invalidate();
        return SUCCESS;
    }
}

package pe.com.citasmedicas.action;

import org.apache.struts2.config.Result;

/**
 *
 * @author dew - Grupo 04
 */
@Result(name="success", value="/logout.jsp")
public class LogoutAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        request.getSession().invalidate();
        return SUCCESS;
    }
}

package pe.com.citasmedicas.action;

import com.opensymphony.xwork2.ActionSupport;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;
import pe.com.citasmedicas.filter.SeguridadUtil;
import pe.com.citasmedicas.exception.SeguridadException;

/**
 *
 * @author dew - Grupo 04
 */
public class BaseAction extends ActionSupport implements ServletRequestAware{

    protected HttpServletRequest request;

    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    protected void validarAutenticacion(HttpServletRequest request) throws SeguridadException{
        if(!SeguridadUtil.estaAutenticado(request))
            throw new SeguridadException();
    }
}

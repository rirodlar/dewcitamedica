package pe.com.citasmedicas.action;

import com.opensymphony.xwork2.ActionSupport;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;
import pe.com.citasmedicas.filter.SeguridadUtil;
import pe.com.citasmedicas.exception.SeguridadException;

/**
 * Action base del cual extienden los demás Action
 * @author dew - Grupo 04
 */
public class BaseAction extends ActionSupport implements ServletRequestAware{
    
    protected HttpServletRequest request;

    /**
     * Establece el request
     * @param request
     */
    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    /**
     * Método encargado de validar la autenticación del usuario
     * @param request
     * @throws SeguridadException
     */
    protected void validarAutenticacion(HttpServletRequest request) throws SeguridadException{
        if(!SeguridadUtil.estaAutenticado(request))
            throw new SeguridadException();
    }
}

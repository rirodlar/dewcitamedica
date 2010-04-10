package pe.com.citasmedicas.action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
     * @throws SeguridadException
     */
    protected void validarAutenticacion(HttpServletRequest request) throws SeguridadException{
        if(!SeguridadUtil.estaAutenticado(request))
            throw new SeguridadException();
    }

    /**
     * Método encargado de eliminar las variables de sesión
     * @throws SeguridadException
     */
    protected void eliminarVariablesDeSesion() throws SeguridadException{
        HttpSession sesion = this.request.getSession();
        for (Enumeration<String> e = sesion.getAttributeNames(); e.hasMoreElements();){
            String name = e.nextElement();
            System.out.println("NAME: -> " + name);
            if(!name.equals("usuario")){
                sesion.removeAttribute(name);
            }
        }
    }
}

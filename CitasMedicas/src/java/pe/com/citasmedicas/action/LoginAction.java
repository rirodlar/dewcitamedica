package pe.com.citasmedicas.action;

import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import javax.servlet.http.HttpSession;
import org.apache.struts2.config.Namespace;
import org.apache.struts2.config.ParentPackage;
import org.apache.struts2.config.Results;
import org.apache.struts2.config.Result;
import org.apache.struts2.dispatcher.ServletDispatcherResult;
import org.apache.struts2.dispatcher.ServletRedirectResult;
import pe.com.citasmedicas.model.Usuario;
import pe.com.citasmedicas.service.UsuarioService;

/**
 *
 * @author dew - Grupo 04
 */
@Namespace(value="/logeo")
@ParentPackage(value="citaMedica")
@Results({
    @Result(name = "success", value = "/home.jsp", type = ServletRedirectResult.class),
    @Result(name = "input", value = "/login.jsp", type = ServletDispatcherResult.class)
})
public class LoginAction extends BaseAction {

    private String username;
    private String password;

    private UsuarioService usuarioService;

    /**
     * Método encargado de ejecutar la acción solicitada
     * @return
     * @throws Exception
     */
    @Override
    public String execute() throws Exception {
        try {
            // Se obtiene el usuario
            Usuario usuario = usuarioService.getUsuarioPorUsername(username);
            // Se verifica que exista el usuario y que coincida el password
            if (usuario != null && usuario.getPassword().equals(password)) {
                if (request.isRequestedSessionIdValid()) {
                    HttpSession tempSession = request.getSession(false);
                    tempSession.invalidate();
                }
                HttpSession session = request.getSession(true);
                session.setAttribute("usuario", usuario);
                return SUCCESS;
            } else {
                request.setAttribute("errorMsg", "El usuario y/o la contraseña son incorrectas.");
                return INPUT;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("errorMsg", ex.getMessage());
            request.setAttribute("link", "/login.jsp");
            return ERROR;
        }
    }

    /**
     * Obtiene el nombre del usuario
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Establece el nombre del usuario ingresado validando si se ingresó nulo
     * @param username the username to set
     */
    @RequiredStringValidator(message = "Por favor, ingrese su nombre de usuario.", trim = true)
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Obtiene la clave ingresada por el usuario
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Establece la clave validando si es nula
     * @param password the password to set
     */
    @RequiredStringValidator(message = "Por favor, ingrese su contraseña.", trim = true)
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Establece el servicio que maneja los métodos concernientes a la clase Usuario
     * @param usuarioService the usuarioService to set
     */
    public void setUsuarioService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
}

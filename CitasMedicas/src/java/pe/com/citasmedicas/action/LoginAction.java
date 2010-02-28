package pe.com.citasmedicas.action;

import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validation;
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
@Namespace("/logueo")
@ParentPackage("struts-default")
@Results({
    @Result(name = "success", value = "/home.jsp", type = ServletRedirectResult.class),
    @Result(name = "input", value = "/login.jsp", type = ServletDispatcherResult.class),
    @Result(name = "error", value = "/errorPage.jsp", type = ServletDispatcherResult.class)
})
@Validation()
public class LoginAction extends BaseAction {

    private String username;
    private String password;

    @Override
    public String execute() throws Exception {
        try {
            // Se obtiene el usuario
            UsuarioService usuarioService = new UsuarioService();
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
            request.setAttribute("errorMsg", ex.getMessage());
            request.setAttribute("link", "/login.jsp");
            return ERROR;
        }
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    @RequiredStringValidator(message = "Por favor, ingrese su nombre de usuario.", trim = true)
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    @RequiredStringValidator(message = "Por favor, ingrese su contraseña.", trim = true)
    public void setPassword(String password) {
        this.password = password;
    }
}

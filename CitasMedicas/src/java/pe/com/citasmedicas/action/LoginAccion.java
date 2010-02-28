/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.citasmedicas.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.com.citasmedicas.controller.Accion;
import pe.com.citasmedicas.model.Usuario;
import pe.com.citasmedicas.service.UsuarioService;

/**
 *
 * @author rSaenz
 */
public class LoginAccion implements Accion {

    private String vista= "/loguin.jsp";

    @Override
    public boolean ejecutar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String argumento = request.getParameter("__ARGUMENT");
        if (argumento.equals("validar")) {
            // Se recuperan los parametros del jsp
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            // Se obtiene el usuario
            UsuarioService usuarioService = new UsuarioService();
            Usuario usuario = usuarioService.getUsuarioPorUsername(username);
            // Se verifica que exista el usuario y que coincida el password
            if (usuario != null && usuario.getPassword().equals(password)) {
                if (request.isRequestedSessionIdValid()) {
                    HttpSession tempSession = request.getSession(false);
                    tempSession.invalidate();
                    System.out.println("La sesión estaba activa");
                }
                HttpSession session = request.getSession(true);
                session.setAttribute("usuario", usuario);
                vista = "/home.jsp";
            } else {
                request.setAttribute("errorMsg", "El usuario y/o la contraseña son incorrectas.");
                vista = "/loguin.jsp";
            }
        } else {
            if (request.isRequestedSessionIdValid()) {
                HttpSession tempSession = request.getSession(false);
                tempSession.invalidate();
                vista = "/loguin.jsp";
            }
        }
        return true;
    }

    @Override
    public String getVista() {
        return vista;
    }
}

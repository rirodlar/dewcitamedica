package pe.com.citasmedicas.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.com.citasmedicas.model.Usuario;
import pe.com.citasmedicas.service.UsuarioService;

/**
 *
 * @author rSaenz
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
                System.out.println("la sesión estaba activa");
            }
            HttpSession session = request.getSession(true);
            session.setAttribute("usuario", usuario);
            request.getRequestDispatcher("home.jsp").forward(request, response);
        } else {
            request.setAttribute("error", "El usuario y/o la contraseña son incorrectas.");
            request.getRequestDispatcher("logeoPrueba.jsp").forward(request, response);
        }
    }
}

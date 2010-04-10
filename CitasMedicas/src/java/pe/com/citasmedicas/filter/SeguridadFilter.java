package pe.com.citasmedicas.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dew - Grupo 04
 */
public class SeguridadFilter implements Filter {

    @Override
    public void doFilter(ServletRequest _request, ServletResponse _response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) _request;
        HttpServletResponse response = (HttpServletResponse) _response;
        System.out.println("FILTER -> " + request.getRequestURI());
        String uri = request.getRequestURI();
        if (!uri.endsWith("login.jsp") && !uri.endsWith("logout.jsp") && !uri.endsWith("action") &&
                !uri.endsWith("home.jsp") && !uri.endsWith("errorPage.jsp") &&
                !uri.contains("/resources/") && !uri.endsWith("/CitasMedicas/")) {
            if (!SeguridadUtil.estaAutenticado(request)) {
                System.out.println("la sesión ha caducado");
                response.sendRedirect(request.getContextPath() + "/logeo/login.action");
                return;
            }
        }
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }
}

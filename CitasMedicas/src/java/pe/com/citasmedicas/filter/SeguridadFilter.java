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
 * Filtro que valida el ingreso a paginas restringidas por seguridad
 * @author dew - Grupo 04
 */
public class SeguridadFilter implements Filter {

    /**
     * Ejecuta el filtro
     * @param _request
     * @param _response
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest _request, ServletResponse _response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) _request;
        HttpServletResponse response = (HttpServletResponse) _response;
        String uri = request.getRequestURI();
        if(uri.endsWith(".jsp") && uri.contains("/prc/")){
            request.setAttribute("errorMsg", "La página a la que usted quiere acceder no existe.");
            response.sendRedirect(request.getContextPath() + "/errorPage.jsp?errorMsg=La página a la que usted quiere acceder no existe.");
            return;
        }
        else if (!uri.endsWith("login.jsp") && !uri.endsWith("logout.jsp") && 
                !uri.endsWith("home.jsp") && !uri.endsWith("errorPage.jsp") &&
                !uri.contains("/resources/") && !uri.endsWith("/CitasMedicas/")) {
            if (!SeguridadUtil.estaAutenticado(request)) {
                response.sendRedirect(request.getContextPath() + "/logeo/login.action");
                return;
            }
        }
        chain.doFilter(request, response);
    }

    /**
     * Metodo que se ejecuta al iniciar
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    /**
     * Metodo que se ejecuta al finalizar su ciclo de vida
     */
    @Override
    public void destroy() {
    }
}

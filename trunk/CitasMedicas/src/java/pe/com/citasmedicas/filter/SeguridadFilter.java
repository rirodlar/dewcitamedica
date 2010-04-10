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
        String uri = request.getRequestURI();
        if(uri.endsWith(".jsp") && uri.contains("/prc/")){
            System.out.println("FILTER IF -> " + request.getRequestURI());
            request.setAttribute("errorMsg", "La página a la que usted quiere acceder no existe.");
            response.sendRedirect(request.getContextPath() + "/errorPage.jsp?errorMsg=La página a la que usted quiere acceder no existe.");
            return;
        }
        else if (!uri.endsWith("login.jsp") && !uri.endsWith("logout.jsp") && 
                !uri.endsWith("home.jsp") && !uri.endsWith("errorPage.jsp") &&
                !uri.contains("/resources/") && !uri.endsWith("/CitasMedicas/")) {
            System.out.println("FILTER ELSE -> " + request.getRequestURI());
            if (!SeguridadUtil.estaAutenticado(request)) {
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

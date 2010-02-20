/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author rSaenz
 */
public class SecurityFilter implements Filter {

    /*
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    System.out.println("SecurityFilter is being initialized...");
    noFilter = config.getInitParameter("noFilter");
    context = config.getInitParameter("context");
    StringTokenizer stkn = new StringTokenizer(noFilter, ",", false);
    while (stkn.hasMoreTokens()) {
    String token = stkn.nextToken();
    noFilters.add(context + token);
    }
    }
     */
    @Override
    public void doFilter(ServletRequest _request, ServletResponse _response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) _request;
        HttpServletResponse response = (HttpServletResponse) _response;

        String uri = request.getRequestURI();
        if (!uri.endsWith("/loguin.jsp")) {
            /*for (Iterator i = noFilters.iterator(); i.hasNext();) {
                String url = (String) i.next();
                if (uri.contains(url)) {
                    System.out.printf("Security Filter: Filter configured for no security on URL = %s \n", url);
                    chain.doFilter(request, response);
                    return;
                }
            }
             */
            HttpSession session = request.getSession();
            if (session.getAttribute("usuario") == null) {
                System.out.println("la sesión ha caducado");
                response.sendRedirect(request.getContextPath() + "/loguin.jsp");
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

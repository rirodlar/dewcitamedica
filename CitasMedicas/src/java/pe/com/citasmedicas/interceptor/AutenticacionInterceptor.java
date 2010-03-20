package pe.com.citasmedicas.interceptor;

/**
 *
 * @author dew - Grupo 04
 */
public class AutenticacionInterceptor {

    public void intercept(){
        /*HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();

        HttpSession session = request.getSession();
        if (session.getAttribute("usuario") == null) {
            System.out.println("...la sesión ha caducado");
            try {
                request.getRequestDispatcher("/login.jsp").forward(request, null);
                //response.sendRedirect(response.encodeRedirectURL(destination));
            } catch (ServletException ex) {
                System.out.println(ex.getMessage());
                ex.printStackTrace();
                Logger.getLogger(AutenticacionInterceptor.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                ex.printStackTrace();
                Logger.getLogger(AutenticacionInterceptor.class.getName()).log(Level.SEVERE, null, ex);
            }
            //response.sendRedirect(response.encodeRedirectURL(destination));
        }*/
    }
}

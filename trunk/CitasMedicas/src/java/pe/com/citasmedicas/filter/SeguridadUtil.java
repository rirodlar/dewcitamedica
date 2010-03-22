/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.citasmedicas.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author rSaenz
 */
public class SeguridadUtil {

    public static boolean estaAutenticado(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("usuario") == null) {
            return false;
        }
        return true;
    }
}

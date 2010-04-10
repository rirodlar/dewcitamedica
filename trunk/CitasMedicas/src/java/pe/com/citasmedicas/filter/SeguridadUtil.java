/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.citasmedicas.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Metodos utilizados para validar seguridad
 * @author dew - Grupo 04
 */
public class SeguridadUtil {

    /**
     * Valida que el usuario sea valido para la sesion
     * @param request
     * @return condicion de aceptacion
     */
    public static boolean estaAutenticado(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("usuario") == null) {
            return false;
        }
        return true;
    }
}

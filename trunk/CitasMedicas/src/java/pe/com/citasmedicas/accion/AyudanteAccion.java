/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.citasmedicas.accion;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rSaenz
 */
public interface AyudanteAccion {

    public static String ERROR = "error";
    
    public String procesar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;
}

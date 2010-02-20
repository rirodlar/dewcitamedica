/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.citasmedicas.accion;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.com.citasmedicas.controller.Accion;

/**
 *
 * @author rSaenz
 */
public class HomeAccion implements Accion{

    private String vista;

    @Override
    public boolean ejecutar(HttpServletRequest _request, HttpServletResponse _response) throws ServletException, IOException {
        vista = "/home.jsp";
        return true;
    }

    @Override
    public String getVista() {
        return vista;
    }

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.citasmedicas.action.horario;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.com.citasmedicas.controller.Accion;

/**
 *
 * @author rSaenz
 */
public class MantenerHorarioAccion implements Accion{

    @Override
    public boolean ejecutar(HttpServletRequest _request, HttpServletResponse _response) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getVista() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}

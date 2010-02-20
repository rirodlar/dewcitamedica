/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.citasmedicas.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rSaenz
 */
public class ControlServlet extends HttpServlet {

    private static final String PAGINA_PRINCIPAL = "/home.jsp";

    // --- La vista que retornará despues de cada Accion
    private String vista = null;
    //ServletContext sc = null;

    /*public void init(ServletConfig config) throws ServletException {
        super.init(config);

        sc = config.getServletContext();    // Obtengo contexto del servlet
   }*/


    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        /*
         * Se envia el request, para crear una nueva instancia de
         * AyudanteSolicitud para que a su vez, con la fabrica, cree un nuevo
         * objeto Accion
         */
        System.out.println("control "+request.getParameter("__ARGUMENT"));
        AyudanteSolicitud objAyudanteSolicitud = new AyudanteSolicitud(request);

        /*
         * Obtenemos una instacia del objeto Accion solicitado, y lo almacenamos
         * enmascarando el tipo especifico, en un objeto de la interface Accion
         */
        Accion objAccion = objAyudanteSolicitud.getAccion();

        //Si es exitosa la ejecucion de la Accion (devuelve true)
        if (objAccion.ejecutar(request, response))
        {
            //Obtener la vista resultante
            vista = objAccion.getVista();
            //Redireccionar la vista
            //sc.getRequestDispatcher(vista).forward(request,response);
            getServletContext().getRequestDispatcher(vista).forward(request, response);
        }
        else
        {
            getServletContext().getRequestDispatcher(PAGINA_PRINCIPAL).forward(request, response);
        }

    }

}
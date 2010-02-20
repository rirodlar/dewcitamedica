package pe.com.citasmedicas.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public class AyudanteSolicitud {

    HttpServletRequest request;

    /**
     * Cada instancia del AyudanteSolicitud recibe un objeto request para que se
     * trabaje con el, obteniendo de el los parametros necesarios.
     */
    public AyudanteSolicitud(HttpServletRequest request) throws ServletException, IOException 
    {
        this.request = request;
    }
    
    /**
     * Se crea y retorna una nueva instancia de la Accion Solicitada, enviandole
     * a la Fabrica el identificador de dicha Accion
     */
    public Accion getAccion() 
    {
        String accion = request.getParameter("__ACTION");
        return FabricaAccion.crearAccion(accion);
    }
}
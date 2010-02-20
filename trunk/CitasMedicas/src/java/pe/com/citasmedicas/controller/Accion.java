package pe.com.citasmedicas.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dew - Grupo 04
 */
public interface Accion {
  
    public boolean ejecutar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;

    public String getVista();
    
}
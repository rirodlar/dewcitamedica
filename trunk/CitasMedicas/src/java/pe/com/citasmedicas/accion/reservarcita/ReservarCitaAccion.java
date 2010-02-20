/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.citasmedicas.accion.reservarcita;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.com.citasmedicas.accion.AyudanteAccion;
import pe.com.citasmedicas.controller.Accion;
import pe.com.citasmedicas.model.Cita;
import pe.com.citasmedicas.model.Persona;
import pe.com.citasmedicas.model.Usuario;
import pe.com.citasmedicas.service.CitaService;

/**
 *
 * @author rSaenz
 */
public class ReservarCitaAccion implements Accion {

    private String vista = "/prc/reservar_cita.jsp";

    @Override
    public boolean ejecutar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String argumento = request.getParameter("__ARGUMENT");
        String vistaAux = null;
        HttpSession sesion = request.getSession();
        if(argumento.equals("iniciar")){
            IniciarAyudanteAccion ayudante = new IniciarAyudanteAccion();
            vistaAux = ayudante.procesar(request, response);
            sesion.setAttribute("citasPendientes", cargarCitasPendientes(sesion));
        }
        else if(argumento.equals("cargarMedicos")){
            IniciarAyudanteAccion ayudante = new IniciarAyudanteAccion();
            vistaAux = ayudante.procesar(request, response);
        }
        else if(argumento.equals("buscarHorario")){
            IniciarAyudanteAccion ayudante = new IniciarAyudanteAccion();
            vistaAux = ayudante.procesar(request, response);
        }
        else if(argumento.equals("reservar")){
            IniciarAyudanteAccion ayudante = new IniciarAyudanteAccion();
            vistaAux = ayudante.procesar(request, response);
            sesion.setAttribute("citasPendientes", cargarCitasPendientes(sesion));
        }
        
        if(vistaAux != null && !vistaAux.equalsIgnoreCase("")){
            if(vistaAux.equals(AyudanteAccion.ERROR))
                return false;
            vista = vistaAux;
        }
        return true;
    }

    @Override
    public String getVista() {
        return vista;
    }

    private List<String> cargarCitasPendientes(HttpSession sesion) {
        CitaService citaService = new CitaService();
        List<String> citasPendientes = new ArrayList<String>();
        //
        Usuario usuario = (Usuario) sesion.getAttribute("usuario");
        Persona paciente = null;
        if (usuario != null) {
            paciente = usuario.getPersona();
        }
        if (paciente != null) {
            List<Cita> citas = citaService.getCitasPendientes(paciente);
            for (Cita cita : citas) {
                String citaPendiente = "";
                Formatter formatter = new Formatter(Locale.getDefault());
                formatter.format("%1$tA %1$td de %1$tB del %1$tY, %1$tH:%1$tM hrs.", cita.getHorario().getFechaInicio());
                citaPendiente = formatter.toString() + " : " + cita.getHorario().getEspecialidad().getNombre() + " - " + cita.getHorario().getMedico().getNombreCompleto();
                citasPendientes.add(citaPendiente);
            }
        }
        return citasPendientes;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.citasmedicas.action.reservarcita;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import pe.com.citasmedicas.action.AyudanteAccion;
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
        else if(argumento.equals("cboEspecialidad_onchange")){
            CargarMedicosAyudanteAccion ayudante = new CargarMedicosAyudanteAccion();
            vistaAux = ayudante.procesar(request, response);
        }
        else if(argumento.equals("btnVerHorario_onclick")){
            BuscarHorarioAyudanteAccion ayudante = new BuscarHorarioAyudanteAccion();
            vistaAux = ayudante.procesar(request, response);
        }
        else if(argumento.equals("btnReservar_onclick")){
            ReservarAyudanteAccion ayudante = new ReservarAyudanteAccion();
            vistaAux = ayudante.procesar(request, response);
            sesion.setAttribute("citasPendientes", cargarCitasPendientes(sesion));
        }

        if(!StringUtils.isEmpty(vistaAux)){
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
                citaPendiente = DateFormatUtils.format(cita.getHorario().getFechaInicio(), "EEEE dd 'de' MMMM 'del' yyyy, k:mm 'hrs.'")
                                + " : " + cita.getHorario().getEspecialidad().getNombre() + " - " + cita.getHorario().getMedico().getNombreCompleto();
                citasPendientes.add(citaPendiente);
            }
        }
        return citasPendientes;
    }
}

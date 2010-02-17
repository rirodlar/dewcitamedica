package pe.com.citasmedicas.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.com.citasmedicas.model.Especialidad;
import pe.com.citasmedicas.model.Medico;
import pe.com.citasmedicas.service.EspecialidadService;
import pe.com.citasmedicas.service.MedicoService;

/**
 *
 * @author rSaenz
 */
public class ReservaCitaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sesion = request.getSession();

        if (sesion.getAttribute("usuario") == null) {
            System.out.println("la sesión ha caducado");
            response.sendRedirect(request.getContextPath() + "/logeoPrueba.jsp");
            return;
        }

        String accion = "iniciar";//request.getParameter("accion");
        //
        EspecialidadService especialidadService = new EspecialidadService();
        MedicoService medicoService = new MedicoService();
        //
        List<Especialidad> especialidades = null;
        List<Medico> medicos = null;
        Integer especialidadId = null;
        Integer medicoId = null;
        //
        if (accion.equals("iniciar")) {
            System.out.println("-> Ingreso a: iniciar()");
            especialidades = especialidadService.getEspecialidades();
            if (especialidades == null) {
                especialidades = new ArrayList<Especialidad>();
            }
            if (especialidades.size() > 0) {
                especialidadId = especialidades.get(0).getEspecialidadId();
            }
            System.out.println("-> especialidades.size(): " + especialidades.size());
            medicos = medicoService.getMedicosPorEspecialidad(especialidades.get(0));
            if (medicos == null) {
                medicos = new ArrayList<Medico>();
            }
            if (medicos.size() > 0) {
                medicoId = medicos.get(0).getPersonaId();
            }
            System.out.println("-> medicos.size(): " + medicos.size());
        } else if (accion.equals("cargaMedico")) {
        } else if (accion.equals("cargaHorario")) {
        }
        request.setAttribute("especialidades", especialidades);
        request.setAttribute("especialidadId", especialidadId);
        request.setAttribute("medicos", medicos);
        request.setAttribute("medicoId", medicoId);
        request.getRequestDispatcher("reservaCita.jsp").forward(request, response);
    }
}

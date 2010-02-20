/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.citasmedicas.accion.reservarcita;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.com.citasmedicas.accion.AyudanteAccion;
import pe.com.citasmedicas.model.Especialidad;
import pe.com.citasmedicas.model.Medico;
import pe.com.citasmedicas.service.EspecialidadService;
import pe.com.citasmedicas.service.MedicoService;

/**
 *
 * @author rSaenz
 */
public class CargarMedicosAyudanteAccion implements AyudanteAccion {

    @Override
    public String procesar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            // Servicios
            EspecialidadService especialidadService = new EspecialidadService();
            MedicoService medicoService = new MedicoService();

            // Variables
            HttpSession sesion = request.getSession();
            String fechaSemana = request.getParameter("txtSemana");
            List<Especialidad> especialidades = (List<Especialidad>) sesion.getAttribute("especialidades");;
            Integer especialidadId = Integer.parseInt(request.getParameter("cboEspecialidad"));

            Especialidad especialidad = null;
            List<Medico> medicos = null;
            Integer medicoId = null;

            // Se recuperan todos los médicos de la especialidad seleccionada
            especialidad = especialidadService.getEspecialidadPorId(especialidadId);
            if (especialidad != null) {
                medicos = medicoService.getMedicosPorEspecialidad(especialidad);
                if (medicos == null) {
                    medicos = new ArrayList<Medico>();
                }
                if (medicos.size() > 0) {
                    medicoId = medicos.get(0).getPersonaId();
                }
            }
            sesion.setAttribute("especialidades", especialidades);
            sesion.setAttribute("especialidadId", especialidadId);
            sesion.setAttribute("medicos", medicos);
            sesion.setAttribute("medicoId", medicoId);
            sesion.setAttribute("fechaSemana", fechaSemana);
            return null;
        }
        catch(Exception ex){
            ex.printStackTrace();
            return AyudanteAccion.ERROR;
        }
    }

}

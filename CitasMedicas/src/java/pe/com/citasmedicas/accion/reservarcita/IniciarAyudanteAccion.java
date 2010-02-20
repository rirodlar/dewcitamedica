/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.citasmedicas.accion.reservarcita;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang.time.DateFormatUtils;
import pe.com.citasmedicas.accion.AyudanteAccion;
import pe.com.citasmedicas.model.Especialidad;
import pe.com.citasmedicas.model.Medico;
import pe.com.citasmedicas.service.EspecialidadService;
import pe.com.citasmedicas.service.MedicoService;

/**
 *
 * @author rSaenz
 */
public class IniciarAyudanteAccion implements AyudanteAccion{

    @Override
    public String procesar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            // Servicios
            EspecialidadService especialidadService = new EspecialidadService();
            MedicoService medicoService = new MedicoService();

            // Variables
            HttpSession sesion = request.getSession();
            List<String> cabeceraSemana = new ArrayList<String>();

            List<Especialidad> especialidades = null;
            Integer especialidadId = null;
            List<Medico> medicos = null;
            Integer medicoId = null;
            String errorMsg = "";
            String fechaSemana = "";

            // Se recuperan todas las especialidades
            especialidades = especialidadService.getEspecialidades();
            if (especialidades == null) {
                especialidades = new ArrayList<Especialidad>();
            }
            //
            if (especialidades.size() > 0) {
                especialidadId = especialidades.get(0).getEspecialidadId();
            }
            if (especialidadId != null) {
                // Se recuperan todos los médicos de la especialidad seleccionada
                medicos = medicoService.getMedicosPorEspecialidad(especialidades.get(0));
                if (medicos == null) {
                    medicos = new ArrayList<Medico>();
                }
                if (medicos.size() > 0) {
                    medicoId = medicos.get(0).getPersonaId();
                }
            }

            if (fechaSemana == null || fechaSemana.equalsIgnoreCase("")) {
                fechaSemana = DateFormatUtils.format(Calendar.getInstance(), "dd/MM/yyyy");
            }

            // Se inicializa la cabecera de los horarios
            cabeceraSemana.add("Lunes");
            cabeceraSemana.add("Martes");
            cabeceraSemana.add("Miércoles");
            cabeceraSemana.add("Jueves");
            cabeceraSemana.add("Viernes");
            cabeceraSemana.add("Sábado");
            cabeceraSemana.add("Domingo");
            sesion.setAttribute("cabeceraSemana", cabeceraSemana);
            sesion.setAttribute("especialidades", especialidades);
            sesion.setAttribute("especialidadId", especialidadId);
            sesion.setAttribute("medicos", medicos);
            sesion.setAttribute("medicoId", medicoId);
            sesion.setAttribute("errorMsg", errorMsg);
            sesion.setAttribute("fechaSemana", fechaSemana);
            return null;
        }catch(Exception ex){
            ex.printStackTrace();
            return AyudanteAccion.ERROR;
        }
    }

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.citasmedicas.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.com.citasmedicas.model.CargaData;
import pe.com.citasmedicas.model.Especialidad;
import pe.com.citasmedicas.model.Horario;
import pe.com.citasmedicas.model.Medico;
import pe.com.citasmedicas.service.EspecialidadService;
import pe.com.citasmedicas.service.HorarioService;
import pe.com.citasmedicas.service.MedicoService;

/**
 *
 * @author rSaenz
 */
public class PruebaServlet extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EspecialidadService especialidadService = new EspecialidadService();
        MedicoService medicoService = new MedicoService();
        HorarioService horarioService = new HorarioService();
        //
        List<Horario> horarioLunes = new ArrayList<Horario>();
        List<Horario> horarioMartes = new ArrayList<Horario>();
        List<Horario> horarioMiercoles = new ArrayList<Horario>();
        List<Horario> horarioJueves = new ArrayList<Horario>();
        List<Horario> horarioViernes = new ArrayList<Horario>();
        List<Horario> horarioSabado = new ArrayList<Horario>();
        List<Horario> horarioDomingo = new ArrayList<Horario>();
        //
        Especialidad especialidad = especialidadService.getEspecialidadPorId(new Integer(1000002));
        Medico medico = medicoService.getMedicoPorId(new Integer(1000004));

        Calendar cal = new GregorianCalendar();
        String fecha = "05/05/2010"; // obtener fecha desde el jsp
        cal.set(Calendar.YEAR, Integer.parseInt(fecha.substring(6)));
        cal.set(Calendar.MONTH, Integer.parseInt(fecha.substring(3, 5)) - 1);
        cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(fecha.substring(0, 2)));

        //Se coloca el calendario al primer día de la semana
        if (cal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
            cal.add(Calendar.DATE, -1 * (cal.get(Calendar.DAY_OF_WEEK) - 2));
        } else {
            cal.add(Calendar.DATE, -6);
        }

        horarioLunes = horarioService.getHorariosPorEspecMedicoFecha(especialidad, medico, cal.getTime());
        cal.add(Calendar.DATE, 1);
        horarioMartes = horarioService.getHorariosPorEspecMedicoFecha(especialidad, medico, cal.getTime());
        cal.add(Calendar.DATE, 1);
        horarioMiercoles = horarioService.getHorariosPorEspecMedicoFecha(especialidad, medico, cal.getTime());
        cal.add(Calendar.DATE, 1);
        horarioJueves = horarioService.getHorariosPorEspecMedicoFecha(especialidad, medico, cal.getTime());
        cal.add(Calendar.DATE, 1);
        horarioViernes = horarioService.getHorariosPorEspecMedicoFecha(especialidad, medico, cal.getTime());
        cal.add(Calendar.DATE, 1);
        horarioSabado = horarioService.getHorariosPorEspecMedicoFecha(especialidad, medico, cal.getTime());
        cal.add(Calendar.DATE, 1);
        horarioDomingo = horarioService.getHorariosPorEspecMedicoFecha(especialidad, medico, cal.getTime());

        String filtro = "Filtro: Especialidad = " + especialidad.getNombre() +
                ", Medico = " + medico.getNombreCompleto() +
                ", Semana = ";
        request.setAttribute("horarioAtencion", CargaData.HORARIO_ATENCION);
        request.setAttribute("horarioLunes", horarioLunes);
        request.setAttribute("horarioMartes", horarioMartes);
        request.setAttribute("horarioMiercoles", horarioMiercoles);
        request.setAttribute("horarioJueves", horarioJueves);
        request.setAttribute("horarioViernes", horarioViernes);
        request.setAttribute("horarioSabado", horarioSabado);
        request.setAttribute("horarioDomingo", horarioDomingo);
        request.getRequestDispatcher("reservaCitaPrueba.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}

package pe.com.citasmedicas.dao.hibernate;

import pe.com.citasmedicas.dao.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang.time.DateUtils;
import pe.com.citasmedicas.model.CargaData;
import pe.com.citasmedicas.model.Especialidad;
import pe.com.citasmedicas.model.Horario;
import pe.com.citasmedicas.model.Medico;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Query;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;

/**
 * Esta clase contiene los métodos de persistencia implementados
 * @author dew - Grupo 04
 */
@Repository
public class HorarioDaoHbn implements HorarioDao {

    /**
     * Obtiene un horario por su id
     * @param horarioId identificador del horario
     * @return Horario datos del horario
     */
    @Override
    public Horario getHorarioPorId(Integer horarioId) {
        if (horarioId == null) {
            return null;
        }
        Horario horario = null;
        Session hs = null;
        Transaction htx = null;
        SessionFactory hsf = HibernateUtil.getSessionFactory();
        try {
            hs = hsf.getCurrentSession();
            htx = hs.beginTransaction();
            horario = (Horario) hs.get(Horario.class, horarioId);
            htx.commit();
        } catch (HibernateException e) {
            if (htx != null && htx.isActive()) {
                try {
                    htx.rollback();
                } catch (HibernateException e2) {
                    System.out.println("No se pudo realizar el rollback...");
                }
            }
            e.printStackTrace();
        }
        return horario;
    }

    /**
     * Obtiene todos los horarios de un médico para una especialidad y fecha específica
     * @param especialidad datos de la especialidad
     * @param medico datos del medico
     * @param fecha Fecha del horario
     * @return List<Horario> lista de horarios encontrados
     */
    @Override
    public List<Horario> getHorariosPorEspecMedicoFecha(Especialidad especialidad, Medico medico, Date fecha) {
        if (especialidad == null || medico == null) {
            return new ArrayList<Horario>();
        }
        return getHorariosPorEspecMedicoFecha(especialidad.getEspecialidadId(), medico.getPersonaId(), fecha);
    }

    /**
     * Obtiene todos los horarios de un médico para una especialidad y fecha específica
     * @param especialidadId identificador de la especialidad
     * @param medicoId identificador del medico
     * @param fecha fecha del horario
     * @return List<Horario> lista de horarios encontrados
     */
    @Override
    public List<Horario> getHorariosPorEspecMedicoFecha(Integer especialidadId, Integer medicoId, Date fecha) {
        if (especialidadId == null || medicoId == null || fecha == null) {
            return new ArrayList<Horario>();
        }
        List<Horario> horarios = null;
        Session hs = null;
        Transaction htx = null;
        SessionFactory hsf = HibernateUtil.getSessionFactory();

        //Evalua si es parametro opcional
        String condicionEspecialidad = (especialidadId == -1) ? "" : "and h.especialidad = :especialidadId ";

        try {
            hs = hsf.getCurrentSession();
            htx = hs.beginTransaction();
            Query hqlQuery = hs.createQuery(
                    "select h from Horario h " +
                    "where h.medico = :medicoId " +
                    condicionEspecialidad +
                    "and cast(h.fechaInicio as date) = :fecha " +
                    "order by h.fechaInicio asc");
            hqlQuery.setParameter("medicoId", medicoId, Hibernate.INTEGER);
            if (especialidadId != -1) {
                hqlQuery.setParameter("especialidadId", especialidadId, Hibernate.INTEGER);
            }
            hqlQuery.setParameter("fecha", DateUtils.truncate(fecha, Calendar.DATE), Hibernate.DATE);
            horarios = hqlQuery.list();
            htx.commit();
        } catch (HibernateException e) {
            if (htx != null && htx.isActive()) {
                try {
                    htx.rollback();
                } catch (HibernateException e2) {
                    System.out.println("No se pudo realizar el rollback...");
                }
            }
            e.printStackTrace();
        }
        return horarios;
    }

    /**
     * Obtiene el horario de atencion
     * @return lista de horarios
     */
    @Override
    public List<Horario> getHorarioAtencion() {
        List<Horario> horarioAtencion = (List<Horario>) ((ArrayList<Horario>) CargaData.HORARIO_ATENCION).clone();
        return horarioAtencion;
    }

    /**
     * Elimina un horario
     * @param horario datos del horario
     * @return boolean Condicion de actualizacion -> true=exito/false=fracaso
     */
    @Override
    public boolean eliminarHorario(Horario horario) {
        if (horario == null) {
            return false;
        }
        Session hs = null;
        Transaction htx = null;
        SessionFactory hsf = HibernateUtil.getSessionFactory();
        try {
            hs = hsf.getCurrentSession();
            htx = hs.beginTransaction();
            hs.delete(horario);
            htx.commit();
        } catch (HibernateException e) {
            if (htx != null && htx.isActive()) {
                try {
                    htx.rollback();
                } catch (HibernateException e2) {
                    System.out.println("No se pudo realizar el rollback...");
                }
            }
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Actualiza un horario
     * @param horario datos del horario
     * @return boolean Condicion de actualizacion -> true=exito/false=fracaso
     */
    @Override
    public boolean actualizarHorario(Horario horario) {
        if (horario == null) {
            return false;
        }
        Session hs = null;
        Transaction htx = null;
        SessionFactory hsf = HibernateUtil.getSessionFactory();
        try {
            hs = hsf.getCurrentSession();
            htx = hs.beginTransaction();
            hs.update(horario);
            htx.commit();
        } catch (HibernateException e) {
            if (htx != null && htx.isActive()) {
                try {
                    htx.rollback();
                } catch (HibernateException e2) {
                    System.out.println("No se pudo realizar el rollback...");
                }
            }
            e.printStackTrace();
            return false;
        }
        return true;
    }
}

package pe.com.citasmedicas.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import pe.com.citasmedicas.model.CargaData;
import pe.com.citasmedicas.model.Especialidad;
import pe.com.citasmedicas.model.Horario;
import pe.com.citasmedicas.model.Medico;
import pe.com.citasmedicas.persistence.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Query;
import org.hibernate.Hibernate;

/**
 *
 * @author dew - Grupo 04
 */
public class HorarioDao {

    /**
     * Obtiene un horario por su id
     * @param Integer horarioId
     * @return Horario
     */
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
     * @param Especialidad especialidad
     * @param Medico medico
     * @param Date fecha
     * @return List<Horario>
     */
    public List<Horario> getHorariosPorEspecMedicoFecha(Especialidad especialidad, Medico medico, Date fecha) {
        if (especialidad == null || medico == null) {
            return new ArrayList<Horario>();
        }
        return getHorariosPorEspecMedicoFecha(especialidad.getEspecialidadId(), medico.getPersonaId(), fecha);
    }

    /**
     * Obtiene todos los horarios de un médico para una especialidad y fecha específica
     * @param Integer especialidadId
     * @param Integer medicoId
     * @param Date fecha
     * @return List<Horario>
     */
    public List<Horario> getHorariosPorEspecMedicoFecha(Integer especialidadId, Integer medicoId, Date fecha) {
        if (especialidadId == null || medicoId == null || fecha == null) {
            return new ArrayList<Horario>();
        }
        List<Horario> horarios = null;
        Session hs = null;
        Transaction htx = null;
        SessionFactory hsf = HibernateUtil.getSessionFactory();
        try {
            hs = hsf.getCurrentSession();
            htx = hs.beginTransaction();
            Query hqlQuery = hs.createQuery(
                    "select h from Horario h " +
                    "where h.medico = :medicoId " +
                    "and h.especialidad = :especialidadId " +
                    "and cast(h.fechaInicio as date) = :fecha " +
                    "order by h.fechaInicio asc");
            hqlQuery.setParameter("medicoId", medicoId, Hibernate.INTEGER);
            hqlQuery.setParameter("especialidadId", especialidadId, Hibernate.INTEGER);
            hqlQuery.setParameter("fecha", fecha, Hibernate.DATE);
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

    public List<Horario> getHorarioAtencion() {
        List<Horario> horarioAtencion = (List<Horario>) ((ArrayList<Horario>) CargaData.HORARIO_ATENCION).clone();
        return horarioAtencion;
    }

    /**
     * Elimina un horario
     * @param Horario horario
     * @return boolean
     */
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
     * @param Horario horario
     * @return boolean
     */
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

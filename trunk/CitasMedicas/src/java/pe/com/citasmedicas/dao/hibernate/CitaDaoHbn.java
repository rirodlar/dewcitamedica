package pe.com.citasmedicas.dao.hibernate;

import pe.com.citasmedicas.dao.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang.time.DateUtils;
import pe.com.citasmedicas.model.Cita;
import pe.com.citasmedicas.model.Especialidad;
import pe.com.citasmedicas.model.Horario;
import pe.com.citasmedicas.model.Medico;
import pe.com.citasmedicas.model.Paciente;
import pe.com.citasmedicas.model.Persona;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;

/**
 * Esta clase contiene los métodos de persistencia implementados
 * @author dew - Grupo 04
 */
@Repository
public class CitaDaoHbn implements CitaDao {

    /**
     * Obtiene una cita por su id
     * @param citaId Id de la cita a buscar
     * @return Cita obtenida por el id
     */
    @Override
    public Cita getCitaPorId(Integer citaId) {
        if (citaId == null) {
            return null;
        }
        Cita cita = null;
        Session hs = null;
        Transaction htx = null;
        SessionFactory hsf = HibernateUtil.getSessionFactory();
        try{
            hs = hsf.getCurrentSession();
            htx = hs.beginTransaction();
            cita = (Cita)hs.get(Cita.class, citaId);
            htx.commit();
        }
        catch(HibernateException he){
            if(htx != null && htx.isActive()){
                try{
                    htx.rollback();
                }
                catch(HibernateException he2){
                    System.out.println("No se pudo realizar rollback...");
                }
            }
            he.printStackTrace();
        }
        return cita;
    }

    /**
     * Obtiene todos las citas de un médico para una fecha específica
     * @param medico datos del medico
     * @param fecha Fecha de la cita a buscar
     * @param validaHora condicion de validacion de fecha por fragmento hora
     * @return List<Cita> lista de citas obtenidas
     */
    @Override
    public List<Cita> getCitasPorMedicoFecha(Medico medico, Date fecha, boolean validaHora) {
        if(medico == null){
            return new ArrayList<Cita>();
        }
        return getCitasPorMedicoFecha(medico.getPersonaId(), fecha, validaHora);
    }

    /**
     * Obtiene todos las citas de un médico para una fecha específica
     * @param medicoId Identificador del medico
     * @param validaHora condicion de validacion de fecha por fragmento hora
     * @param fecha Fecha de la cita a buscar
     * @return List<Cita> lista de citas obtenidas
     */
    @Override
    public List<Cita> getCitasPorMedicoFecha(Integer medicoId, Date fecha, boolean validaHora) {
        if (medicoId == null || fecha == null) {
            return new ArrayList<Cita>();
        }
        List<Cita> citas = new ArrayList<Cita>();
                Session hs = null;
        Transaction htx = null;
        SessionFactory hsf = HibernateUtil.getSessionFactory();
        try {
            hs = hsf.getCurrentSession();
            htx = hs.beginTransaction();
            String query = "from Cita c where c.horario.medico = :medicoId ";
            if(validaHora){
                query += "and cast(c.horario.fechaInicio as timestamp) = :fecha";
            }
            else{
                query += "and cast(c.horario.fechaInicio as date) = :fecha";
            }
            Query hqlQuery = hs.createQuery(query);
            hqlQuery.setParameter("medicoId", medicoId, Hibernate.INTEGER);
            if(validaHora){
                hqlQuery.setParameter("fecha", fecha, Hibernate.TIMESTAMP);
            }
            else{
                hqlQuery.setParameter("fecha", DateUtils.truncate(fecha, Calendar.DATE), Hibernate.DATE);
            }
            citas = hqlQuery.list();
            htx.commit();
        } catch (HibernateException e) {
            if(htx != null && htx.isActive()){
                try {
                    htx.rollback();
                } catch (HibernateException e2) {
                    System.out.println("No se pudo realizar el rollback...");
                }
            }
            e.printStackTrace();
        }
        return citas;
    }

    /**
     * Obtiene todos las citas de un paciente para una fecha específica
     * @param paciente datos del paciente
     * @param fecha Fecha de la cita a buscar
     * @param validaHora condicion de validacion de fecha por fragmento hora
     * @return List<Cita> lista de citas obtenidas
     */
    @Override
    public List<Cita> getCitasPorPacienteFecha(Paciente paciente, Date fecha, boolean validaHora) {
        if(paciente == null){
            return new ArrayList<Cita>();
        }
        return getCitasPorPacienteFecha(paciente.getPersonaId(), fecha, validaHora);
    }

    /**
     * Obtiene todos las citas de un paciente para una fecha específica
     * @param pacienteId Identificador del paciente
     * @param fecha Fecha de la cita a buscar
     * @param validaHora condicion de validacion de fecha por fragmento hora
     * @return List<Cita> lista de citas obtenidas
     */
    @Override
    public List<Cita> getCitasPorPacienteFecha(Integer pacienteId, Date fecha, boolean validaHora) {
        if (pacienteId == null || fecha == null) {
            return new ArrayList<Cita>();
        }
        List<Cita> citas = new ArrayList<Cita>();
        Session hs = null;
        Transaction htx = null;
        SessionFactory hsf = HibernateUtil.getSessionFactory();
        try {
            hs = hsf.getCurrentSession();
            htx = hs.beginTransaction();
            String query = "from Cita c where c.paciente = :pacienteId ";
            if(validaHora){
                query += "and cast(c.horario.fechaInicio as timestamp) = :fecha";
            }
            else{
                query += "and cast(c.horario.fechaInicio as date) = :fecha";
            }
            Query hqlQuery = hs.createQuery(query);
            hqlQuery.setParameter("pacienteId", pacienteId, Hibernate.INTEGER);
            if(validaHora){
                hqlQuery.setParameter("fecha", fecha, Hibernate.TIMESTAMP);
            }
            else{
                hqlQuery.setParameter("fecha", DateUtils.truncate(fecha, Calendar.DATE), Hibernate.DATE);
            }
            citas = hqlQuery.list();
            htx.commit();
        } catch (HibernateException e) {
            if(htx != null && htx.isActive()){
                try {
                    htx.rollback();
                } catch (HibernateException e2) {
                    System.out.println("No se pudo realizar el rollback...");
                }
            }
            e.printStackTrace();
        }
        return citas;
    }

    /**
     * Obtiene todos las citas pendientes de un paciente
     * @param paciente datos del paciente
     * @return List<Cita> lista de citas pendientes
     */
    @Override
    public List<Cita> getCitasPendientes(Persona paciente) {
        if (paciente == null) {
            return new ArrayList<Cita>();
        }
        return getCitasPendientes(paciente.getPersonaId());
    }

    /**
     * Obtiene todos las citas pendientes de un paciente
     * @param pacienteId identificador del paciente
     * @return List<Cita> lista de citas pendientes
     */
    @Override
    public List<Cita> getCitasPendientes(Integer pacienteId) {
        if (pacienteId == null) {
            return new ArrayList<Cita>();
        }
        List<Cita> citas = new ArrayList<Cita>();
        Session hs = null;
        Transaction htx = null;
        SessionFactory hsf = HibernateUtil.getSessionFactory();
        try {
            hs = hsf.getCurrentSession();
            htx = hs.beginTransaction();
            Query hqlQuery = hs.createQuery("from Cita c " +
                    "where c.paciente = :pacienteId " +
                    "and c.horario.fechaInicio > current_timestamp() " +
                    "order by c.horario.fechaInicio");
            hqlQuery.setParameter("pacienteId", pacienteId, Hibernate.INTEGER);
            citas = hqlQuery.list();
            htx.commit();
        } catch (HibernateException e) {
            if(htx != null && htx.isActive()){
                try {
                    htx.rollback();
                } catch (HibernateException e2) {
                    System.out.println("No se pudo realizar el rollback...");
                }
            }
            e.printStackTrace();
        }
        return citas;
    }

    /**
     * Obtiene la cita pendiente de un paciente para una semana, medico y especialidad
     * @param paciente datos del paciente
     * @param fechaInicio fecha de inicio de la cita
     * @param fechaFin fecha de fin de la cita
     * @param especialidad datos de la especialidad medica
     * @param medico datos del medico
     * @return Cita en la semana
     */
    @Override
    public Cita getCitaSemPendiente(Paciente paciente, Date fechaInicio, Date fechaFin, Medico medico, Especialidad especialidad) {
        if(paciente == null || medico == null || especialidad == null){
            return null;
        }
        return getCitaSemPendiente(paciente.getPersonaId(), fechaInicio, fechaFin, medico.getPersonaId(), especialidad.getEspecialidadId());
    }
    
    /**
     * Obtiene la cita pendiente de un paciente para una semana, medico y especialidad
     * @param pacienteId Id del paciente
     * @param fechaInicio fecha de inicio de la cita
     * @param fechaFin fecha de fin de la cita
     * @param medicoId Identificador del medico
     * @param especialidadId Identificador de la especialidad
     * @return Cita en la semana
     */
    @Override
    public Cita getCitaSemPendiente(Integer pacienteId, Date fechaInicio, Date fechaFin, Integer medicoId, Integer especialidadId) {
        if (pacienteId == null || fechaInicio == null || fechaFin == null || medicoId == null || especialidadId == null) {
            return null;
        }
        Cita cita = null;
        Session hs = null;
        Transaction htx = null;
        SessionFactory hsf = HibernateUtil.getSessionFactory();
        try {
            hs = hsf.getCurrentSession();
            htx = hs.beginTransaction();
            Query hqlQuery = hs.createQuery("from Cita c " +
                    "where c.paciente = :pacienteId " +
                    "and c.horario.medico = :medicoId " +
                    "and c.horario.especialidad = :especialidadId " +
                    "and c.horario.fechaInicio >= :fechaInicio " +
                    "and c.horario.fechaInicio <= :fechaFin " +
                    "and c.estado = :estado " +
                    "order by c.horario.fechaInicio asc");
            hqlQuery.setParameter("pacienteId", pacienteId, Hibernate.INTEGER);
            hqlQuery.setParameter("medicoId", medicoId, Hibernate.INTEGER);
            hqlQuery.setParameter("especialidadId", especialidadId, Hibernate.INTEGER);
            hqlQuery.setParameter("fechaInicio", fechaInicio, Hibernate.DATE);
            hqlQuery.setParameter("fechaFin", fechaFin, Hibernate.DATE);
            hqlQuery.setParameter("estado", Cita.ESTADO_PENDIENTE, Hibernate.STRING);
            cita = (Cita)hqlQuery.uniqueResult();
            htx.commit();
        } catch (HibernateException e) {
            if(htx != null && htx.isActive()){
                try {
                    htx.rollback();
                } catch (HibernateException e2) {
                    System.out.println("No se pudo realizar el rollback...");
                }
            }
            e.printStackTrace();
        }
        return cita;
    }

    /**
     * Obtiene la cita de un horario específico
     * @param horario Horario a buscar
     * @return Cita correspndiente al horario
     */
    @Override
    public Cita getCitaPorHorario(Horario horario) {
        if(horario == null){
            return null;
        }
        return getCitaPorHorario(horario.getHorarioId());
    }

    /**
     * Obtiene la cita de un horario específico
     * @param horarioId Id del horario a buscar
     * @return Cita correspondiente al horario
     */
    @Override
    public Cita getCitaPorHorario(Integer horarioId) {
        if (horarioId == null) {
            return null;
        }
        Cita cita = null;
        Session hs = null;
        Transaction htx = null;
        SessionFactory hsf = HibernateUtil.getSessionFactory();
        try {
            hs = hsf.getCurrentSession();
            htx = hs.beginTransaction();
            Query hqlQuery = hs.createQuery("from Cita c where c.horario = :horarioId");
            hqlQuery.setParameter("horarioId", horarioId, Hibernate.INTEGER);
            cita = (Cita)hqlQuery.uniqueResult();
            htx.commit();
        } catch (HibernateException e) {
            if(htx != null && htx.isActive()){
                try {
                    htx.rollback();
                } catch (HibernateException e2) {
                    System.out.println("No se pudo realizar el rollback...");
                }
            }
            e.printStackTrace();
        }
        return cita;
    }

    /**
     * Ingresa una cita
     * @param paciente datos del paciente
     * @param horario datos del horario
     * @return boolean Condicion de actualizacion -> true=exito/false=fracaso
     */
    @Override
    public boolean insertarCita(Paciente paciente, Horario horario) {
        if(paciente == null || horario == null){
            return false;
        }
        Cita cita = new Cita();
        cita.setPaciente(paciente);
        cita.setHorario(horario);
        cita.setEstado(Cita.ESTADO_PENDIENTE);

        Session hs = null;
        Transaction htx = null;
        SessionFactory hsf = HibernateUtil.getSessionFactory();
        try {
            hs = hsf.openSession();
            htx = hs.beginTransaction();
            Integer citaId = (Integer)hs.save(cita);
            cita.setCitaId(citaId);
            horario.setCita(cita);
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
        }finally{
            hs.close();
        }
        return true;
    }

    /**
     * Elimina una cita
     * @param cita Cita a eliminar
     * @return boolean Condicion de actualizacion -> true=exito/false=fracaso
     */
    @Override
    public boolean eliminarCita(Cita cita) {
        if (cita == null) {
            return false;
        }
        Session hs = null;
        Transaction htx = null;
        SessionFactory hsf = HibernateUtil.getSessionFactory();
        try {
            hs = hsf.openSession();
            htx = hs.beginTransaction();
            Horario horario = cita.getHorario();
            horario.setCita(null);
            hs.update(horario);
            hs.delete(cita);
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
        }finally{
            hs.close();
        }
        return true;
    }

    /**
     * Actualiza una cita
     * @param cita Cita a actualizar
     * @return boolean Condicion de actualizacion -> true=exito/false=fracaso
     */
    @Override
    public boolean actualizarCita(Cita cita) {
        if (cita == null) {
            return false;
        }
        Session hs = null;
        Transaction htx = null;
        SessionFactory hsf = HibernateUtil.getSessionFactory();
        try {
            hs = hsf.getCurrentSession();
            htx = hs.beginTransaction();
            hs.update(cita);
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

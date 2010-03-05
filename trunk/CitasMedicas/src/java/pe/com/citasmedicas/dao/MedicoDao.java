package pe.com.citasmedicas.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pe.com.citasmedicas.model.Especialidad;
import pe.com.citasmedicas.model.Medico;
import pe.com.citasmedicas.persistence.HibernateUtil;

/**
 *
 * @author dew - Grupo 04
 */
public class MedicoDao {

    /**
     * Obtiene un médico por su id
     * @param Integer medicoId
     * @return Medico
     */
    public Medico getMedicoPorId(Integer medicoId) {
        if (medicoId == null) {
            return null;
        }
        Medico medico = null;
        Session hs = null;
        Transaction htx = null;
        SessionFactory hsf = HibernateUtil.getSessionFactory();
        try {
            hs = hsf.getCurrentSession();
            htx = hs.beginTransaction();
            medico = (Medico)hs.get(Medico.class, medicoId);
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
        return medico;
    }

    /**
     * Obtiene todas los médicos de una especialidad específica
     * @param Especialidad especialidad
     * @return List<Medico>
     */
    public List<Medico> getMedicosPorEspecialidad(Especialidad especialidad) {
        if(especialidad == null){
            return new ArrayList<Medico>();
        }
        return getMedicosPorEspecialidad(especialidad.getEspecialidadId());
    }

    /**
     * Obtiene todas los médicos de una especialidad específica
     * @param Integer especialidadId
     * @return List<Medico>
     */
    public List<Medico> getMedicosPorEspecialidad(Integer especialidadId) {
        if (especialidadId == null) {
            return null;
        }
        List<Medico> medicos = null;
        Session hs = null;
        Transaction htx = null;
        SessionFactory hsf = HibernateUtil.getSessionFactory();
        try {
            hs = hsf.getCurrentSession();
            htx = hs.beginTransaction();
            Query hqlQuery = hs.createQuery("select m from Medico m join m.especialidades e " +
                                            "where e = :especialidadId order by m.apellidoPaterno");
            hqlQuery.setParameter("especialidadId", especialidadId, Hibernate.INTEGER);
            medicos = hqlQuery.list();
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
        return medicos;
    }
}

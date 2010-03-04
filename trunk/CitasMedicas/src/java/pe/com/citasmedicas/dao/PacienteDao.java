package pe.com.citasmedicas.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pe.com.citasmedicas.model.Paciente;
import pe.com.citasmedicas.persistence.HibernateUtil;

/**
 *
 * @author dew - Grupo 04
 */
public class PacienteDao {

     /**
     * Obtiene un Paciente por su Id
     * @param Integer pacienteId
     * @return Paciente
     */
    public Paciente getPacientePorId(Integer pacienteId) {
        if (pacienteId == null) {
            return null;
        }
        Paciente paciente = null;
        SessionFactory hsf = HibernateUtil.getSessionFactory();
        Session hs = hsf.getCurrentSession();
        Transaction htx = null;
        try {
            htx = hs.beginTransaction();
            paciente = (Paciente)hs.get(Paciente.class, pacienteId);
            htx.commit();
        } catch (HibernateException e) {
            if(htx != null){
                try {
                    htx.rollback();
                } catch (HibernateException e2) {
                    System.out.println("No se pudo realizar el rollback...");
                }
            }
            e.printStackTrace();
        }
        return paciente;
    }
}

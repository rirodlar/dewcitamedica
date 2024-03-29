package pe.com.citasmedicas.dao.hibernate;

import pe.com.citasmedicas.dao.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import pe.com.citasmedicas.model.Paciente;

/**
 * Esta clase contiene los métodos de persistencia implementados
 * @author dew - Grupo 04
 */
@Repository
public class PacienteDaoHbn implements PacienteDao {

    /**
     * Obtiene un Paciente por su Id
     * @param pacienteId identificador del paciente
     * @return Paciente datos del paciente
     */
    @Override
    public Paciente getPacientePorId(Integer pacienteId) {
        if (pacienteId == null) {
            return null;
        }
        Paciente paciente = null;
        Session hs = null;
        Transaction htx = null;
        SessionFactory hsf = HibernateUtil.getSessionFactory();
        try {
            hs = hsf.getCurrentSession();
            htx = hs.beginTransaction();
            paciente = (Paciente)hs.get(Paciente.class, pacienteId);
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
        return paciente;
    }
}

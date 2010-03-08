package pe.com.citasmedicas.dao.hibernate;

import pe.com.citasmedicas.dao.*;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import pe.com.citasmedicas.model.Usuario;

/**
 *
 * @author dew - Grupo 04
 */
@Repository
public class UsuarioDaoHbn implements UsuarioDao {

    /**
     * Obtiene un usuario por su username
     * @param String username
     * @return Usuario
     */
    public Usuario getUsuarioPorUsername(String username) {
        if (username == null) {
            return null;
        }
        Usuario usuario = null;
        Session hs = null;
        Transaction htx = null;
        SessionFactory hsf = HibernateUtil.getSessionFactory();
        try {
            hs = hsf.getCurrentSession();
            htx = hs.beginTransaction();
            Query hqlQuery = hs.createQuery("from Usuario u where u.username = :username");
            hqlQuery.setParameter("username", username, Hibernate.STRING);
            usuario = (Usuario)hqlQuery.uniqueResult();
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
        return usuario;
    }
}

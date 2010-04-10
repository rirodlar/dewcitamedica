package pe.com.citasmedicas.dao.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * Esta clase contiene los métodos de persistencia implementados
 * @author dew - Grupo 04
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory;

    static{
        try{
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        }catch(Throwable ex){
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * 
     * @return
     */
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    /**
     *
     */
    public static void shutdown(){
        getSessionFactory().close();
    }
}

package pe.com.citasmedicas.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import pe.com.citasmedicas.model.CargaData;

/**
 *
 * @author dew - Grupo 04
 */
public class ContextListener implements ServletContextListener{

    public void contextInitialized(ServletContextEvent sce) {
        try{
            CargaData.inicializar();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public void contextDestroyed(ServletContextEvent sce) {}

}

package pe.com.citasmedicas.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import pe.com.citasmedicas.model.CargaData;

/**
 * Clase que carga data inicial
 * @author dew - Grupo 04
 */
public class ContextListener implements ServletContextListener{

    /**
     * Al iniciar carga los horarios de atencion de la clinica
     * @param sce
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try{
            CargaData.inicializar();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }

    /**
     *
     * @param sce
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {}

}

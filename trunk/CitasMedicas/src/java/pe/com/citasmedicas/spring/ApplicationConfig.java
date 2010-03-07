package pe.com.citasmedicas.spring;

//import org.springframework.beans.factory.annotation.Autowire;
//import org.springframework.config.java.annotation.Bean;
//import org.springframework.config.java.annotation.Configuration;
//import org.springframework.config.java.support.ConfigurationSupport;
import pe.com.citasmedicas.dao.CitaDao;
import pe.com.citasmedicas.dao.EspecialidadDao;
import pe.com.citasmedicas.dao.HorarioDao;
import pe.com.citasmedicas.dao.MedicoDao;
import pe.com.citasmedicas.dao.PacienteDao;
import pe.com.citasmedicas.dao.UsuarioDao;
import pe.com.citasmedicas.dao.hibernate.CitaDaoHbn;
import pe.com.citasmedicas.dao.hibernate.EspecialidadDaoHbn;
import pe.com.citasmedicas.dao.hibernate.HorarioDaoHbn;
import pe.com.citasmedicas.dao.hibernate.MedicoDaoHbn;
import pe.com.citasmedicas.dao.hibernate.PacienteDaoHbn;
import pe.com.citasmedicas.dao.hibernate.UsuarioDaoHbn;
import pe.com.citasmedicas.service.CitaService;
import pe.com.citasmedicas.service.EspecialidadService;
import pe.com.citasmedicas.service.HorarioService;
import pe.com.citasmedicas.service.MedicoService;
import pe.com.citasmedicas.service.PacienteService;
import pe.com.citasmedicas.service.UsuarioService;
import pe.com.citasmedicas.service.implement.CitaServiceImpl;
import pe.com.citasmedicas.service.implement.EspecialidadServiceImpl;
import pe.com.citasmedicas.service.implement.HorarioServiceImpl;
import pe.com.citasmedicas.service.implement.MedicoServiceImpl;
import pe.com.citasmedicas.service.implement.PacienteServiceImpl;
import pe.com.citasmedicas.service.implement.UsuarioServiceImpl;

/**
 *
 * @author rSaenz
 */
//@Configuration
public abstract class ApplicationConfig {

    //@Bean
    public CitaService citaService() {
        return new CitaServiceImpl();
    }

    //@Bean
    public EspecialidadService especialidadService() {
        return new EspecialidadServiceImpl();
    }

    //@Bean
    public HorarioService horarioService() {
        return new HorarioServiceImpl();
    }

    //@Bean
    public MedicoService medicoService() {
        return new MedicoServiceImpl();
    }

    //@Bean
    public PacienteService pacienteService() {
        return new PacienteServiceImpl();
    }

    //@Bean
    public UsuarioService usuarioService() {
        return new UsuarioServiceImpl();
    }

    //@Bean
    public CitaDao citaDao() {
        return new CitaDaoHbn();
    }

    //@Bean
    public EspecialidadDao especialidadDao() {
        return new EspecialidadDaoHbn();
    }

    //@Bean
    public HorarioDao horarioDao() {
        return new HorarioDaoHbn();
    }

    //@Bean
    public MedicoDao medicoDao() {
        return new MedicoDaoHbn();
    }

    //@Bean
    public PacienteDao pacienteDao() {
        return new PacienteDaoHbn();
    }

    //@Bean
    public UsuarioDao usuarioDao() {
        return new UsuarioDaoHbn();
    }
}

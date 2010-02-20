package pe.com.citasmedicas.model;

import java.util.List;

/**
 *
 * @author dew - Grupo 04
 */
public class Medico extends Persona{

    private String nroColegiatura;
    private List<Especialidad> especialidades;

    /**
     * @return the nroColegiatura
     */
    public String getNroColegiatura() {
        return nroColegiatura;
    }

    /**
     * @param nroColegiatura the nroColegiatura to set
     */
    public void setNroColegiatura(String nroColegiatura) {
        this.nroColegiatura = nroColegiatura;
    }

    /**
     * @return the especialidades
     */
    public List<Especialidad> getEspecialidades() {
        return especialidades;
    }

    /**
     * @param especialidades the especialidades to set
     */
    public void setEspecialidades(List<Especialidad> especialidades) {
        this.especialidades = especialidades;
    }
}


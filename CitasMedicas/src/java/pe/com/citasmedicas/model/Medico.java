package pe.com.citasmedicas.model;

import java.util.List;

/**
 *
 * @author dew - Grupo 04
 */
public class Medico extends Usuario {

    private Integer medicoId;
    private String nroColegiatura;
    private List<Especialidad> especialidades;

    /**
     * @return the medicoId
     */
    public Integer getMedicoId() {
        return medicoId;
    }

    /**
     * @param medicoId the medicoId to set
     */
    public void setMedicoId(Integer medicoId) {
        this.medicoId = medicoId;
    }

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


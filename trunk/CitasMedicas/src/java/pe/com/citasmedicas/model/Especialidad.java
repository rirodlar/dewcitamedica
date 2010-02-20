package pe.com.citasmedicas.model;

import java.util.List;

/**
 *
 * @author dew - Grupo 04
 */
public class Especialidad extends Bean {

    private Integer especialidadId;
    private String nombre;
    private List<Medico> medicos;

    /**
     * @return the especialidadId
     */
    public Integer getEspecialidadId() {
        return especialidadId;
    }

    /**
     * @param especialidadId the especialidadId to set
     */
    public void setEspecialidadId(Integer especialidadId) {
        this.especialidadId = especialidadId;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the medicos
     */
    public List<Medico> getMedicos() {
        return medicos;
    }

    /**
     * @param medicos the medicos to set
     */
    public void setMedicos(List<Medico> medicos) {
        this.medicos = medicos;
    }
}


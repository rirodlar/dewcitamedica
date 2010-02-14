package pe.com.citasmedicas.model;

import java.util.Date;

/**
 *
 * @author dew - Grupo 04
 */
public class Paciente extends Usuario{

    private Integer pacienteId;
    private Double peso;
    private Double estatura;

    /**
     * @return the pacienteId
     */
    public Integer getPacienteId() {
        return pacienteId;
    }

    /**
     * @param pacienteId the pacienteId to set
     */
    public void setPacienteId(Integer pacienteId) {
        this.pacienteId = pacienteId;
    }

    /**
     * @return the peso
     */
    public Double getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(Double peso) {
        this.peso = peso;
    }

    /**
     * @return the estatura
     */
    public Double getEstatura() {
        return estatura;
    }

    /**
     * @param estatura the estatura to set
     */
    public void setEstatura(Double estatura) {
        this.estatura = estatura;
    }
}


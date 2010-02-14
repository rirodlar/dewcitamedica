package pe.com.citasmedicas.model;

/**
 *
 * @author dew - Grupo 04
 */
public class Paciente extends Persona{

    private Double peso;
    private Integer estatura;

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
    public Integer getEstatura() {
        return estatura;
    }

    /**
     * @param estatura the estatura to set
     */
    public void setEstatura(Integer estatura) {
        this.estatura = estatura;
    }
}


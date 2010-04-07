package pe.com.citasmedicas.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author dew - Grupo 04
 */
@Entity
@DiscriminatorValue(value="P")
public class Paciente extends Persona{

    @Column(name="peso", nullable=false)
    private Double peso;

    @Column(name="estatura", nullable=false)
    private Integer estatura;

    @Column(name="rutaFoto", nullable=true, length=25)
    private String rutaFoto;

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

    /**
     * @return the rutaFoto
     */
    public String getRutaFoto() {
        return rutaFoto;
    }

    /**
     * @param rutaFoto the rutaFoto to set
     */
    public void setRutaFoto(String rutaFoto) {
        this.rutaFoto = rutaFoto;
    }
}


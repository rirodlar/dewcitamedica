package pe.com.citasmedicas.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

/**
 * Hace referencia a un medico que brinda atencion en la clinica
 * @author dew - Grupo 04
 */
@Entity
@DiscriminatorValue(value="M")
public class Medico extends Persona{

    @Column(name="nroColegiatura", nullable=false, length=5)
    private String nroColegiatura;

    @ManyToMany(mappedBy="medicos")
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


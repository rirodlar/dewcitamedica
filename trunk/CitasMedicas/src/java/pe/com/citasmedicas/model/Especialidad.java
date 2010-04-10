package pe.com.citasmedicas.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Hace referencia a una especialidad perteneciente a un medico
 * @author dew - Grupo 04
 */
@Entity
@Table(name="especialidad", schema="cita_medica")
public class Especialidad extends Bean {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="especialidadId", nullable=false)
    private Integer especialidadId;
    
    @Column(name="nombre", nullable=false, length=25)
    private String nombre;

    @ManyToMany(targetEntity=pe.com.citasmedicas.model.Medico.class)
    @JoinTable(name="medico_especialidad",
        joinColumns=
            @JoinColumn(name="especialidadId", referencedColumnName="especialidadId"),
        inverseJoinColumns=
            @JoinColumn(name="medicoId", referencedColumnName="personaId")
    )
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


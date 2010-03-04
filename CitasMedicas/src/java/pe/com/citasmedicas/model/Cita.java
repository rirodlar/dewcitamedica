package pe.com.citasmedicas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author dew - Grupo 04
 */
@Entity
@Table(name="cita", schema="cita_medica")
public class Cita extends Bean{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="citaId", nullable=false)
    private Integer citaId;

    @Column(name="estado")
    private String estado;

    @Column(name="diagnostico")
    private String diagnostico;

    @ManyToOne
    @JoinColumn(name="pacienteId")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name="medicoId")
    private Medico medico;

    @OneToOne(targetEntity=pe.com.citasmedicas.model.Horario.class, optional=false)
    @JoinColumn(name="horarioId")
    private Horario horario;

    /**
     * @return the citaId
     */
    public Integer getCitaId() {
        return citaId;
    }

    /**
     * @param citaId the citaId to set
     */
    public void setCitaId(Integer citaId) {
        this.citaId = citaId;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the diagnostico
     */
    public String getDiagnostico() {
        return diagnostico;
    }

    /**
     * @param diagnostico the diagnostico to set
     */
    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    /**
     * @return the paciente
     */
    public Paciente getPaciente() {
        return paciente;
    }

    /**
     * @param paciente the paciente to set
     */
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    /**
     * @return the medico
     */
    public Medico getMedico() {
        return medico;
    }

    /**
     * @param medico the medico to set
     */
    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    /**
     * @return the horario
     */
    public Horario getHorario() {
        return horario;
    }

    /**
     * @param horario the horario to set
     */
    public void setHorario(Horario horario) {
        this.horario = horario;
    }
}


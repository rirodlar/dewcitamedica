package pe.com.citasmedicas.model;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author dew - Grupo 04
 */
@Entity
@Table(name="cita", schema="cita_medica")
public class Cita extends Bean{

    public static final String ESTADO_RESERVADO = "RESERVADO";
    public static final String ESTADO_ATENDIDO = "ATENDIDO";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="citaId", nullable=false)
    private Integer citaId;

    @Column(name="estado")
    private String estado;

    @Column(name="diagnostico")
    private String diagnostico;

    @ManyToOne(targetEntity=pe.com.citasmedicas.model.Paciente.class, optional=false)
    @JoinColumn(name="pacienteId")
    private Paciente paciente;

    @ManyToOne(targetEntity=pe.com.citasmedicas.model.Medico.class, optional=true)
    @JoinColumn(name="medicoId")
    private Medico medico;

    @OneToOne(targetEntity=pe.com.citasmedicas.model.Horario.class, optional=false)
    @JoinColumn(name="horarioId")
    private Horario horario;

    @Column(name="sintoma", nullable=true, length=250)
    private String sintoma;

    @Column(name="receta", nullable=true, length=250)
    private String receta;

    @Column(name="analisis", nullable=true, length=250)
    private String analisis;

    @Column(name="observaciones", nullable=true, length=250)
    private String observaciones;

    @Column(name="fechaProximaCita", nullable=true)
    @Temporal(value=TemporalType.DATE)
    private Date fechaProximaCita;

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

    /**
     * @return the sintoma
     */
    public String getSintoma() {
        return sintoma;
    }

    /**
     * @param sintoma the sintoma to set
     */
    public void setSintoma(String sintoma) {
        this.sintoma = sintoma;
    }

    /**
     * @return the receta
     */
    public String getReceta() {
        return receta;
    }

    /**
     * @param receta the receta to set
     */
    public void setReceta(String receta) {
        this.receta = receta;
    }

    /**
     * @return the analisis
     */
    public String getAnalisis() {
        return analisis;
    }

    /**
     * @param analisis the analisis to set
     */
    public void setAnalisis(String analisis) {
        this.analisis = analisis;
    }

    /**
     * @return the observaciones
     */
    public String getObservaciones() {
        return observaciones;
    }

    /**
     * @param observaciones the observaciones to set
     */
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    /**
     * @return the fechaProximaCita
     */
    public Date getFechaProximaCita() {
        return fechaProximaCita;
    }

    /**
     * @param fechaProximaCita the fechaProximaCita to set
     */
    public void setFechaProximaCita(Date fechaProximaCita) {
        this.fechaProximaCita = fechaProximaCita;
    }
}


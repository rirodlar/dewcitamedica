package pe.com.citasmedicas.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Hace referencia a una persona, de la cual heredan los datos medico y paciente
 * @author dew - Grupo 04
 */
@Entity
@Table(name="persona", schema="cita_medica")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="tipo", discriminatorType=DiscriminatorType.STRING)
public class Persona extends Bean {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="personaId", nullable=false)
    private Integer personaId;

    @Column(name="nombre", nullable=false, length=25)
    private String nombre;

    @Column(name="apellidoPaterno", nullable=false, length=20)
    private String apellidoPaterno;

    @Column(name="apellidoMaterno", nullable=false, length=20)
    private String apellidoMaterno;

    @Column(name="fechaNacimiento", nullable=false)
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;

    @Column(name="nroDocumento", nullable=true, length=8)
    private String nroDocumento;

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
     * @return the apellidoPaterno
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * @param apellidoPaterno the apellidoPaterno to set
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * @return the apellidoMaterno
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * @param apellidoMaterno the apellidoMaterno to set
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * @return the fechaNacimiento
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * @param fechaNacimiento the fechaNacimiento to set
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * @return fecha nacimiento formateada
     */
    public String getFechaNacimientoFormat(){
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        return df.format(fechaNacimiento);
    }

    /**
     * @return edad
     */
    public int getEdad(){

        Calendar cal1 = new GregorianCalendar();
        cal1.setTimeInMillis(this.fechaNacimiento.getTime());
        Calendar cal2 = new GregorianCalendar();
        cal2.setTimeInMillis(new Date().getTime());

        return cal2.get(Calendar.YEAR) - cal1.get(Calendar.YEAR);
    }

    /**
     * @return the nroDocumento
     */
    public String getNroDocumento() {
        return nroDocumento;
    }

    /**
     * @param nroDocumento the nroDocumento to set
     */
    public void setNroDocumento(String nroDocumento) {
        this.nroDocumento = nroDocumento;
    }

    /**
     * @return el nombre completo;
     */
    public String getNombreCompleto(){
        return getApellidoPaterno() + " " + getApellidoMaterno() + ", " + getNombre();
    }

    /**
     * @return the personaId
     */
    public Integer getPersonaId() {
        return personaId;
    }

    /**
     * @param personaId the personaId to set
     */
    public void setPersonaId(Integer personaId) {
        this.personaId = personaId;
    }
}

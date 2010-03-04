package pe.com.citasmedicas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author dew - Grupo 04
 */
@Entity
@Table(name="usuario", schema="cita_medica")
public class Usuario extends Bean {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="usuarioId", nullable=false)
    private Integer usuarioId;

    @Column(name="username", nullable=false, length=15)
    private String username;

    @Column(name="password", nullable=false, length=15)
    private String password;

    @ManyToOne(targetEntity=pe.com.citasmedicas.model.Persona.class)
    @JoinColumn(name="personaId", nullable=false)
    private Persona persona;

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the persona
     */
    public Persona getPersona() {
        return persona;
    }

    /**
     * @param persona the persona to set
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    /**
     * @return the usuarioId
     */
    public Integer getUsuarioId() {
        return usuarioId;
    }

    /**
     * @param usuarioId the usuarioId to set
     */
    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.citasmedicas.model;

import java.io.Serializable;

/**
 * Clase padre de todos los modelos
 * @author dew - Grupo 04
 */
public class Bean implements Serializable {

    /**
     * Obtiene el nombre de la clase
     * @return nombre de clase
     */
    public String getReferencia() {
        return getClass().getName();
    }
}

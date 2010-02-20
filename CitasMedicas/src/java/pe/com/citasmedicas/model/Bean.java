/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.citasmedicas.model;

import java.io.Serializable;

/**
 *
 * @author dew - Grupo 04
 */
public class Bean implements Serializable {

    public String getReferencia() {
        return getClass().getName();
    }
}

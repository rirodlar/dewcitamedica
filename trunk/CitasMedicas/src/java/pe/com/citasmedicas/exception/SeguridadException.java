/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.citasmedicas.exception;

/**
 * Excepcion se genera cuando se viola la seguridad
 * @author dew - Grupo 04
 */
public class SeguridadException extends Exception {

    public SeguridadException() {
        super("Usuario no autenticado.");
    }
}

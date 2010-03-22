/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.citasmedicas.exception;

/**
 *
 * @author rSaenz
 */
public class SeguridadException extends Exception {

    public SeguridadException() {
        super("Usuario no autenticado.");
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

/**
 *
 * @author jonat
 */
public class NombreException extends Exception {

    /**
     * Creates a new instance of <code>NombreVacioException</code> without
     * detail message.
     */
    public NombreException() {
    }

    /**
     * Constructs an instance of <code>NombreVacioException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public NombreException(String msg) {
        super(msg);
    }
}

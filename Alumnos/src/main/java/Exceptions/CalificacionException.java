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
public class CalificacionException extends Exception {

    /**
     * Creates a new instance of <code>CalificacionErroneaException</code>
     * without detail message.
     */
    public CalificacionException() {
    }

    /**
     * Constructs an instance of <code>CalificacionErroneaException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public CalificacionException(String msg) {
        super(msg);
    }
}
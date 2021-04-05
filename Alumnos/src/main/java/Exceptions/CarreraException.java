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
public class CarreraException extends Exception {

    /**
     * Creates a new instance of <code>CarreraVaciaException</code> without
     * detail message.
     */
    public CarreraException() {
    }

    /**
     * Constructs an instance of <code>CarreraVaciaException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public CarreraException(String msg) {
        super(msg);
    }
}
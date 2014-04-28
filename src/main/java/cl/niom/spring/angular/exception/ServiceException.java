/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.niom.spring.angular.exception;

/**
 *
 * @author Nortiz
 */
public class ServiceException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 2973292612787709922L;

    /**
     * 
     */
    public ServiceException() { super(); }

    /**
     * 
     * @param s
     */
    public ServiceException(String s) { super(s); }

    /**
     * 
     * @param s
     * @param throwable
     */
    public ServiceException(String s, Throwable throwable) { super(s, throwable); }

    /**
     * 
     * @param throwable
     */
    public ServiceException(Throwable throwable) { super(throwable); }

}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.niom.spring.angular.service;

import cl.niom.spring.angular.model.Contacto;
import java.util.List;

/**
 *
 * @author Nortiz
 */
public interface ContactoService {
    
    /**
     * 
     * @return 
     */
    public List<Contacto> getAllContactos();
       
    /**
     * 
     * @param contacto 
     */
    public void addContacto(Contacto contacto);

    /**
     * 
     * @param contacto 
     */
    public void deleteContacto(Contacto contacto);

    /**
     * 
     */
    public void deleteAll();
}

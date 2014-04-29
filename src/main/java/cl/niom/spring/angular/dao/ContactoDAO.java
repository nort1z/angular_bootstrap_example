/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.niom.spring.angular.dao;

import cl.niom.spring.angular.model.Contacto;
import java.util.List;

/**
 *
 * @author Nortiz
 */
public interface ContactoDAO {
    
    /**
     * 
     * @param contacto 
     */
    public void addContacto(Contacto contacto);
     
    /**
     * 
     * @return 
     */
    public List<Contacto> listContacto();
     
    /**
     * 
     * @param contacto 
     */
    public void deleteContacto(String id);
     
    /**
     * 
     * @param contacto 
     */
    public void updateContacto(Contacto contacto);
    
    /**
     * 
     * @param id
     * @return 
     */
    public Contacto findById(String id);
}

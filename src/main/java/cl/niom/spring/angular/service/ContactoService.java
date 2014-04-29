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
    public List<Contacto> extraerContactos();
    
    /**
     * 
     * @param contacto 
     */
    public void ingresarContacto(Contacto contacto);

    /**
     * 
     * @param contacto 
     */
    public void eliminarContacto(String id);
    
    /**
     * 
     * @param id
     * @return 
     */
    public Contacto buscarContacoPorId(String id);
}

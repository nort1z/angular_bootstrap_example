/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.niom.spring.angular.service.impl;

import cl.niom.spring.angular.dao.ContactoDAO;
import cl.niom.spring.angular.exception.ServiceException;
import cl.niom.spring.angular.model.Contacto;
import cl.niom.spring.angular.service.ContactoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nortiz
 */
@Service("contactoService")
public class ContactoServiceImpl implements ContactoService{
    
    @Autowired
    private ContactoDAO contactoDAO;
    
    
    @Override
    public List<Contacto> extraerContactos(){
        try{
            return contactoDAO.listContacto();
        }catch(Exception ex){
            throw new ServiceException("Error al extraer todos los contactos",ex);
        }
    }
    
    
    @Override
    public void ingresarContacto(Contacto contacto) {
        try{
            contactoDAO.addContacto(contacto);
        }catch(Exception ex){
            throw new ServiceException("Error al ingresar un contacto",ex);
        }
    }


    @Override
    public void eliminarContacto(String id) {
        try{
            contactoDAO.deleteContacto(id);
        }catch(Exception ex){
            throw new ServiceException("Error al eliminar un contacto",ex);
        }
    }

    @Override
    public Contacto buscarContacoPorId(String id) {
       try{
            return contactoDAO.findById(id);
        }catch(Exception ex){
            throw new ServiceException("Error al extraer un contacto mediante id",ex);
        } 
    }
}

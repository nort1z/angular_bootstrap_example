/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.niom.spring.angular.service.impl;

import cl.niom.spring.angular.model.Contacto;
import cl.niom.spring.angular.service.ContactoService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nortiz
 */
@Service("contactoService")
public class ContactoServiceImpl implements ContactoService{
    
    
    private static List<Contacto> contactosList = new ArrayList<>();

    
    @Override
    public List<Contacto> getAllContactos() {
        
        contactosList = new ArrayList<>();
        
        Contacto cn = new Contacto();
        cn.setId("1");
        cn.setName("Nelson Ortiz");
        cn.setEmail("nortiz@pragma.cl");
        cn.setPhone("+56977482251");
        contactosList.add(cn);
        
        Contacto cn2 = new Contacto();
        cn2.setId("2");
        cn2.setName("Nelson Ortiz Rojas");
        cn2.setEmail("nortizr@pragma.cl");
        cn2.setPhone("+56977482251");
        contactosList.add(cn2);
        
        return contactosList;
    }
    
    
    @Override
    public void addContacto(Contacto contacto) {
        contactosList.add(contacto);
    }


    @Override
    public void deleteContacto(Contacto contacto) {
        if (contactosList.contains(contacto)) {
            contactosList.remove(contacto);
        }
    }

    @Override
    public void deleteAll() {
        contactosList.clear();
    }
}

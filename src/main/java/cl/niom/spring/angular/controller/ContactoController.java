/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.niom.spring.angular.controller;

import cl.niom.spring.angular.model.Contacto;
import cl.niom.spring.angular.service.ContactoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Nortiz
 */
@Controller
public class ContactoController {
    
   @Autowired
    private ContactoService contactoService;

    @RequestMapping(value = "/contacto/contactosList.json",method = RequestMethod.GET)
    public @ResponseBody List<Contacto> getContactosList() {
        return contactoService.getAllContactos();
    }

    @RequestMapping(value = "/addContacto/{contacto}", method = RequestMethod.POST)
    public @ResponseBody void addContacto(@PathVariable("contacto") Contacto contacto) {
        contactoService.addContacto(contacto);
    }

    @RequestMapping(value = "/removeContacto/{contacto}", method = RequestMethod.DELETE)
    public @ResponseBody void removeContacto(@PathVariable("contacto") Contacto contacto) {
        contactoService.deleteContacto(contacto);
    }

    @RequestMapping(value = "/removeAllContactos", method = RequestMethod.DELETE)
    public @ResponseBody void removeAllContactos() {
        contactoService.deleteAll();
    }
}

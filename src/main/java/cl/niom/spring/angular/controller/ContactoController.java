/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.niom.spring.angular.controller;

import cl.niom.spring.angular.model.Contacto;
import cl.niom.spring.angular.service.ContactoService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Nortiz
 */
@RestController
@RequestMapping("/contacto/")
public class ContactoController {
    
   @Autowired(required = true)
    private ContactoService contactoService;

    @RequestMapping(value = "contactosList.json", method = RequestMethod.GET,produces="application/json")
    @ResponseBody
    public String getContactosList() {
        
        List<Contacto>  lst = contactoService.getAllContactos();
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        builder.disableHtmlEscaping();
                                
        return gson.toJson(lst);
    }

    @RequestMapping(value = "addContacto/{contacto}", method = RequestMethod.GET,headers="Accept=application/json")
    public @ResponseBody void addContacto(@PathVariable("contacto") Contacto contacto) {
        contactoService.addContacto(contacto);
    }

    @RequestMapping(value = "removeContacto/{contacto}", method = RequestMethod.GET,headers="Accept=application/json")
    public @ResponseBody void removeContacto(@PathVariable("contacto") Contacto contacto) {
        contactoService.deleteContacto(contacto);
    }

    @RequestMapping(value = "removeAllContactos", method = RequestMethod.GET,headers="Accept=application/json")
    public @ResponseBody void removeAllContactos() {
        contactoService.deleteAll();
    }
}

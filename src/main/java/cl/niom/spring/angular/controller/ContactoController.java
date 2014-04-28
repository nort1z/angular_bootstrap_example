/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.niom.spring.angular.controller;

import cl.niom.spring.angular.model.Contacto;
import cl.niom.spring.angular.service.ContactoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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

    @RequestMapping(value = "getAllContactos", method = RequestMethod.GET)
    @ResponseBody
    public String getAllContactos() {
        
        List<Contacto>  lst = contactoService.getAllContactos();
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        builder.disableHtmlEscaping();
                                
        return gson.toJson(lst);
    }

    @RequestMapping(value = "addContacto", method = RequestMethod.POST)
    @ResponseBody
    @SuppressWarnings({"BroadCatchBlock", "TooBroadCatch", "CallToPrintStackTrace"})
    public String addContacto(@RequestBody  String jsonContacto) {
        String respuesta = "";
        try{
            if(jsonContacto != null){

                //create ObjectMapper instance
                ObjectMapper objectMapper = new ObjectMapper();
                ObjectReader reader = objectMapper.reader(Contacto.class);
                //convert json string to object
                Contacto contacto = reader.readValue(jsonContacto);
                
                contactoService.addContacto(contacto);
                respuesta = "ok";
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return respuesta;
    }

    @RequestMapping(value = "removeContacto/{contacto}", method = RequestMethod.GET)
    @ResponseBody
    public void removeContacto(@PathVariable("contacto") Contacto contacto) {
        contactoService.deleteContacto(contacto);
    }

    @RequestMapping(value = "removeAllContactos", method = RequestMethod.GET)
    @ResponseBody
    public void removeAllContactos() {
        contactoService.deleteAll();
    }
}

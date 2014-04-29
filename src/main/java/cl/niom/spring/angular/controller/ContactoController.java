/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.niom.spring.angular.controller;

import cl.niom.spring.angular.model.Contacto;
import cl.niom.spring.angular.service.ContactoService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
    @SuppressWarnings({"BroadCatchBlock", "TooBroadCatch", "CallToPrintStackTrace"})
    public String getAllContactos() {
        String json = "";
        try{
            List<Contacto>  lst = contactoService.extraerContactos();
            
            ObjectMapper mapper = new ObjectMapper();
            json = mapper.writerWithType(new TypeReference<List<Contacto>>(){}).writeValueAsString(lst);

        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return json;
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
                
                contactoService.ingresarContacto(contacto);
                respuesta = "ok";
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return respuesta;
    }

    @RequestMapping(value = "removeContacto", method = RequestMethod.POST)
    @ResponseBody
    public void removeContacto(@RequestBody  String id) {
        contactoService.eliminarContacto(id);
    }
    
    @RequestMapping(value = "findContacto", method = RequestMethod.POST)
    @ResponseBody
    @SuppressWarnings({"BroadCatchBlock", "TooBroadCatch", "CallToPrintStackTrace"})
    public String findContacto(@RequestBody  String id) {
        String json = "";
        try{
            Contacto contacto = contactoService.buscarContacoPorId(id);
            
            ObjectMapper mapper = new ObjectMapper();
            json = mapper.writerWithType(new TypeReference<Contacto>(){}).writeValueAsString(contacto);

        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return json;
    }

}

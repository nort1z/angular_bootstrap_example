/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.niom.spring.angular.dao.impl;

import cl.niom.spring.angular.dao.ContactoDAO;
import cl.niom.spring.angular.model.Contacto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Nortiz
 */
@Repository
public class ContactoDAOImpl implements ContactoDAO{
   
    public static final String COLLECTION_NAME = "contacto";
    
    @Autowired
    private MongoTemplate mongoTemplate;
    
    
    @Override
    public void addContacto(Contacto contacto) {
        if (!mongoTemplate.collectionExists(Contacto.class)) {
            mongoTemplate.createCollection(Contacto.class);
        }
        mongoTemplate.insert(contacto, COLLECTION_NAME);
    }
     
    @Override
    public List<Contacto> listContacto() {
        return mongoTemplate.findAll(Contacto.class, COLLECTION_NAME);
    }
     
    @Override
    public void deleteContacto(Contacto contacto) {
        mongoTemplate.remove(contacto, COLLECTION_NAME);
    }
     
    @Override
    public void updateContacto(Contacto contacto) {
        mongoTemplate.insert(contacto, COLLECTION_NAME);      
    }
    
    @Override
    public Contacto findById(String id) {
        return mongoTemplate.findById(id, Contacto.class, COLLECTION_NAME);
    }
    
     
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.niom.spring.angular.initializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 *
 * @author Nortiz
 */
public class AppInitializer  implements WebApplicationInitializer {

    //gets invoked automatically when application starts up
  public void onStartup(ServletContext servletContext) throws ServletException {
    
    //Create ApplicationContext. I'm using the AnnotationConfigWebApplicationContext to avoid using beans xml files.
    AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
       
    
    //Add the servlet mapping manually and make it initialize automatically
    Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));    
    servlet.addMapping("/");    
    servlet.setLoadOnStartup(1);   
  }

}
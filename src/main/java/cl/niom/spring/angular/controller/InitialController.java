/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.niom.spring.angular.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author nort1z
 */
@Controller
public class InitialController {
    
    @RequestMapping("/")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView("/index");
        return mv;
    }
}

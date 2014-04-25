/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.niom.spring.angular.filter;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Nortiz
 */
public class Filtro implements javax.servlet.Filter {
  public FilterConfig filterConfig;                                 //1

  @Override
  public void doFilter(final ServletRequest request,                //2
                       final ServletResponse response,
                       FilterChain chain)
      throws java.io.IOException, javax.servlet.ServletException { 
    

    chain.doFilter(request, response);
  } 

  @Override
  public void init(final FilterConfig filterConfig) {               //4
    this.filterConfig = filterConfig;
  } 

  @Override
  public void destroy() {                                           //5
  }
}

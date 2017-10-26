/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.projetofinal.servlet;

import br.edu.ifpb.projetofinal.anotacoes.CoberturaIgnore;
import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 *
 * @author laerton
 */
@WebListener
public class ServletInicializer implements ServletContextListener {
    
    @Override
    @CoberturaIgnore
    public void contextInitialized(ServletContextEvent sce) {
            sce.getServletContext().addServlet("*.xhtml", FacesServlet.class);
    }

    @Override
    @CoberturaIgnore
    public void contextDestroyed(ServletContextEvent sce) {
    }
    
}
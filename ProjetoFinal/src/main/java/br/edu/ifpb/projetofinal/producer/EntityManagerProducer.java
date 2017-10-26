/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.projetofinal.producer;

import br.edu.ifpb.projetofinal.anotacoes.CoberturaIgnore;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author laerton
 */
public class EntityManagerProducer {
    
    private static EntityManager manager = null;
    
    @Produces
    @CoberturaIgnore
    public static EntityManager getEntityManager() {
        manager = Persistence
                .createEntityManagerFactory("BASEH-PU")
                .createEntityManager();
        return manager;
    }
    
}
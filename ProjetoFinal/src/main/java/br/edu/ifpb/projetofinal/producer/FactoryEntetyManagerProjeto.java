/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.projetofinal.producer;

import br.edu.ifpb.projetofinal.anotacoes.CoberturaIgnore;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author laerton
 */

public class FactoryEntetyManagerProjeto {
 
    private static FactoryEntetyManagerProjeto instance;
    private  FactoryEntetyManagerProjeto() {
    }
    @CoberturaIgnore
    public static FactoryEntetyManagerProjeto getInstance (){
        if (instance == null){
            instance =new FactoryEntetyManagerProjeto();
        }
        return instance;
    }
    @CoberturaIgnore
    public EntityManagerFactory getEMF (){
        EntityManagerFactory  emf = Persistence.createEntityManagerFactory("BASEH-PU");
        return emf;
    }
    
}

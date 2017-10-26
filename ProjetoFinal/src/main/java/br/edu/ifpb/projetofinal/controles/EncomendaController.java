/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.projetofinal.controles;

import br.edu.ifpb.projetofinal.anotacoes.CoberturaIgnore;
import br.edu.ifpb.projetofinal.entidade.Encomenda;
import br.edu.ifpb.projetofinal.exceptions.EncomendaException;
import br.edu.ifpb.projetofinal.servicos.Service;
import java.io.Serializable;
import java.time.LocalDate;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author laerton
 */
@Named
@RequestScoped
public class EncomendaController implements Serializable{
    @Inject
    private Encomenda encomenda;
    private String mensagemErro = "";
    
    @Inject
    private Service<Encomenda> encomendaService;
    
    /***
     * Adiciona uma encomenda no sistema
     * @return 
     */
    public String addEncomenda() {
        try {
            encomenda = encomendaService.salvar(encomenda);
            
        } catch (EncomendaException ex) {
            mensagemErro= ex.getMessage();
        }
        mensagemErro = "Econmenda cadastrada com suscesso.";
        encomenda =new Encomenda();
        return null;
    }

    
    
    public EncomendaController(Service<Encomenda> encomendaService) {
        this.encomendaService = encomendaService;
    }

    public EncomendaController() {
    }

    @CoberturaIgnore
    public String getMensagemErro() {
        return mensagemErro;
    }

    @CoberturaIgnore
    public void setMensagemErro(String mensagemErro) {
        this.mensagemErro = mensagemErro;
    }
    
    @CoberturaIgnore
    public Encomenda getEncomenda() {
        return encomenda;
    }
    
    @CoberturaIgnore
    public void setEncomenda(Encomenda encomenda) {
        
        mensagemErro = "";
        this.encomenda = encomenda;
    }
    /***
     * Lista todas as encomendas em ordem da mais antiga para mais nova 
     * @return 
     */
    public List<Encomenda> getAllEncomendas(){
        mensagemErro = "";
        for (Encomenda encomenda1 : encomendaService.getAll()) {
            System.out.println(encomenda1.getTitulo());
        }
        return  encomendaService.getAll();
    }
    /**
     * Busca uma encomenda a partir do id da mesma 
     * @param id - Id da encomenda
     * @return 
     */
    public String buscaEncomenda (int id){
        mensagemErro = "";
        encomenda =  encomendaService.buscar(id);
        return null;
    }
    
}

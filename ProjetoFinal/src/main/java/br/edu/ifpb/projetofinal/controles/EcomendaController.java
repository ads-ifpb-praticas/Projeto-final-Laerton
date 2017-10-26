/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.projetofinal.controles;

import br.edu.ifpb.projetofinal.entidade.Encomenda;
import br.edu.ifpb.projetofinal.servicos.Service;
import java.time.LocalDate;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author laerton
 */
@Named
@RequestScoped
public class EcomendaController {
    @Inject
    private Encomenda encomenda;

    @Inject
    private Service<Encomenda> encomendaService;
    
    public String addEncomenda(){
         encomendaService.salvar(encomenda);
         encomenda =new Encomenda();
         return null;
    }
    
    public Encomenda getEncomenda() {
        return encomenda;
    }

    public void setEncomenda(Encomenda encomenda) {
        this.encomenda = encomenda;
    }
    
    public List<Encomenda> getAllEncomendas(){
        return  encomendaService.getAll();
    }
    
    public String buscaEncomenda (int id){
        encomenda =  encomendaService.buscar(id);
        return null;
    }
    
}

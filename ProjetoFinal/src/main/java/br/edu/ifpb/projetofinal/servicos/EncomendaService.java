/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.projetofinal.servicos;

import br.edu.ifpb.projetofinal.anotacoes.CoberturaIgnore;
import br.edu.ifpb.projetofinal.entidade.Encomenda;
import br.edu.ifpb.projetofinal.exceptions.EncomendaException;
import br.edu.ifpb.projetofinal.persistencia.IDAO;
import java.util.List;
import javax.inject.Inject;

import java.time.LocalDate;

/**
 * Classe de servico de encomenda
 * @author laerton
 */
public class EncomendaService implements Service<Encomenda>{
    @Inject
    private IDAO<Encomenda> dao;
    private final int DIAS = 6;

    
    public EncomendaService() {
    }

    public EncomendaService(IDAO<Encomenda> dao) {
        this.dao = dao;
    }
    
    
    @Override
    public Encomenda salvar(Encomenda o) throws EncomendaException{
        //ValidaEncomenda.validaDescricao(o.getDescricao());
        //ValidaEncomenda.validaTitulo(o.getTitulo());
        //ValidaEncomenda.validaDtEntrega(o.getDtEntrega(), LocalDate.now());
        if (o.getId() == 0 && o.getDtEntrega() == null){
            o.setDtEntrega(LocalDate.now().plusDays(DIAS));//Processo que garante que 
            //todas as encomendas tem o mesmo prazo.
        }
        
        return dao.salvar(o);
    }

    @Override
    @CoberturaIgnore
    public void excluir(Encomenda o) {
        dao.excluir(o);
    }

    @Override
    public Encomenda buscar(int id) {
        return dao.buscar(id);
    }

    @Override
    public List<Encomenda> getAll() {
        return dao.getAll();
    }

   
    
}

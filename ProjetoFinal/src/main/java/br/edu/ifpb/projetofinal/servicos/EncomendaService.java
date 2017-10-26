/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.projetofinal.servicos;

import br.edu.ifpb.projetofinal.entidade.Encomenda;
import br.edu.ifpb.projetofinal.persistencia.IDAO;
import java.util.List;
import javax.inject.Inject;
import br.edu.ifpb.projetofinal.qualificadores.EncomendaDAO;
import java.time.LocalDate;

/**
 * Classe de servico de encomenda
 * @author laerton
 */
public class EncomendaService implements Service<Encomenda>{
    @Inject
    @EncomendaDAO
    private IDAO<Encomenda> dao;
    private final int DIAS = 6;
    
    @Override
    public Encomenda salvar(Encomenda o) {
        if (o.getId() == 0){
            o.setDtEntrega(LocalDate.now().plusDays(DIAS));//Processo que garante que 
            //todas as encomendas tem o mesmo prazo.
        }
        return dao.salvar(o);
    }

    @Override
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

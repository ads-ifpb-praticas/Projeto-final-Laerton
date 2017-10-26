/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.projetofinal.persistencia;


import br.edu.ifpb.projetofinal.entidade.Encomenda;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author laerton
 */
public class DAOEncomenda implements IDAO<Encomenda>{
    
    @Inject
    private EntityManager em ;

    public DAOEncomenda(EntityManager em) {
        this.em = em;
    }

    public DAOEncomenda() {
    }
    
    
    @Override
    public Encomenda salvar(Encomenda encomenda) {
            try {
            em.getTransaction().begin();
            if (encomenda.getId() != 0){
                em.merge(encomenda);
            }else {
                em.persist(encomenda);
            }
            
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return encomenda;
    }

    @Override
    public void excluir(Encomenda encomenda) {
        try {
            em.getTransaction().begin();
            em.remove(encomenda);
            em.getTransaction().commit();
            
        } catch (Exception e) {
            
            em.getTransaction().rollback();
        }
    }

    @Override
    public Encomenda buscar(int id) {
        return em.find(Encomenda.class, id);
    }
    
    @Override
    public List<Encomenda> getAll(){
        TypedQuery<Encomenda> query = em.createQuery("Select e from Encomenda e ORDER BY e.dtEntrega ASC ", Encomenda.class);
        return query.getResultList();
    }
}

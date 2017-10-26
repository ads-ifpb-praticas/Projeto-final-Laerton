/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.projetofinal.Integracao;

import br.edu.ifpb.projetofinal.entidade.Encomenda;
import br.edu.ifpb.projetofinal.persistencia.DAOEncomenda;
import java.time.LocalDate;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author laerton
 */
public class TestDAOEncomenda {

    private DAOEncomenda dao;
    private Encomenda enc;
    private Encomenda enc1;
    private Encomenda enc2;
    private Encomenda enc3;
    public TestDAOEncomenda() {
    }
    
    
    @Before
    public void setUp() 
    {
        dao = new DAOEncomenda();
        enc = new Encomenda(0, "Compra de pastel", "200 pasteis", LocalDate.now().plusDays(6));
        enc1 = new Encomenda(0, "Compra de pastel", "200 pasteis", LocalDate.now().plusDays(6));
        enc2 = new Encomenda(0, "Compra de pastel", "200 pasteis", LocalDate.now().plusDays(6));
        enc3 = new Encomenda(0, "Compra de pastel", "200 pasteis", LocalDate.now().plusDays(6));
        enc1 = dao.salvar(enc1);
        enc2 = dao.salvar(enc2);
        enc3 = dao.salvar(enc3);
    }
    
    @After
    public void tearDown() 
    {
        dao.excluir(enc);
        dao.excluir(enc1);
        dao.excluir(enc2);
        dao.excluir(enc3);
    }

    @Test
    public void testSalvar() 
    {
        Encomenda resp = dao.salvar(enc);
        assertNotNull(resp);
        assertNotEquals(0, resp.getId());
    }
    
    @Test
    public void testSalvarAlteracao() 
    {
        assertEquals("Compra de pastel", enc2.getTitulo());
        enc2.setTitulo("Novo titulo");
        dao.salvar(enc2);
        Encomenda resp = dao.buscar(enc2.getId());
        assertNotNull(resp);
        assertEquals("Novo titulo", resp.getTitulo());
    }
    
    @Test
    public void testExcluir() 
    {
        dao.excluir(enc2);
        Encomenda resp = dao.buscar(enc2.getId());
        assertNull(resp);
    }
    
    @Test
    public void testBuscar(){
        Encomenda resp = dao.buscar(enc2.getId());
        assertNotNull(resp);
    }
    
    @Test
    public void testGetAll(){
        List<Encomenda> lista = dao.getAll();
        assertNotNull(lista);
        assertNotEquals(0, lista.size());
    }
    
    
}

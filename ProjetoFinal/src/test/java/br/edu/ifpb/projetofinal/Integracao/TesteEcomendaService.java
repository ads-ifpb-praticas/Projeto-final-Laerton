/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.projetofinal.Integracao;

import br.edu.ifpb.projetofinal.entidade.Encomenda;
import br.edu.ifpb.projetofinal.exceptions.EncomendaException;
import br.edu.ifpb.projetofinal.persistencia.DAOEncomenda;
import br.edu.ifpb.projetofinal.servicos.EncomendaService;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author laerton
 */
public class TesteEcomendaService {
    @Mock
    private DAOEncomenda dao;
    private EncomendaService es = new EncomendaService();
    public TesteEcomendaService() {
    }
    
    
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        Encomenda enc = new Encomenda(3, "Compra de pastel", "200 pasteis", LocalDate.now().plusDays(5));
        Encomenda enc1 = new Encomenda(4, "Compra de pastel", "200 pasteis", LocalDate.now().plusDays(6));
        Encomenda enc2 = new Encomenda(2, "Compra de pastel", "200 pasteis", LocalDate.now().plusDays(4));
        Encomenda enc3 = new Encomenda(1, "Compra de pastel", "200 pasteis", LocalDate.now().plusDays(2));
        List<Encomenda> lista = new LinkedList<>();
        lista.add(enc3);
        lista.add(enc2);
        lista.add(enc);
        lista.add(enc1);
        when(dao.buscar(any(Integer.class))).thenReturn(enc1);
        when(dao.getAll()).thenReturn(lista);
        when(dao.salvar(any(Encomenda.class))).thenReturn(enc);
        es =new EncomendaService(dao);
    }
    
    

    @Test
    public void testSalvarNovaEncomenda() throws EncomendaException 
    {
        Encomenda enc1 = new Encomenda(0, "Compra de pastel", "200 pasteis", LocalDate.now().plusDays(6));
        Encomenda result = es.salvar(enc1);
        assertNotNull(result);
        assertTrue(result.getId()==3);
    }
    
    @Test
    public void testSalvarEncomendaExistente() throws EncomendaException 
    {
        Encomenda enc1 = es.buscar(4);
        Encomenda result = es.salvar(enc1);
        assertNotNull(result);
    }
    
    @Test
    public void testBuscar() throws EncomendaException{
        Encomenda result = es.buscar(4);
        assertNotNull(result);
        assertTrue(result.getId()==4);
    }
    
    @Test
    public void testGetAllEncomendas(){
        List<Encomenda> lista = new LinkedList<>();
        assertEquals(0, lista.size());
        lista = es.getAll();
        assertEquals(4, lista.size());
    }
}

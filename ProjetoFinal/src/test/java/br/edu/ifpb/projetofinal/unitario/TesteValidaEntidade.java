/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.projetofinal.unitario;

import br.edu.ifpb.projetofinal.controles.EncomendaController;
import br.edu.ifpb.projetofinal.entidade.Encomenda;
import br.edu.ifpb.projetofinal.exceptions.EncomendaException;
import br.edu.ifpb.projetofinal.validadores.ValidaEncomenda;
import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author laerton
 */
public class TesteValidaEntidade {

    private Encomenda enc1 ;
    private Encomenda enc2 ;
    private Encomenda enc3 ;
    private Encomenda enc4 ;
    private Encomenda enc5;
    private Encomenda enc6;
    private Encomenda enc7;
    private Encomenda enc8;
    private Encomenda enc9;
    private Encomenda enc10;
    private ValidaEncomenda validaEncomenda;
    
    public TesteValidaEntidade() {
    }
    
    
    
    @Before
    public void setUp() {
        //Caso Perfeito
        enc1 = new Encomenda(1, "Prepara pasteis", "Prepara 500 pasteis", LocalDate.now().plusDays(6));
        enc2 = new Encomenda(1, "", "Prepara 500 pasteis", LocalDate.now().plusDays(6));
        enc3 = new Encomenda(1, null, "Prepara 500 pasteis", LocalDate.now().plusDays(6));
        enc4 = new Encomenda(1, "Prepara pasteis", "Prepara 500 pasteis", null);
        enc5 = new Encomenda(1, "Prepara pasteis", "Prepara 500 pasteis", LocalDate.now().plusDays(5));
        enc6 = new Encomenda(1, "Prepara pasteis", "Prepara 500 pasteis", LocalDate.now().plusDays(7));
        enc7 = new Encomenda(1, "Prepara pasteis", "", LocalDate.now().plusDays(6));
        enc8 = new Encomenda(1, "Prepara pasteis", null, LocalDate.now().plusDays(6));
        enc9 = new Encomenda(1, "*(&*^^", "Prepara 500 pasteis", LocalDate.now().plusDays(6));
        enc10 = new Encomenda(1, "Prepara pasteis", "^&^%&^", LocalDate.now().plusDays(6));
        validaEncomenda = new ValidaEncomenda();
    }
    

    @Test
    public void testValidaEncomenda() throws EncomendaException {
        assertTrue(validaEncomenda.validaEncomenda(enc1, LocalDate.now()));
    }
    
    @Test(expected = EncomendaException.class)
    public void testValidaTituloCaracteresInvalidos () throws EncomendaException{
        assertTrue(validaEncomenda.validaEncomenda(enc9, LocalDate.now()));
    }
    
    @Test(expected = EncomendaException.class)
    public void testValidaDescricaoCaracteresInvalidos () throws EncomendaException{
        assertTrue(validaEncomenda.validaEncomenda(enc10, LocalDate.now()));
    }
    
    @Test(expected = EncomendaException.class)
    public void testValidaDescricaoNull () throws EncomendaException{
        assertTrue(validaEncomenda.validaEncomenda(enc8, LocalDate.now()));
    }
    
    @Test(expected = EncomendaException.class)
    public void testValidaDescricaoVazio () throws EncomendaException{
        assertTrue(validaEncomenda.validaEncomenda(enc7, LocalDate.now()));
    }
    
    @Test(expected = EncomendaException.class)
    public void testValidaDtEntregaInferior () throws EncomendaException{
        assertTrue(validaEncomenda.validaEncomenda(enc5, LocalDate.now()));
    }
    
    @Test(expected = EncomendaException.class)
    public void testValidaDtEntregaSuperior () throws EncomendaException{
        assertTrue(validaEncomenda.validaEncomenda(enc6, LocalDate.now()));
    }
    
    @Test(expected = EncomendaException.class)
    public void testValidaDtEntregaNull () throws EncomendaException{
        assertTrue(validaEncomenda.validaEncomenda(enc4, LocalDate.now()));
    }
    
    
    @Test(expected = EncomendaException.class)
    public void testValidaTituloNull () throws EncomendaException{
        assertTrue(validaEncomenda.validaEncomenda(enc3, LocalDate.now()));
    }
    
    @Test(expected = EncomendaException.class)
    public void testValidaTituloVazio () throws EncomendaException{
        assertTrue(validaEncomenda.validaEncomenda(enc2, LocalDate.now()));
    }
    
    
    
}

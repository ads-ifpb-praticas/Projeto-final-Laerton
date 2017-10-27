/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.projetofinal.unitario;

import br.edu.ifpb.projetofinal.producer.LocalDateFacesConverter;
import java.time.LocalDate;
import java.time.Month;
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
public class TesteLocalDateFaceConvert {
    
    public TesteLocalDateFaceConvert() {
    }
    /*
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }*/

    @Test
    public void testeConvertStringToLocalDate() 
    {
        LocalDateFacesConverter LDFC = new LocalDateFacesConverter();
        Object obj =  LDFC.getAsObject(null, null, "28/10/2017");
        assertEquals(28, ((LocalDate)obj).getDayOfMonth());
    }
    
    @Test
    public void testeConverLocalDatetoString() 
    {
        LocalDateFacesConverter LDFC = new LocalDateFacesConverter();
        LocalDate data = LocalDate.of(2017,3,7);
        String obj =  LDFC.getAsString(null, null, data);
        assertEquals("07/03/2017", obj);
        
    }
}

package br.edu.ifpb.projetofinal.producer;


import br.edu.ifpb.projetofinal.anotacoes.CoberturaIgnore;
import java.sql.Date;
import java.time.LocalDate;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author laerton
 */

public interface AttributeConverter<T,Q> {
    /***
     * Converte de LocalDate para SqlDate
     * @param locDate
     * @return 
     */
    Date convertToDatabaseColumn(T locDate);
    /***
     * Converte de SqlDate para LocalDate
     * @param sqlDate
     * @return 
     */
    LocalDate convertToEntityAttribute(Q sqlDate);
}

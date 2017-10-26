package br.edu.ifpb.projetofinal.producer;


import br.edu.ifpb.projetofinal.anotacoes.CoberturaIgnore;
import java.sql.Date;
import java.time.LocalDate;
import javax.persistence.Converter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author laerton
 */
@Converter(autoApply = true)

public class LocalDateAttributeConverter implements AttributeConverter<LocalDate, Date> {

    @Override
    @CoberturaIgnore
    public Date convertToDatabaseColumn(LocalDate locDate) {
        return (locDate == null ? null : Date.valueOf(locDate));
    }

    @Override
    @CoberturaIgnore
    public LocalDate convertToEntityAttribute(Date sqlDate) {
        return (sqlDate == null ? null : sqlDate.toLocalDate());
    }
}
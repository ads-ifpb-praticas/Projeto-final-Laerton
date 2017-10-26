/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.projetofinal.validadores;

import br.edu.ifpb.projetofinal.entidade.Encomenda;
import br.edu.ifpb.projetofinal.exceptions.EncomendaException;
import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author laerton
 */
public class ValidaEncomenda {
    
    private final  static int DIAS = 6;
    
    public static boolean validaEncomenda (Encomenda encomenda,LocalDate dtEncomenda) throws EncomendaException{
        return (validaDescricao(encomenda.getDescricao()) && validaTitulo(encomenda.getTitulo()) && validaDtEntrega(encomenda.getDtEntrega(), dtEncomenda));
    }
            
    
    public static boolean validaTitulo (String titulo) throws EncomendaException{
        if (titulo ==null){
            throw  new EncomendaException("Titulo nao pode ser nulo.");
        }
        
        if (titulo.trim().equals("")){
            throw  new EncomendaException("Titulo nao pode ser em branco.");
        }
        
        Pattern p = Pattern.compile("^[a-zA-Z0-9!#? \\p{L}]+$");
        Matcher m = p.matcher(titulo);
        if(!m.matches())
            throw new EncomendaException("O Titulo nao pode conter #,! or ? ou caracteres especiais!");
        return true;
    }
    
    public static boolean validaDescricao (String descricao)throws EncomendaException{
        if (descricao ==null){
            throw  new EncomendaException("Descricao nao pode ser nulo.");
        }
        
        if (descricao.trim().equals("")){
            throw  new EncomendaException("Descricao nao pode ser em branco.");
        }
        
        Pattern p = Pattern.compile("^[a-zA-Z0-9!#? \\p{L}]+$");
        Matcher m = p.matcher(descricao);
        if(!m.matches())
            throw new EncomendaException("O Descricao nao pode conter #,! or ? ou caracteres especiais!");
        return true;
    }
    /***
     * Valida se a data da entrega comparada a data compra nao seja diferente do prazo padrao de 6 dias 
     * @param dtEntrega - data de previsao de entrega
     * @param dtCompara - data de lancamento do pedido
     * @return - Booleano de confirmacao
     * @throws EncomendaException - Caso a difrenca seja diferente de 6
     */
    public static boolean validaDtEntrega (LocalDate dtEntrega, LocalDate dtCompara )throws EncomendaException{
        if (dtEntrega == null){
            throw new EncomendaException("Data de enttrega nao pode ser nula");
        }
        
        Period p = Period.between(dtCompara, dtEntrega);
        int d = p.getDays();
        if (d != DIAS){
            throw new EncomendaException("A previsao de entrega deve ser igual a todas as encomendas.");
        }
        return true;
    }
    
}

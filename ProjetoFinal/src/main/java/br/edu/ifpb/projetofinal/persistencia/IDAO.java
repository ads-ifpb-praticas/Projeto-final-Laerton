/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.projetofinal.persistencia;


import java.util.List;

/**
 *
 * @author laerton
 */
public interface IDAO <T> {
    
    /**
     * Salva o novo objeto ou edicao de um objeto ja existente na base de dados.
     * @param o - Objeto a ser salvo
     * @return - Objeto apos persistido
     */
    T salvar(T o);
    /***
     * Exclui um objeto da base de dados
     * @param o - Objeto a ser excluido
     */
    void excluir(T o);
    /**
     * Retorna um objeto a partir do id repassado como paramentro 
     * @param id
     * @return 
     */
    T buscar(int id);
    /***
     * Retorna uma lista com todos os objetos do banco de dados
     * @return - Lista de objetos
     */
    List<T> getAll();
}

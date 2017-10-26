/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.projetofinal.entidade;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

/**
 *
 * @author laerton
 */
@Entity
@TableGenerator(name = "ENCOMENDA_SEQ", allocationSize = 1)
public class Encomenda {
   @Id
   @GeneratedValue(generator = "ENCOMENDA_SEQ", 
            strategy = GenerationType.TABLE)
   private int id;
   @Column(length = 255, nullable = false)
   private String titulo;
   @Column(length = 255, nullable = false)
   private String descricao;
   @Column
   private LocalDate dtEntrega;

    public Encomenda() {
    }

    public Encomenda(int id, String titulo, String descricao, LocalDate dtEntrega) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.dtEntrega = dtEntrega;
    }
   
   
   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDtEntrega() {
        return dtEntrega;
    }

    public void setDtEntrega(LocalDate dtEntrega) {
        this.dtEntrega = dtEntrega;
    }

   
    
   
   
   
   
   
    
}

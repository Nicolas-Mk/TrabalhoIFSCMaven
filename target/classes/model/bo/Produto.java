/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tblproduto")
/**
 *
 * @author aluno
 */
public class Produto implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column
    private String descricao;
    
    @Column
    private String codigoBarra;
    
    @Column
    private String status;
    
    @Column
    private float preco;

    public Produto() {
    }

    public Produto(int id, String descricao, String codigoBarra, String status, float preco) {
        this.id = id;
        this.descricao = descricao;
        this.codigoBarra = codigoBarra;
        this.status = status;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
    
    @Override
    public String toString() {
        return this.getId() + " "+
                this.getDescricao() + " "+
                this.getCodigoBarra()+ " "+
                this.getStatus() + " ";
                
    }
    
    
}

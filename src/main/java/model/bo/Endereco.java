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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tblendereco")
/**
 *
 * @author aluno
 */
public class Endereco implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String cep;
    
    @Column
    private String logradouro;
    
    @Column
    private String status;

    @JoinColumn(name = "tblbairro_id")
    @ManyToOne
    public Bairro bairro;
    
    @JoinColumn (name = "tblcidade_id")
    @ManyToOne
    public Cidade cidade;

    public Endereco() {
    }

    public Endereco(int id, String cep, String logradouro, String status, Bairro bairro, Cidade cidade) {
        this.id = id;
        this.cep = cep;
        this.logradouro = logradouro;
        this.status = status;
        this.cidade = cidade;
        this.bairro = bairro;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    
    
    @Override
    public String toString() {
        return this.getCep() + ' '
                + this.getLogradouro() + ' '
                + this.bairro.getDescricao() + ' '
                + this.cidade.getDescricao() + ' '
                + this.getStatus() + ' ';

    }

    
    
}

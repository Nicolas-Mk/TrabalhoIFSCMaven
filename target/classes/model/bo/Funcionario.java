/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bo;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
/**
 *
 * @author aluno
 */
public class Funcionario extends Pessoa{
    @Column
    private String cpf;
    
    @Column
    private String rg;
    
    @Column
    private String usuario;
    
    @Column
    private String senha;

    
    public Funcionario() {
    }

    public Funcionario(String cpf, String rg, String usuario, String senha) {
        this.cpf = cpf;
        this.rg = rg;
        this.usuario = usuario;
        this.senha = senha;
    }

    public Funcionario(String cpf, String rg, String usuario, String senha, int id, String nome, String fone1, String fone2, String email, String status, String complementoEndereco) {
        super(id, nome, fone1, fone2, email, status, complementoEndereco);
        this.cpf = cpf;
        this.rg = rg;
        this.usuario = usuario;
        this.senha = senha;
    }

    
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return  this.getCpf()+" "+
                this.getRg()+" "+
                this.getUsuario()+" "+
                this.getSenha()+" ";        
    }
    
    
}

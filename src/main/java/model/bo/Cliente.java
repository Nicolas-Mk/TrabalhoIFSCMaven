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
public class Cliente extends Pessoa{
    
    @Column
    private String cpf;
    
    @Column
    private String rg;
    
    @Column
    private String matricula;
    
    @Column
    private String dataNascimento;
    
    
    public Cliente() {
    }

    
    public Cliente(String cpf, String rg, String matricula, String dataNascimento) {
        this.cpf = cpf;
        this.rg = rg;
        this.matricula = matricula;
        this.dataNascimento = dataNascimento;
    }

    public Cliente(String cpf, String rg, String matricula, String dataNascimento, int id, String nome, String fone1, String fone2, String email, String status, String complementoEndereco) {
        super(id, nome, fone1, fone2, email, status, complementoEndereco);
        this.cpf = cpf;
        this.rg = rg;
        this.matricula = matricula;
        this.dataNascimento = dataNascimento;
    }


    
    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
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

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return this.getCpf() + " " +
                this.getRg() + " " +          
                this.getMatricula() + " "+
                this.getDataNascimento() + " ";

                
    }
    
    
}

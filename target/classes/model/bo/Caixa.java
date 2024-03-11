/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
/**
 *
 * @author aluno
 */
public class Caixa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column
    private String dataHoraAbertura;
    
    @Column
    private String dataHoraFechamento;
    
    @Column
    private float valorAbertura;
    
    @Column
    private float valorFechamento;
    
    @Column
    private String observacao;
    
    @Column
    private char status;

    @JoinColumn
    @ManyToOne
    private Funcionario funcionario;
    
    public Caixa() {
    }

    public Caixa(int id, String dataHoraAbertura, String dataHoraFechamento, float valorAbertura, float valorFechamento, String observacao, char status) {
        this.id = id;
        this.dataHoraAbertura = dataHoraAbertura;
        this.dataHoraFechamento = dataHoraFechamento;
        this.valorAbertura = valorAbertura;
        this.valorFechamento = valorFechamento;
        this.observacao = observacao;
        this.status = status;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataHoraAbertura() {
        return dataHoraAbertura;
    }

    public void setDataHoraAbertura(String dataHoraAbertura) {
        this.dataHoraAbertura = dataHoraAbertura;
    }

    public String getDataHoraFechamento() {
        return dataHoraFechamento;
    }

    public void setDataHoraFechamento(String dataHoraFechamento) {
        this.dataHoraFechamento = dataHoraFechamento;
    }

    public float getValorAbertura() {
        return valorAbertura;
    }

    public void setValorAbertura(float valorAbertura) {
        this.valorAbertura = valorAbertura;
    }

    public float getValorFechamento() {
        return valorFechamento;
    }

    public void setValorFechamento(float valorFechamento) {
        this.valorFechamento = valorFechamento;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @Override
    public String toString() {
        return this.getId() + " "+
                this.getDataHoraAbertura() + " " +
                this.getDataHoraFechamento() + " "+
                this.getValorAbertura() +  " "+
                this.getValorFechamento() + " "+
                this.getObservacao() + " "+
                this.getStatus() + " " +
                this.funcionario.getCpf()+" "+
                this.funcionario.getRg()+" "+
                this.funcionario.getUsuario()+" "+
                this.funcionario.getSenha()+" ";        
                
    }
    
    
    
}

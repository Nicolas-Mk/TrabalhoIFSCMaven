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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
/**
 *
 * @author aluno
 */
public class MovimentoCaixa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column
    private String dataHoraMovimento;
    
    @Column
    private float valorMovimento;
    
    @Column
    private String observacao;
    
    @Column
    private char flagTipoMovimento;
    
    @Column
    private char status;
    
    @JoinColumn
    @ManyToOne
    private Caixa caixa;
    
    
    public MovimentoCaixa() {
    }

    public MovimentoCaixa(int id, String dataHoraMovimento, float valorMovimento, String observacao, char flagTipoMovimento, char status, Caixa caixa) {
        this.id = id;
        this.dataHoraMovimento = dataHoraMovimento;
        this.valorMovimento = valorMovimento;
        this.observacao = observacao;
        this.flagTipoMovimento = flagTipoMovimento;
        this.status = status;
        this.caixa = caixa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataHoraMovimento() {
        return dataHoraMovimento;
    }

    public void setDataHoraMovimento(String dataHoraMovimento) {
        this.dataHoraMovimento = dataHoraMovimento;
    }

    public float getValorMovimento() {
        return valorMovimento;
    }

    public void setValorMovimento(float valorMovimento) {
        this.valorMovimento = valorMovimento;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public char getFlagTipoMovimento() {
        return flagTipoMovimento;
    }

    public void setFlagTipoMovimento(char flagTipoMovimento) {
        this.flagTipoMovimento = flagTipoMovimento;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public Caixa getCaixa() {
        return caixa;
    }

    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }

    

    @Override
    public String toString() {
        return this.getId() + " "+
                this.getDataHoraMovimento() + " "+
                this.getValorMovimento() + " "+
                this.getObservacao() + " "+
                this.getFlagTipoMovimento() + " "+
                this.getStatus() + " "+
                this.getId() +" "+
                this.caixa.getId() + " "+
                this.caixa.getDataHoraAbertura() + " " +
                this.caixa.getDataHoraFechamento() + " "+
                this.caixa.getValorAbertura() +  " "+
                this.caixa.getValorFechamento() + " "+
                this.caixa.getObservacao() + " "+
                this.caixa.getStatus() + " ";
       
    }
    
    
    
}

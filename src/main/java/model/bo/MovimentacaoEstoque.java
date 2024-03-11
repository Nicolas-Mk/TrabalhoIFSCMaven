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
import javax.persistence.OneToMany;

@Entity
/**
 *
 * @author aluno
 */
public class MovimentacaoEstoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column
    private String dataHoraMovimento;
    
    @Column
    private char flagTipoMovimento;
    
    @Column
    private float qtdMovimentada;
    
    @Column
    private String observacaoMovimento;
    
    @Column
    private char status;

    @JoinColumn
    @OneToMany
    private Produto produto;
    
    @OneToMany
    @JoinColumn
    private ItemVenda itemVenda;
    
    @OneToMany
    @JoinColumn
    private ItemCompra itemCompra;
    
    @ManyToOne
    @JoinColumn
    private Funcionario funcionario;

    public MovimentacaoEstoque() {
    }

    public MovimentacaoEstoque(int id, String dataHoraMovimento, char flagTipoMovimento, float qtdMovimentada, String observacaoMovimento, char status) {
        this.id = id;
        this.dataHoraMovimento = dataHoraMovimento;
        this.flagTipoMovimento = flagTipoMovimento;
        this.qtdMovimentada = qtdMovimentada;
        this.observacaoMovimento = observacaoMovimento;
        this.status = status;
    }

    public String getObservacaoMovimento() {
        return observacaoMovimento;
    }

    public void setObservacaoMovimento(String observacaoMovimento) {
        this.observacaoMovimento = observacaoMovimento;
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

    public char getFlagTipoMovimento() {
        return flagTipoMovimento;
    }

    public void setFlagTipoMovimento(char flagTipoMovimento) {
        this.flagTipoMovimento = flagTipoMovimento;
    }

    public float getQtdMovimentada() {
        return qtdMovimentada;
    }

    public void setQtdMovimentada(float qtdMovimentada) {
        this.qtdMovimentada = qtdMovimentada;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return this.getId() + " "
                + this.getDataHoraMovimento() + " "
                + this.getFlagTipoMovimento() + " "
                + this.getQtdMovimentada() + " "
                + this.getObservacaoMovimento() + " "
                + this.getStatus() + " "
                + this.produto.getId() + " "
                + this.produto.getDescricao() + " "
                + this.produto.getCodigoBarra() + " "
                + this.produto.getStatus() + " "
                + this.itemCompra.getId() + " "
                + this.itemCompra.getQtdProduto() + " "
                + this.itemCompra.getValorUnitario() + " "
                + this.itemCompra.getStatus() + " "
                + this.itemVenda.getId() + " "
                + this.itemVenda.getQtdProduto() + " "
                + this.itemVenda.getValorUnitario() + " "
                + this.itemVenda.getStatus() + " "
                + this.funcionario.getCpf() + " "
                + this.funcionario.getRg() + " "
                + this.funcionario.getUsuario() + " "
                + this.funcionario.getSenha() + " ";

    }

}

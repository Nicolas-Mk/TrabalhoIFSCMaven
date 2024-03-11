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
import javax.persistence.OneToOne;

@Entity
/**
 *
 * @author aluno
 */
public class ItemVenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column
    private float qtdProduto;
    
    @Column
    private float valorUnitario;
    
    @Column
    private String status;

    @JoinColumn
    @ManyToOne
    private Venda venda;
    
    @ManyToMany
    @JoinColumn
    private Carteirinha carteirinha;
    
    @ManyToMany
    @JoinColumn
    private Produto produto;

    
    
    public ItemVenda(){};

    public ItemVenda(int id, float qtdProduto, float valorUnitario, String status, Venda venda, Carteirinha carteirinha, Produto produto) {
        this.id = id;
        this.qtdProduto = qtdProduto;
        this.valorUnitario = valorUnitario;
        this.status = status;
        this.venda = venda;
        this.carteirinha = carteirinha;
        this.produto = produto;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getQtdProduto() {
        return qtdProduto;
    }

    public void setQtdProduto(float qtdProduto) {
        this.qtdProduto = qtdProduto;
    }

    public float getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(float valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Carteirinha getCarteirinha() {
        return carteirinha;
    }

    public void setCarteirinha(Carteirinha carteirinha) {
        this.carteirinha = carteirinha;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public String toString() {
        return this.getId() + " "
                + this.getQtdProduto() + " "
                + this.getValorUnitario() + " "
                + this.getStatus() + " "
                + this.venda.getId() + " "
                + this.venda.getDataVenda() + " "
                + this.venda.getHoraVenda() + " "

//                + this.venda.getDataHoraVenda() + " "
//                + this.venda.getValorDesconto() + " "
//                + this.venda.getFlagTipoDesconto() + " "
                + this.venda.getObservacao() + " "
                + this.venda.getStatus();
    
    
    
    }

}

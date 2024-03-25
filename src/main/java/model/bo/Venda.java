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
import javax.persistence.OneToOne;

@Entity
/**
 *
 * @author aluno
 */
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column
    private String dataVenda;
    
    @Column
    private String horaVenda;
    
    @Column
    private float valorVenda;
    
    @Column
    private String observacao;
    
    @Column
    private String status;

    @JoinColumn
    @ManyToOne
    private Funcionario funcionario;
    
    @JoinColumn
    @ManyToOne
    private Carteirinha carteirinha;

    public Venda() {
    }

    ;

    public Venda(int id, String dataVenda, String horaVenda, float valorVenda, String observacao, String status, Funcionario funcionario, Carteirinha carteirinha) {
        this.id = id;
        this.dataVenda = dataVenda;
        this.horaVenda = horaVenda;
        this.valorVenda = valorVenda;
        this.observacao = observacao;
        this.status = status;
        this.funcionario = funcionario;
        this.carteirinha = carteirinha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public String getHoraVenda() {
        return horaVenda;
    }

    public void setHoraVenda(String horaVenda) {
        this.horaVenda = horaVenda;
    }

    public float getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(float valorVenda) {
        this.valorVenda = valorVenda;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Carteirinha getCarteirinha() {
        return carteirinha;
    }

    public void setCarteirinha(Carteirinha carteirinha) {
        this.carteirinha = carteirinha;
    }


    @Override
    public String toString() {
        return this.getId() + ""
                + this.getDataVenda() + ""
                + this.getHoraVenda() + ""
                + this.getValorVenda() + ""
                + this.getObservacao() + ""
                + this.getStatus() + ""
                + this.funcionario.getCpf() + ""
                + this.funcionario.getRg() + ""
                + this.funcionario.getUsuario() + ""
                + this.funcionario.getSenha() + "";
    }

}

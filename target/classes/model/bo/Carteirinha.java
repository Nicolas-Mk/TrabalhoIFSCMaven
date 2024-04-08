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
import javax.persistence.Table;

@Entity
@Table(name="tblcarteirinha")
/**
 *
 * @author aluno
 */
public class Carteirinha implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column
    private String codigoBarra;
    
    @Column
    private String dataGeracao;
    
    @Column
    private String dataCancelamento;
    
    @Column
    private String status;

    @JoinColumn
    @ManyToOne
    private Cliente cliente;

    public Carteirinha() {
    }

    public Carteirinha(int id, String codigoBarra, String dataGeracao, String dataCancelamento, Cliente cliente, String status) {
        this.id = id;
        this.codigoBarra = codigoBarra;
        this.dataGeracao = dataGeracao;
        this.dataCancelamento = dataCancelamento;
        this.cliente = cliente;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDataCancelamento() {
        return dataCancelamento;
    }

    public void setDataCancelamento(String dataCancelamento) {
        this.dataCancelamento = dataCancelamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public String getDataGeracao() {
        return dataGeracao;
    }

    public void setDataGeracao(String dataGeracao) {
        this.dataGeracao = dataGeracao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return this.getId() + " "
                + this.getCodigoBarra() + " "
                + this.getDataGeracao() + " "
                + this.getDataCancelamento() + " "
                + this.cliente.getCpf() + " "
                + this.cliente.getRg() + " "
                + this.cliente.getMatricula() + " "
                + this.cliente.getDataNascimento() + " ";

    }

}

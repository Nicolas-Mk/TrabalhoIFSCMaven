/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
*/
package DAO;

import java.util.ArrayList;
import model.bo.*;

/**
 *
 * @author aluno
*/
public class Persiste {
    
    public static Persiste instance;
    
    
   public static ArrayList<Bairro> bairroList ;
   public static ArrayList<Caixa> caixaLista ;
   public static ArrayList<Carteirinha> carteirinhaList  ;
   public static ArrayList<Cidade> cidadeList;
   public static ArrayList<Cliente> clienteList ;
   public static ArrayList<Compra> compraList ;
   public static ArrayList<Contas> contaList ;
   public static ArrayList<Endereco> enderecoList ;
   public static ArrayList<Fornecedor> fornecedorList ;
   public static ArrayList<Funcionario> funcionarioList ;
   public static ArrayList<ItemCompra> itemCompraList ;
   public static ArrayList<ItemVenda> itemVendaList;
   public static ArrayList<MovimentacaoEstoque> movimentacaoEstoqueList ;
   public static ArrayList<MovimentoCaixa> movimentoCaixaList ;
   public static ArrayList<Produto> produtoList;
   public static ArrayList<Venda> vendaList ;
 
    private Persiste(){
    
        bairroList = new ArrayList<>();
        caixaLista = new ArrayList<>();
        carteirinhaList = new ArrayList<>();
        cidadeList = new ArrayList<>();
        clienteList = new ArrayList<>();
        compraList = new ArrayList<>();
        contaList = new ArrayList<>();
        enderecoList = new ArrayList<>();
        fornecedorList = new ArrayList<>();
        funcionarioList = new ArrayList<>();
        itemCompraList = new ArrayList<>();
        itemVendaList = new ArrayList<>();
        movimentacaoEstoqueList = new ArrayList<>();
        movimentoCaixaList = new ArrayList<>();
        produtoList = new ArrayList<>();
        vendaList = new ArrayList<>();
        
    }
    
    public static synchronized  Persiste getInstance(){ 
    
        if(instance == null){
            instance = new Persiste();
                    
        }
    return  instance; 
}
    
    
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.util.List;
import DAO.DAOProduto;
import model.bo.Produto;

/**
 *
 * @author aluno
 */
public class ProdutoService {

    public static void adicionar(Produto objeto) {
        DAOProduto produtoDAO = new DAOProduto();
        produtoDAO.create(objeto);

    }

    public static List<Produto> carregar() {
        DAOProduto produtoDAO = new DAOProduto();
        return produtoDAO.retrieve();

    }

    public static Produto carregar(int parPK) {
        DAOProduto produtoDAO = new DAOProduto();
        return produtoDAO.retrieve(parPK);

    }

    public static List<Produto> carregar(String parString) {
        DAOProduto produtoDAO = new DAOProduto();
        return produtoDAO.retrieve(parString);

    }
    
    public static void atualizar(Produto objeto) {
        DAOProduto produtoDAO = new DAOProduto();
        produtoDAO.update(objeto);

    }
     public static void remover (Produto objeto) {
        DAOProduto produtoDAO = new DAOProduto();
        produtoDAO.delete(objeto);

    }
    
     public static Produto carregarProduto(String cod){
        DAOProduto produtoDAO = new DAOProduto();
        return produtoDAO.RetornaDeLadinho(cod);
     
     } 
     
//       public static Produto carregarIDproduto(String cod){
//        DAOProduto produtoDAO = new DAOProduto();
//        return produtoDAO.RetornaIDproduto(cod);
//     
//     } 
    
}

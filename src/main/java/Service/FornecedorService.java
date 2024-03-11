/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.util.List;
import DAO.DAOFornecedor;
import model.bo.Fornecedor;

/**
 *
 * @author aluno
 */
public class FornecedorService {

    public static void adicionar(Fornecedor objeto) {
        DAOFornecedor fornecedorDAO = new DAOFornecedor();
        fornecedorDAO.create(objeto);

    }

    public static List<Fornecedor> carregar() {
        DAOFornecedor fornecedorDAO = new DAOFornecedor();
        return fornecedorDAO.retrieve();

    }

    public static Fornecedor carregar(int parPK) {
        DAOFornecedor fornecedorDAO = new DAOFornecedor();
        return fornecedorDAO.retrieve(parPK);

    }

    public static List<Fornecedor> carregar(String parString) {
        DAOFornecedor fornecedorDAO = new DAOFornecedor();
        return  fornecedorDAO.retrieve(parString);

    }
    
    public static void atualizar(Fornecedor objeto) {
        DAOFornecedor fornecedorDAO = new DAOFornecedor();
        fornecedorDAO.update(objeto);

    }
     public static void remover (Fornecedor objeto) {
        DAOFornecedor fornecedorDAO = new DAOFornecedor();
        fornecedorDAO.delete(objeto);

    }
     
    
}

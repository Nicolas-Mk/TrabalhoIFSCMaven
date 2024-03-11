/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.util.List;
import DAO.DAOCidade;
import model.bo.Cidade;

/**
 *
 * @author aluno
 */
public class CidadeService {

    public static void adicionar(Cidade objeto) {
        DAOCidade cidadeDAO = new DAOCidade();
        cidadeDAO.create(objeto);

    }

    public static List<Cidade> carregar() {
        DAOCidade cidadeDAO = new DAOCidade();
        return cidadeDAO.retrieve();

    }

    public static Cidade carregar(int parPK) {
        DAOCidade cidadeDAO = new DAOCidade();
        return cidadeDAO.retrieve(parPK);

    }

    public static List<Cidade> carregar(String parString) {
        DAOCidade cidadeDAO = new DAOCidade();
        return cidadeDAO.retrieve(parString);

    }
    
    public static void atualizar(Cidade objeto) {
        DAOCidade cidadeDAO = new DAOCidade();
        cidadeDAO.update(objeto);

    }
     public static void remover (Cidade objeto) {
        DAOCidade cidadeDAO = new DAOCidade();
        cidadeDAO.delete(objeto);

    }
     
}